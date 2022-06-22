package pe.edu.upc.matricula.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.matricula.entities.Matricula;

public interface MatriculaService {
	public void insert(Matricula matricula);

	public List<Matricula> list();
	
	public void delete(int idMatricula);

	public void update(Matricula matricula);
	
	Optional<Matricula> findMatricula(int idMatricula);
}
