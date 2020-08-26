package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DatabaseManager;
import modelo.Rol;

public class DAORol {
	private final String INSERT_ROL  = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION) VALUES (SEQ_ID_ROL.nextval,?,?)";
	private final String ALL_ROLES = "SELECT * FROM ROL";
	private final String FIND_POR_USUARIO = "SELECT * FROM ROL_FUNCION rf INNER JOIN FUNCIONALIDAD f "
			+ "ON rf.ID_FUNCION = f.ID_FUNCIONALIDAD INNER JOIN ROL r ON "
			+ "r.ID_ROL = rf.ID_ROL WHERE r.ID_ROL = ? ";
	private final String FIND_NOMBRE = "SELECT * FROM ROL WHERE NOMBRE = ?";
	private final String DELETE = "DELETE FROM ROL WHERE NOMBRE = ?";
	private final String UPDATE = "UPDATE ROL SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_ROL = ?";
	
	// Constructor privado para poder hacer uso del singleton
	private DAORol() {
		
	}
	
	// Singleton
	private static DAORol instancia = null;
	public static DAORol getInstancia() {
		if(instancia == null) {
			return new DAORol();
		}
		return instancia;
	}
	
	/**
	 * Obtiene el rol de un usuario
	 * @param rolId
	 * @return Rol
	 */
	public Rol obtenerRolPorUsuario(int rolId) {
		Rol rol = null;
		
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(FIND_POR_USUARIO);
			sentencia.setInt(1, rolId);
			ResultSet rs = sentencia.executeQuery();

			if(rs.next()) {
				rol = new Rol(rs.getString("NOMBRE"), rs.getString("DESCRIPCION"));
			}
			
		} catch (Exception e) {
			System.err.println("[CONSULTA] Error al ejecutar la consulta: " + FIND_POR_USUARIO);
			e.printStackTrace();
		}
		return rol;
	}
	
	/**
	 * Inserta un rol a la base de datos
	 * @param r
	 * @return boolean
	 */
	public boolean insertar(Rol r) {
		
		int row  = 0;
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(INSERT_ROL);
			sentencia.setString(1, r.getNombre());
			sentencia.setString(2, r.getDescripcion());
			
			row =  sentencia.executeUpdate();

			return row > 0;
		} catch (Exception e) {
			System.err.println("[CONSULTA] Error al ejecutar la consulta: " + INSERT_ROL);
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Obtiene todos los roles de la base de datos y lo guarda en una array list de roles
	 * @return ArrayList<Rol>
	 */
	public ArrayList<Rol> obtenerTodos(){
		ArrayList<Rol> roles = new ArrayList<Rol>();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_ROLES);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Rol r = new Rol(rs.getInt("ID_ROL"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"));
				roles.add(r);
			}

		} catch (Exception e) {
			System.err.println("Error al obtener roles " + e.getMessage());
		}
		return roles;
	}
	
	/**
	 * Obtiene un rol por nombre
	 * @param rolId
	 * @return Rol
	 */
	public Rol obtenerPorNombre(String nombre) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FIND_NOMBRE);
			statement.setString(1, nombre);
			ResultSet rs = statement.executeQuery();
				
			if(rs.next()) {
				return new Rol(rs.getInt("ID_ROL"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"));
			}
			
		} catch (SQLException e) {
			System.err.println("Error al buscar usuario: " + FIND_NOMBRE + " [ERROR] --> "  + e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Elimina un rol de la base de datos
	 * @param id
	 * @return
	 */
	public boolean delete(Rol r) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setString(1, r.getNombre());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Actualiza un rol de la bd
	 * @param f
	 * @return boolean
	 */
	public boolean update(Rol r) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, r.getNombre());
			statement.setString(2, r.getDescripcion());
			statement.setInt(3, r.getId());
			int retorno = statement.executeUpdate();
			return retorno > 0;
		} catch (SQLException e) {
			System.err.println("Error al actualizar rol: " + UPDATE + " [ERROR] --> "  + e.getMessage());
			return false;
		}
	}
}


