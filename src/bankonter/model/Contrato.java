package bankonter.model;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable {
		private static final long serialVersionUID = 1L;


		private int id;

		private String descripcion;

	
		private Date fechaFirma;

		private float limite;

		private float saldo;

	
		private TipoContrato tipocontrato;

		private Usuario usuario;

		public Contrato() {
		}

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescripcion() {
			return this.descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Date getFechaFirma() {
			return this.fechaFirma;
		}

		public void setFechaFirma(Date fechaFirma) {
			this.fechaFirma = fechaFirma;
		}

		public float getLimite() {
			return this.limite;
		}

		public void setLimite(float limite) {
			this.limite = limite;
		}

		public float getSaldo() {
			return this.saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}

		public TipoContrato getTipocontrato() {
			return this.tipocontrato;
		}

		public void setTipocontrato(TipoContrato tipocontrato) {
			this.tipocontrato = tipocontrato;
		}

		public Usuario getUsuario() {
			return this.usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

	}

