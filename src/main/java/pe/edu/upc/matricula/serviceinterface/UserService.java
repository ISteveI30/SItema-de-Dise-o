package pe.edu.upc.matricula.serviceinterface;

import java.util.Optional;

import pe.edu.upc.matricula.entities.Users;

public interface UserService {
	
	public void insert(Users user);

	Optional<Users> findUsers(int idUsers);
}
