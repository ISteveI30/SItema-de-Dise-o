package pe.edu.upc.matricula.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", unique = true, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
	private Boolean enabled;

	//@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idInstituto", nullable = true)
	private Instituto instituto;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;
	
	public Users() {
		super();
		this.enabled=true;
		this.roles = new ArrayList<>();
	}
	public void addRol(String rol) {
		Rol role=new Rol();
		role.setRol(rol);
		this.roles.add(role);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Instituto getInstituto() {
		return instituto;
	}
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
