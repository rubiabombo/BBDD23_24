package examen20230427.model;

public class Asignatura {


	private int id;
	private String denominacion;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	

	@Override
	public String toString() {
		return denominacion;
	}
	
		
	}
	
	



