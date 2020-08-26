package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DatabaseManager;
import modelo.Funcionalidad;

public class DAOFuncionalidad {

	private final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDAD VALUES (SEQ_ID_FUNCIONALIDAD.nextval,?,?)";
	private final String FIND_NOMBRE = "SELECT * FROM FUNCIONALIDAD WHERE NOMBRE = ?";
	private final String ALL_ROLES = "SELECT * FROM FUNCIONALIDAD";
	private final String DELETE = "DELETE FROM FUNCIONALIDAD WHERE NOMBRE = ?";
	private final String UPDATE = "UPDATE FUNCIONALIDAD SET NOMBRE = ?, DESCRIPCION = ? WHERE ID_FUNCIONALIDAD = ?";
	private DAOFuncionalidad() {

	}

	// Singleton
	private static DAOFuncionalidad instancia = null;

	public static DAOFuncionalidad getInstancia() {
		if (instancia == null) {
			return new DAOFuncionalidad();
		}
		return instancia;
	}

	/**
	 * Insertamos una funcionalidad a la base de datos
	 * @param f
	 * @return boolean
	 */
	public boolean insertarFuncionalidad(Funcionalidad f) {

		int row = 0;
		
		try {
			PreparedStatement sentencia = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);
			sentencia.setString(1, f.getNombre());
			sentencia.setString(2, f.getDescripcion());

			row = sentencia.executeUpdate();

			return row > 0;
		} catch (Exception e) {
			System.err.println("[CONSULTA] Error al ejecutar la consulta: " + INSERT_FUNCIONALIDAD);
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * Obtiene una funcionalidad por nombre
	 * @param nombre
	 * @return Funcionalidad
	 */
	public Funcionalidad obtenerPorNombre(String nombre) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(FIND_NOMBRE);
			statement.setString(1, nombre);
			ResultSet rs = statement.executeQuery();
				
			if(rs.next()) {
				return new Funcionalidad(rs.getInt("ID_FUNCIONALIDAD"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"));
			}
			
		} catch (SQLException e) {
			System.err.println("Error al buscar funcionalidad: " + FIND_NOMBRE + " [ERROR] --> "  + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Obtiene todas las funcionalidades de la base de datos y lo guarda en una array list
	 * @return ArrayList<Funcionalidad>
	 */
	public ArrayList<Funcionalidad> obtenerTodos(){
		ArrayList<Funcionalidad> funcionalidades = new ArrayList<Funcionalidad>();

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_ROLES);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Funcionalidad f = new Funcionalidad(rs.getInt("ID_FUNCIONALIDAD"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"));
				funcionalidades.add(f);
			}

		} catch (Exception e) {
			System.err.println("Error al obtener funcionalidades " + e.getMessage());
		}
		return funcionalidades;
	}
	
	/**
	 * Elimina una funcionalidad de la base de datos
	 * @param id
	 * @return
	 */
	public boolean delete(Funcionalidad f) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE);
			statement.setString(1, f.getNombre());
			return statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Actualiza una funcionalidad de la bd
	 * @param f
	 * @return boolean
	 */
	public boolean update(Funcionalidad f) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE);
			statement.setString(1, f.getNombre());
			statement.setString(2, f.getDescripcion());
			statement.setInt(3, f.getId());
			int retorno = statement.executeUpdate();

			return retorno > 0;
		} catch (SQLException e) {
			System.err.println("Error al actualizar usuario: " + UPDATE + " [ERROR] --> "  + e.getMessage());
			return false;
		}
	}
}
