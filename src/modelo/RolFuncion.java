package modelo;

public class RolFuncion {
	private int id;
	private Rol rol;
	private Funcionalidad funcion;
	
	public RolFuncion() {
		
	}

	public RolFuncion(int id, Rol rol, Funcionalidad funcion) {
		this.rol = rol;
		this.funcion = funcion;
		this.id = id;
	}

	
	public RolFuncion(Rol rol, Funcionalidad funcion) {
		this.rol = rol;
		this.funcion = funcion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Funcionalidad getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcionalidad funcion) {
		this.funcion = funcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
