package pe.edu.upc.matricula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.matricula.entities.Instituto;
import pe.edu.upc.matricula.entities.Users;
import pe.edu.upc.matricula.serviceinterface.InstitutoService;
import pe.edu.upc.matricula.serviceinterface.UserService;
import pe.edu.upc.matricula.util.Auxiliar;

@Controller
@RequestMapping("/registros")
public class RegistroController {
	
	BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	@Autowired
	private InstitutoService institutoService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/nuevo")
	public String Registro(Model model) {
	
		model.addAttribute("obj",new Auxiliar());
		return "registro/registro";
	}
	public void comprobarClase(Auxiliar aux) {
		System.out.println("-------Datos del Objeto------");
		System.out.println("nombre: "+aux.getName());
		System.out.println("password: "+aux.getPassword());
		System.out.println("username: "+aux.getUsername());
		System.out.println("phone: "+aux.getPhone());

	}
	@PostMapping("/registro")
	public String Save(Model model, Auxiliar aux) {
		comprobarClase(aux);
		var instituto= new Instituto();
		var user = new Users();
		instituto.setNombre(aux.getName());
		instituto.setTelefono(aux.getPhone());
		
		user.setInstituto(instituto);
		user.setUsername(aux.getUsername());
		user.setPassword(bcpe.encode(aux.getPassword()));
		user.addRol("ROLE_INSTITUTO");
		institutoService.insert(instituto);
		userService.insert(user);
		return "redirect:/";
	}
}
