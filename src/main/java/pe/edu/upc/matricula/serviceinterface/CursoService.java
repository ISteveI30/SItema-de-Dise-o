package pe.edu.upc.matricula.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.matricula.entities.Curso;

public interface CursoService {
	public void insert(Curso curso);

	public List<Curso> list();
	
	public void delete(int idCurso);

	public void update(Curso curso);
	
	Optional<Curso> findCurso(int idCurso);
}
