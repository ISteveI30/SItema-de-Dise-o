package pe.edu.upc.matricula.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Docente;
import pe.edu.upc.matricula.repositories.IDocenteRepository;
import pe.edu.upc.matricula.serviceinterface.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	private IDocenteRepository docenteRepository;

	@Override
	public void insert(Docente docente) {
		docenteRepository.save(docente);		
	}

	@Override
	public List<Docente> list() {
		return docenteRepository.findAll();
	}

	@Override
	public void delete(int idDocente) {
		docenteRepository.deleteById(idDocente);
	}

	@Override
	public void update(Docente docente) {
		docenteRepository.save(docente);		
	}

	@Override
	public Optional<Docente> findDocente(int idDocente) {
		return docenteRepository.findById(idDocente);
	}
}
