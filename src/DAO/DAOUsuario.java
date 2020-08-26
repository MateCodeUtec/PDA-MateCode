package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DatabaseManager;
import modelo.Rol;
import modelo.Usuario;

public class DAOUsuario {
	private final String BUSCAR_MAIL = "SELECT * FROM PERSONA p INNER JOIN ROL r ON p.ID_ROL = r.ID_ROL WHERE MAIL = ? ";
	private final String INSERT = "INSERT INTO PERSONA (ID_PERSONA, DOCUMENTO, APELLIDO1, NOMBRE1, FECHA_NAC, CLAVE, ID_ROL, MAIL) "
			+ "VALUES(SEQ_ID_PERSONA.nextval,?,?,?,?,?,?,?)";
	private final String ALL_USUARIOS = "SELECT * FROM PERSONA p";
	private final String UPDATE = "UPDATE PERSONA SET APELLIDO1 = ?, NOMBRE1 = ?, FECHA_NAC = ?, CLAVE = ?, ID_ROL = ?, MAIL = ?"
			+ " WHERE DOCUMENTO = ?";
	private final String FIND_USUARIO = "SELECT * FROM PERSONA p INNER JOIN ROL r ON p.ID_ROL = r.ID_ROL WHERE documento = ?";
	private final String DELETE_USUARIO = "DELETE FROM PERSONA WHERE documento = ?";
	
	
	// Constructor privado para poder hacer uso del singleton
	private DAOUsuario() {
	}

	// Singleton
	private static DAOUsuario instancia = null;

	public static DAOUsuario getInstancia() {
		if (instancia == null) {
			return new DAOUsuario();
		}
		return instancia;
	}
	

	/**
	 * Obtiene un usuario por correo de la base de datos
	 * 
	 * @return Usuario
	 */
	public Usuario obtenerUsuarioPorCorreo(String correo) {
		Usuario usuario = null;

		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(BUSCAR_MAIL);
			sentencia.setString(1, correo);
			ResultSet rs = sentencia.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setDocumento(rs.getString("DOCUMENTO"));
				usuario.setApellido(rs.getString("APELLIDO1"));
				usuario.setNombre(rs.getString("NOMBRE1"));
				usuario.setClave(rs.getString("CLAVE"));
				usuario.setCorreo(rs.getString("MAIL"));
				usuario.setFechaNacimiento(rs.getDate("FECHA_NAC"));
				usuario.setRolId(rs.getInt("ID_ROL"));

				/**
				 * Cual es la mejor forma de hacer esto
				 */
				Rol r = new Rol();
				r.setId(rs.getInt("ID_ROL"));
				r.setNombre(rs.getString("NOMBRE"));
				r.setDescripcion(rs.getString("DESCRIPCION"));

				usuario.setRol(r);
			}

		} catch (Exception e) {
			System.err.println("[CONSULTA] Error al ejecutar la consulta: " + BUSCAR_MAIL);
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Ingresa una persona a la base de datos
	 * 
	 * @param u
	 * @return boolean
	 */
	public boolean insert(Usuario u) {

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT);
			statement.setString(1, u.getDocumento());
			statement.setString(2, u.getApellido());
			statement.setString(3, u.getNombre());
			statement.setDate(4, new java.sql.Date(u.getFechaNacimiento().getTime()));
			statement.setString(5, u.getClave());
			statement.setInt(6, u.getRolId());
			statement.setString(7, u.getCorreo());
			int retorno = statement.executeUpdate();

			return retorno > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtiene todos los usuarios de la base de datos
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> todosUsuarios() {

		Usuario usuario = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_USUARIOS);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setDocumento(rs.getString("DOCUMENTO"));
				usuario.setApellido(rs.getString("APELLIDO1"));
				usuario.setNombre(rs.getString("NOMBRE1"));
				usuario.setClave(rs.getString("CLAVE"));
				usuario.setCorreo(rs.getString("MAIL"));
				usuario.setFechaNacimiento(rs.getDate("FECHA_NAC"));

				usuarios.add(usuario);

			}

		} catch (Exception e) {
			System.err.println("Error al obtener usuarios " + e.getMessage());
		}

		return usuarios;
	}
	
	/**
	 * Actualiza un usuario
	 * @param Usuario
	 * @return boolean
	 */
	public boolean update(Usuario u) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, u.getApellido());
			statement.setString(2, u.getNombre());
			statement.setDate(3, new java.sql.Date(u.getFechaNacimiento().getTime()));
			statement.setString(4, u.getClave());
			statement.setInt(5, u.getRolId());
			statement.setString(6, u.getCorreo());
			statement.setString(7, u.getDocumento());
			int retorno = statement.executeUpdate();

			return retorno > 0;
		} catch (SQLException e) {
			System.err.println("Error al actualizar usuario: " + UPDATE + " [ERROR] --> "  + e.getMessage());
			return false;
		}
	}

	/**
	 * Obtiene un usuario por documento
	 * @param documento
	 * @return Usuario
	 */
	public Usuario obtenerPorDocumento(String documento) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FIND_USUARIO);
			statement.setString(1, documento);
			ResultSet rs = statement.executeQuery();
				
			if(rs.next()) {
				return new Usuario(rs.getString("DOCUMENTO"), rs.getString("NOMBRE1"), rs.getString("APELLIDO1"), 
						rs.getDate("FECHA_NAC"), rs.getString("CLAVE"), rs.getString("MAIL"), new Rol(rs.getInt("ID_ROL"), 
								rs.getString("NOMBRE"), rs.getString("DESCRIPCION")));
			}
			
		} catch (SQLException e) {
			System.err.println("Error al buscar usuario: " + FIND_USUARIO + " [ERROR] --> "  + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Elimina un usuario de la base de datos
	 * @param id
	 * @return
	 */
	public boolean delete(Usuario u) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_USUARIO);
			statement.setString(1, u.getDocumento());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
