package pe.edu.upc.matricula.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAlumno;
	
	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "nacimiento", nullable = false)
	private Date nacimiento;	
	
	@Column(name = "correo", nullable = false, length = 60)
	private String correo;

	
	public Alumno() {
		super();
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
