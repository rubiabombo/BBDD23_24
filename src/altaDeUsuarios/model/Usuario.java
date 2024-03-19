package altaDeUsuarios.model;

public class Usuario {
	private int id, idIdioma;
	private String email, usuario, password;
	
	
	public Usuario() {
		super();
	}


	public Usuario(int id, int idIdioma, String email, String usuario, String password) {
		super();
		this.id = id;
		this.idIdioma = idIdioma;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idIdioma=" + idIdioma + ", email=" + email + ", usuario=" + usuario
				+ ", password=" + password + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdIdioma() {
		return idIdioma;
	}


	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

}
