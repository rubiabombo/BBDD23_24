package supermercado.model;

import java.sql.Date;

public class Producto {

		private int id;
		private String descripcion;
		private String codigo;
		private int idCategoria;
		private boolean perecedero;
		private Date fechaCaducidad;
		private int unidadesStock;
		
		public Producto() {
			super();
		}
/**
 * 
 * @param id
 * @param descripcion
 * @param codigo
 * @param idCategoria
 * @param perecedero
 * @param fechaCaducidad
 * @param unidadesStock
 */
		public Producto(int id, String descripcion, String codigo, int idCategoria, boolean perecedero, Date fechaCaducidad,
				int unidadesStock) {
			super();
			this.id = id;
			this.descripcion = descripcion;
			this.codigo = codigo;
			this.idCategoria = idCategoria;
			this.perecedero = perecedero;
			this.fechaCaducidad = fechaCaducidad;
			this.unidadesStock = unidadesStock;
		}
/**
 * 
 * @return getters y setters
 */
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

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public int getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(int idCategoria) {
			this.idCategoria = idCategoria;
		}

		public boolean isPerecedero() {
			return perecedero;
		}

		public void setPerecedero(boolean perecedero) {
			this.perecedero = perecedero;
		}

		public Date getFechaCaducidad() {
			return fechaCaducidad;
		}

		public void setFechaCaducidad(Date fechaCaducidad) {
			this.fechaCaducidad = fechaCaducidad;
		}

		public int getUnidadesStock() {
			return unidadesStock;
		}

		public void setUnidadesStock(int unidadesStock) {
			this.unidadesStock = unidadesStock;
		}

		@Override
		public String toString() {
			return descripcion;
		}

		public void setFechaCaducidad(java.util.Date nuevaFecha) {
		
			
		}
		
}

	
