package capitulo9.gestionCentroEducativo.model;

public class Materia {
	private int id;
	private int cursoId;
	private String nombre;
	private String acronimo;
	
	
	public Materia() {
		super();
	}


	public Materia(int id, int cursoId, String nombre, String acronimo) {
		super();
		this.id = id;
		this.cursoId = cursoId;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCursoId() {
		return cursoId;
	}


	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
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
	
	
	
	
	
}
