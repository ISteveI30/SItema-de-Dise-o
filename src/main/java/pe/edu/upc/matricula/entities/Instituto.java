package pe.edu.upc.matricula.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "institutos")
public class Instituto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idInstituto;
	
	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "instituto")
	private Users user;

	public Instituto() {
		super();
	}

	public int getIdInstituto() {
		return idInstituto;
	}

	public void setIdInstituto(int idInstituto) {
		this.idInstituto = idInstituto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
