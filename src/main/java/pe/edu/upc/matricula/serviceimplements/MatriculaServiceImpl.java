package pe.edu.upc.matricula.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Matricula;
import pe.edu.upc.matricula.repositories.IMatriculaRepository;
import pe.edu.upc.matricula.serviceinterface.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private IMatriculaRepository maRepository;

	@Override
	public void insert(Matricula matricula) {
		maRepository.save(matricula);		
	}

	@Override
	public List<Matricula> list() {
		return maRepository.findAll();
	}

	@Override
	public void delete(int idMatricula) {
		maRepository.deleteById(idMatricula);		
	}

	@Override
	public void update(Matricula matricula) {
		maRepository.save(matricula);
	}

	@Override
	public Optional<Matricula> findMatricula(int idMatricula) {
		return maRepository.findById(idMatricula);
	}
}
