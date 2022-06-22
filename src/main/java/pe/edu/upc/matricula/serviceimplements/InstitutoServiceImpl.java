package pe.edu.upc.matricula.serviceimplements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Instituto;
import pe.edu.upc.matricula.entities.Users;
import pe.edu.upc.matricula.repositories.IInstitutoRepository;
import pe.edu.upc.matricula.repositories.IUserRepository;
import pe.edu.upc.matricula.serviceinterface.InstitutoService;
import pe.edu.upc.matricula.util.Auxiliar;

@Service
public class InstitutoServiceImpl implements InstitutoService {

	@Autowired
	private IInstitutoRepository instRepository;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public void insert(Instituto instituto) {
		instRepository.save(instituto);
	}

	@Override
	public Auxiliar buscarUsuario(String username) {
		var aux= new Auxiliar();
		var instituto= new Instituto();
		Users user = userRepository.findByUsername(username);
		Optional<Instituto> obj = instRepository.findById(user.getInstituto().getIdInstituto());
		instituto=obj.get();
		aux.setUsername(user.getUsername());
		aux.setPassword(user.getPassword());
		aux.setName(instituto.getNombre());
		aux.setPhone(instituto.getTelefono());
		return aux;
	}
}
