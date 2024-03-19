package alquileres.model;

public class Localidad {

	private int id;
	private String descripcion;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @param id
	 * @param descripcion
	 */
	public Localidad(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	/**
	 * 
	 */
	public Localidad() {
		super();
	}
	@Override
	public String toString() {
		return descripcion;
	}
	
	
	

}


