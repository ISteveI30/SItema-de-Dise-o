package pe.edu.upc.matricula.serviceimplements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.matricula.entities.Users;
import pe.edu.upc.matricula.repositories.IUserRepository;
import pe.edu.upc.matricula.serviceinterface.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public void insert(Users user) {
		userRepository.save(user);		
	}

	@Override
	public Optional<Users> findUsers(int idUsers) {
		return userRepository.findById(idUsers);
	}
}
