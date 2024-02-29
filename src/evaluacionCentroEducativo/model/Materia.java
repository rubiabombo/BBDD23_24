package evaluacionCentroEducativo.model;

public class Materia {

	int id;
	String nombre;
	String acronimo;
	int cursoId;
	
	
	public Materia() {
		super();
		
	}

	public Materia(int id, String nombre, String acronimo, int cursoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.cursoId = cursoId;
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


	public String getAcronimo() {
		return acronimo;
	}


	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}


	public int getCursoId() {
		return cursoId;
	}


	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}


	@Override
	public String toString() {
		return nombre;
	}
	
	
	

}

