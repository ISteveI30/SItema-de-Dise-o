package pe.edu.upc.matricula.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.matricula.entities.Docente;

public interface DocenteService {
	public void insert(Docente docente);

	public List<Docente> list();
	
	public void delete(int idDocente);

	public void update(Docente docente);
	
	Optional<Docente> findDocente(int idDocente);
}
