package controlador;

import java.util.ArrayList;

import DAO.DAORol;
import modelo.Rol;

public class RolControlador {
	// Constructor privado para poder hacer uso del singleton
	private RolControlador() {

	}

	// Singleton
	private static RolControlador instancia = null;

	public static RolControlador getInstancia() {
		if (instancia == null) {
			return new RolControlador();
		}
		return instancia;
	}

	/**
	 * Llama al DAO de agregar rol
	 * @param nombre
	 * @param descripcion
	 * @return boolean
	 */
	public boolean insertar(String nombre, String descripcion) {
		var instancia = DAORol.getInstancia();
		
		Rol verificarNombre = instancia.obtenerPorNombre(nombre);
		
		if(verificarNombre != null) {
			return false;
		}
		
		Rol r = new Rol(nombre, descripcion);
		return instancia.insertar(r);
	}
	
	/**
	 * Llama al dao de obtener todos los roles
	 * @return ArrayList<Rol>
	 */
	public ArrayList<Rol> obtenerTodos(){
		return DAORol.getInstancia().obtenerTodos();
	}
	
	/**
	 * Elimina un rol
	 * @param nombre
	 * @return boolean
	 */
	public boolean eliminar(String nombre) {
		var instancia = DAORol.getInstancia();
		Rol r = instancia.obtenerPorNombre(nombre);
		
		if(r == null) {
			return false;
		}
		
		return DAORol.getInstancia().delete(r);
	}
	
	/**
	 * Obtiene un rol por nombre
	 * @param nombre
	 * @return Rol
	 */
	public Rol obtenerPorNombre(String nombre) {
		return DAORol.getInstancia().obtenerPorNombre(nombre);
	}
	
	/**
	 * Actualizamos un rol
	 * @param nombre
	 * @param descripcion
	 * @return boolean
	 */
	public boolean actualizar(int id, String nombre, String descripcion) {
		var instancia = DAORol.getInstancia();
		
		Rol r = instancia.obtenerPorNombre(nombre);
		
		if(r != null && id != r.getId()) {
			return false;
		}
		
		return instancia.update(new Rol(id, nombre, descripcion));
	}
}
