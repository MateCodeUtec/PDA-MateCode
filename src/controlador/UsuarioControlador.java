package controlador;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import DAO.DAOUsuario;
import modelo.Usuario;

public class UsuarioControlador {

	// Constructor privado para poder hacer uso del singleton
	private UsuarioControlador() {

	}

	// Singleton
	private static UsuarioControlador instancia = null;

	// Instancia
	public static UsuarioControlador getInstancia() {
		if (instancia == null) {
			return new UsuarioControlador();
		}
		return instancia;
	}

	/**
	 * Verificamos que el usuario y contraseña ingresado exista en nuestra base de
	 * datos
	 * 
	 * @param correo
	 * @param pass
	 * @return true o false
	 */
	public Usuario login(String correo, String pass) {
		if (correo.isEmpty() || pass.isEmpty()) {
			return null;
		}

		Usuario u = DAOUsuario.getInstancia().obtenerUsuarioPorCorreo(correo);

		if (u != null && u.getClave().equals(DigestUtils.md5Hex(pass))) {
			return u;
		}
		return null;
	}

	/**
	 * Agregar un usuario a la BD
	 * @param documento
	 * @param apellido1
	 * @param nombre1
	 * @param fecha
	 * @param clave
	 * @param idRol
	 * @param mail
	 * @return boolean
	 */
	public boolean insert(String documento, String apellido1, String nombre1, Date fecha, String clave, int idRol,
			String mail) {

		var instancia = DAOUsuario.getInstancia();
		
		// Verificamos que el documento no se repita
		Usuario documentoRepetido = instancia.obtenerPorDocumento(documento);
		Usuario correoRepetido = instancia.obtenerUsuarioPorCorreo(mail);
		
		if(documentoRepetido != null || correoRepetido != null) {
			return false;
		}
		
		// Encriptamos la contraseña
		clave = DigestUtils.md5Hex(clave);
		
		Usuario u = new Usuario(documento, nombre1, apellido1, fecha, clave, mail, idRol);
		return instancia.insert(u);
	}

	/**
	 * Obitiene la lista de los usuarios
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> todosUsuarios() {
		return DAOUsuario.getInstancia().todosUsuarios();
	}

	/**
	 * Actualiza los datos del usuario
	 * @param documento
	 * @param apellido1
	 * @param nombre1
	 * @param fecha
	 * @param clave
	 * @param idRol
	 * @param mail
	 * @return
	 */
	public boolean actualizarUsuario(String documento, String apellido1, String nombre1, Date fecha, String clave,
			int idRol, String mail) {
		
		var instancia = DAOUsuario.getInstancia();
		
		Usuario correoRepetido = instancia.obtenerUsuarioPorCorreo(mail);
		
		if(correoRepetido != null && !documento.equals(correoRepetido.getDocumento())) {
			return false;
		}
		
		clave = DigestUtils.md5Hex(clave);
		
		Usuario u = new Usuario(documento, nombre1, apellido1, fecha, clave, mail, idRol);
		return instancia.update(u);
	}
	
	/**
	 * Obtiene un usuario por el documento
	 * @param documento
	 * @return Usuario
	 */
	public Usuario obtenerUsuarioPorDoc(String documento) {
		return DAOUsuario.getInstancia().obtenerPorDocumento(documento);
	}
	
	/**
	 * Elimina una persona
	 * @param documento
	 * @return boolean
	 */
	public boolean eliminar(String documento) {
		var instancia = DAOUsuario.getInstancia();
		Usuario u = instancia.obtenerPorDocumento(documento);
		
		if(u == null) {
			return false;
		}
		
		return DAOUsuario.getInstancia().delete(u);
	}
}
