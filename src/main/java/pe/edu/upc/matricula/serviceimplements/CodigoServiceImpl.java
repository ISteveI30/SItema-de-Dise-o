package pe.edu.upc.matricula.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Codigo;
import pe.edu.upc.matricula.repositories.ICodigoRepository;
import pe.edu.upc.matricula.serviceinterface.CodigoService;

@Service
public class CodigoServiceImpl implements CodigoService {
	@Autowired
	private ICodigoRepository codRepository;

	@Override
	public List<Codigo> list() {
		return codRepository.findAll();
	}

	
}
