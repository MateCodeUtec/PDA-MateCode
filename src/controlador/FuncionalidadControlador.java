package controlador;

import java.util.ArrayList;

import DAO.DAOFuncionalidad;
import modelo.Funcionalidad;

public class FuncionalidadControlador {
	
	private FuncionalidadControlador() {

	}

	// Singleton
	private static FuncionalidadControlador instancia = null;

	public static FuncionalidadControlador getInstancia() {
		if (instancia == null) {
			return new FuncionalidadControlador();
		}
		return instancia;
	}

	/**
	 * Insertamos una nueva funcionalidad
	 * @param nombre
	 * @param descripcion
	 * @return boolean
	 */
	public boolean insertarFuncionalidad(String nombre, String descripcion) {
		var instancia = DAOFuncionalidad.getInstancia();
		
		Funcionalidad verificarNombre = instancia.obtenerPorNombre(nombre);
		
		if(verificarNombre != null) {
			return false;
		}
		
		Funcionalidad f = new Funcionalidad(nombre, descripcion);
		return instancia.insertarFuncionalidad(f);
	}
	
	/**
	 * Obtiene todas las funcionalidades
	 * @return ArrayList<Funcionalidad>
	 */
	public ArrayList<Funcionalidad> obtenerTodos(){
		return DAOFuncionalidad.getInstancia().obtenerTodos();
	}
	
	/**
	 * Elimina una funcionalidad
	 * @param nombre
	 * @return boolean
	 */
	public boolean eliminar(String nombre) {
		var instancia = DAOFuncionalidad.getInstancia();
		Funcionalidad f = instancia.obtenerPorNombre(nombre);
		
		if(f == null) {
			return false;
		}
		
		return DAOFuncionalidad.getInstancia().delete(f);
	}
	
	/**
	 * Obtiene una funcionalidad por nombre
	 * @param nombre
	 * @return Funcionalidad
	 */
	public Funcionalidad obtenerPorNombre(String nombre) {
		return DAOFuncionalidad.getInstancia().obtenerPorNombre(nombre);
	}
	
	/**
	 * Actualizamos una funcionalidad
	 * @param nombre
	 * @param descripcion
	 * @return boolean
	 */
	public boolean actualizar(int id, String nombre, String descripcion) {
		var instancia = DAOFuncionalidad.getInstancia();
		
		Funcionalidad f = instancia.obtenerPorNombre(nombre);
		
		if(f != null && id != f.getId()) {
			return false;
		}
		
		return instancia.update(new Funcionalidad(id, nombre, descripcion));
	}
}
