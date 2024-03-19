package gestionCentroEducativo.model;

public class ValoracionMateria {
	
	int id;
	int idProfesor;
	int idEstudiante;
	int idMateria;
	float valoracion;
	
	
	public ValoracionMateria(int id, int idProfesor, int idEstudiante, int idMateria, float valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}


	public ValoracionMateria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}


	public int getIdEstudiante() {
		return idEstudiante;
	}


	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}


	public int getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}


	public float getValoracion() {
		return valoracion;
	}


	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}


	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idEstudiante=" + idEstudiante
				+ ", idMateria=" + idMateria + ", valoracion=" + valoracion + "]";
	}
	
	
	
	

}
