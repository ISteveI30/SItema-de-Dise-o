package pe.edu.upc.matricula.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCurso;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "ciclo", nullable = false)
	private int ciclo;
	
	@Column(name = "creditos", nullable = false)
	private int creditos;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="idDocente")
	private Docente docente;

	public Curso() {
		super();
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCiclo() {
		return ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}	
}
