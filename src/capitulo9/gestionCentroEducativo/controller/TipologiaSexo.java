package capitulo9.gestionCentroEducativo.controller;

public class TipologiaSexo {
	int id;
	String descripcion;

	public TipologiaSexo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipologiaSexo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}
