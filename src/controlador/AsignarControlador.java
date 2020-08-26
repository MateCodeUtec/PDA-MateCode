package controlador;

import DAO.DAOFuncionalidad;
import DAO.DAORol;
import DAO.DAORolFuncion;
import modelo.Funcionalidad;
import modelo.Rol;
import modelo.RolFuncion;

public class AsignarControlador {
	
	private AsignarControlador() {

	}

	// Singleton
	private static AsignarControlador instancia = null;

	// Instancia
	public static AsignarControlador getInstancia() {
		if (instancia == null) {
			return new AsignarControlador();
		}
		return instancia;
	}

	/**
	 * Asignamos una funcion
	 * @param nombre
	 * @param descripcion
	 * @return boolean
	 */
	public boolean asignarFuncion(String rol, String funcion) {
		// Buscamos el rol para verificar que existe en la bd
		Rol r = DAORol.getInstancia().obtenerPorNombre(rol);
		Funcionalidad f = DAOFuncionalidad.getInstancia().obtenerPorNombre(funcion);

		// Verificamos que exista el rol y la funcion en la bd
		if(r == null || f == null) {
			return false;
		}
		
		// Verificamos que no exista en la base de datos la misma funcionalidad asignada a un mismo rol
		RolFuncion verificar = DAORolFuncion.getInstancia().obtenerPorRolYFuncion(r.getId(), f.getId());
		
		if(verificar != null) {
			return false;
		}
		
		// Guardamos
		RolFuncion rf = new RolFuncion(r,f);
		return  DAORolFuncion.getInstancia().asignar(rf);
	}
}
