package pe.edu.upc.matricula.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "matriculas")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMatricula;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "inicio", nullable = false)
	private Date inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "finalizacion", nullable = false)
	private Date finalizacion;
	
	@Column(name = "seccion", nullable = false)
	private String seccion;
	
	@Column(name = "periodo", nullable = false)
	private String periodo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "matricula_id")
	private List<Alumno> alumno;
	/*
	@ManyToOne
	@JoinColumn(name="idInstituto")
	private Instituto instituto;*/
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Curso curso;

	public Matricula() {
		super();
		this.alumno= new ArrayList<>();
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFinalizacion() {
		return finalizacion;
	}

	public void setFinalizacion(Date finalizacion) {
		this.finalizacion = finalizacion;
	}

/*
	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}*/



	public List<Alumno> getAlumno() {
		return alumno;
	}


	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
