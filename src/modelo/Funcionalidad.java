package modelo;

public class Funcionalidad {
	private int id;
	private String nombre;
	private String descripcion;
	
	
	public Funcionalidad() {}
	
	public Funcionalidad(int id, String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.id = id;
	}
	
	public Funcionalidad(String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
