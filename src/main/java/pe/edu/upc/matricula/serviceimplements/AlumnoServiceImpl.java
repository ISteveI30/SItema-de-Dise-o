package pe.edu.upc.matricula.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Alumno;
import pe.edu.upc.matricula.repositories.IAlumnoRepository;
import pe.edu.upc.matricula.serviceinterface.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private IAlumnoRepository alumnoRepository;
	@Override
	public void insert(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public List<Alumno> list() {
		return alumnoRepository.findAll();
	}

	@Override
	public void delete(int idAlumno) {
		alumnoRepository.deleteById(idAlumno);
	}

	@Override
	public void update(Alumno alumno) {
		alumnoRepository.save(alumno);
	}

	@Override
	public Optional<Alumno> findAlumno(int idAlumno) {
		return alumnoRepository.findById(idAlumno);
	}
	
}
