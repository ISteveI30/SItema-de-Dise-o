package pe.edu.upc.matricula.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Periodo;
import pe.edu.upc.matricula.repositories.IPeriodoRepository;
import pe.edu.upc.matricula.serviceinterface.PeriodoService;

@Service
public class PeriodoServiceImpl implements PeriodoService{
	@Autowired
	private IPeriodoRepository periodoRepository;

	@Override
	public List<Periodo> list() {
		// TODO Auto-generated method stub
		return periodoRepository.findAll();
	}
}
