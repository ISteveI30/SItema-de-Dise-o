package pe.edu.upc.matricula.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secciones")
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSeccion;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Seccion() {
		super();
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
