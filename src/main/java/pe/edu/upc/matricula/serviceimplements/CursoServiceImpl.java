package pe.edu.upc.matricula.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Curso;
import pe.edu.upc.matricula.repositories.ICursoRepository;
import pe.edu.upc.matricula.serviceinterface.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private ICursoRepository cursoRespository;

	@Override
	public void insert(Curso curso) {
		cursoRespository.save(curso);
	}

	@Override
	public List<Curso> list() {
		return cursoRespository.findAll();
	}

	@Override
	public void delete(int idCurso) {
		cursoRespository.deleteById(idCurso);
	}

	@Override
	public void update(Curso curso) {
		cursoRespository.save(curso);
	}

	@Override
	public Optional<Curso> findCurso(int idCurso) {
		return cursoRespository.findById(idCurso);
	}
}
