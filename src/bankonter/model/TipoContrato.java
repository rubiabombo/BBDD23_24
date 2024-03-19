package bankonter.model;

import java.io.Serializable;
import java.util.List;

public class TipoContrato implements Serializable {
		private static final long serialVersionUID = 1L;

	
		private int id;

		private String descripcion;


		private List<Contrato> contratos;

		public TipoContrato() {
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

		public List<Contrato> getContratos() {
			return this.contratos;
		}

		public void setContratos(List<Contrato> contratos) {
			this.contratos = contratos;
		}

		public Contrato addContrato(Contrato contrato) {
			getContratos().add(contrato);
			contrato.setTipocontrato(this);

			return contrato;
		}

		public Contrato removeContrato(Contrato contrato) {
			getContratos().remove(contrato);
			contrato.setTipocontrato(null);

			return contrato;
		}

	}

