package pe.edu.upc.matricula.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codigos")
public class Codigo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCodigo;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Codigo() {
		super();
		
	}

	public int getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
