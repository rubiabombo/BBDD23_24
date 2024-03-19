package gestionCentroEducativo.model;

public class Profesor {

	int id;
	String nombre;
	String apellido1;
	String apellido2;
	String dni;
	String direccion;
	String email;
	String telefono;
	int idTipologiaSexo;
	private byte[] imagen;
	String colorPreferido;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id, String nombre, String apellido1, String apellido2, String dni, String direccion,
			String email, String telefono, int idSexo, byte[] imagen, String colorPreferido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.idTipologiaSexo = idTipologiaSexo;
		this.imagen = imagen;
		this.colorPreferido = colorPreferido;
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public String getColorPreferido() {
		return colorPreferido;
	}

	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdTipologiaSexo() {
		return idTipologiaSexo;
	}

	public void setIdTipologiaSexo(int idTipologiaSexo) {
		this.idTipologiaSexo = idTipologiaSexo;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
