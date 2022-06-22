package pe.edu.upc.matricula.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Seccion;
import pe.edu.upc.matricula.repositories.ISeccionRepository;
import pe.edu.upc.matricula.serviceinterface.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService {

	@Autowired
	private ISeccionRepository seccionRepository;
	@Override
	public List<Seccion> list() {
		return seccionRepository.findAll();
	}

}
