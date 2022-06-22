package pe.edu.upc.matricula.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.matricula.entities.Rol;
import pe.edu.upc.matricula.entities.Users;
import pe.edu.upc.matricula.repositories.IUserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username: "+ username);
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println("Error al logear");
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Rol rol : user.getRoles()) {
			//System.out.println("rol de la lista: "+rol.getRol());
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true,authorities);
	}
}
