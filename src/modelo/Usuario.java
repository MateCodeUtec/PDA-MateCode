package modelo;

import java.util.Date;

public class Usuario {
	private String documento;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String clave;
	private String correo;
	private int rolId;
	private Rol rol;
	
	public Usuario() {
		
	}
	
	public Usuario(String documento, String nombre, String apellido, Date fechaNacimiento, String clave, String correo, Rol r) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
		this.correo = correo;
		this.rol = r;
	}
	
	public Usuario(String documento, String nombre, String apellido, Date fechaNacimiento, String clave, String correo, int rolId) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
		this.correo = correo;
		this.rolId = rolId;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rol) {
		this.rolId = rol;
	}
}
