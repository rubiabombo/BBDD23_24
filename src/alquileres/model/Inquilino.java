package alquileres.model;

import java.sql.Date;

public class Inquilino {
	
	private int id;
	private String dni;
	private String nombreCompleto;
	private Date fechaInicioAlquiler;
	private Date fechaFinAlquiler;
	private float cuotaMensual;
	private int idVivienda;
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
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	/**
	 * @return the fechaInicioAlquiler
	 */
	public Date getFechaInicioAlquiler() {
		return fechaInicioAlquiler;
	}
	/**
	 * @param date the fechaInicioAlquiler to set
	 */
	public void setFechaInicioAlquiler(java.util.Date date) {
		this.fechaInicioAlquiler = (Date) date;
	}
	/**
	 * @return the fechaFinAlquiler
	 */
	public Date getFechaFinAlquiler() {
		return fechaFinAlquiler;
	}
	/**
	 * @param date the fechaFinAlquiler to set
	 */
	public void setFechaFinAlquiler(java.util.Date date) {
		this.fechaFinAlquiler = (Date) date;
	}
	/**
	 * @return the cuotaMensual
	 */
	public float getCuotaMensual() {
		return cuotaMensual;
	}
	/**
	 * @param cuotaMensual the cuotaMensual to set
	 */
	public void setCuotaMensual(float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}
	/**
	 * @return the idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}
	/**
	 * @param idVivienda the idVivienda to set
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	/**
	 * @param id
	 * @param dni
	 * @param nombreCompleto
	 * @param fechaInicioAlquiler
	 * @param fechaFinAlquiler
	 * @param cuotaMensual
	 * @param idVivienda
	 */
	public Inquilino(int id, String dni, String nombreCompleto, Date fechaInicioAlquiler, Date fechaFinAlquiler,
			float cuotaMensual, int idVivienda) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaInicioAlquiler = fechaInicioAlquiler;
		this.fechaFinAlquiler = fechaFinAlquiler;
		this.cuotaMensual = cuotaMensual;
		this.idVivienda = idVivienda;
	}
	/**
	 * 
	 */
	public Inquilino() {
		super();
	}
	
	
	

}


