package pe.edu.upc.matricula.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "periodos")
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPeriodo;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Periodo() {
		super();
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
