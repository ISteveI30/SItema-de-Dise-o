package pe.edu.upc.matricula.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.matricula.entities.Alumno;

public interface AlumnoService {
	public void insert(Alumno alumno);

	public List<Alumno> list();
	
	public void delete(int idAlumno);

	public void update(Alumno alumno);
	
	Optional<Alumno> findAlumno(int idAlumno);
}
