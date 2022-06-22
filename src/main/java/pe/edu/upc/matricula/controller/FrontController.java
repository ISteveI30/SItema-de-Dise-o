package pe.edu.upc.matricula.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.matricula.entities.Users;
import pe.edu.upc.matricula.serviceinterface.InstitutoService;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private InstitutoService inService;

	@GetMapping({ "/login", "/" })
	public String login(/* @RequestParam(value = "error", required = false) String error, */
			/*
			 * @RequestParam(value = "logout", required = false) String logout, Model model,
			 */ Principal principal
			/* ,RedirectAttributes flash */, Users user) {
		if (principal != null) {
			System.out.println("Se logueo correctamente");

			// System.out.println("Id: "+principal.getClass());
			// System.out.println("Nombre del usuario:
			// "+user.getEstudiante().getNombre()+user.getEstudiante().getApellido());
			return "redirect:/alumnos/lista";
		}

		/*
		 * if (error != null) { model.addAttribute("error",
		 * "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!"
		 * ); }
		 */
		/*
		 * if (logout != null) { model.addAttribute("success",
		 * "Ha cerrado sesión con éxito!"); }
		 */
		return "login";
	}

	/*@GetMapping("/inicio") // guardar el inicio y / para el login
	public String inicio() {
		return "layout/inicio";
	}*/

	@GetMapping("/perfil") // guardar el inicio y / para el login
	public String pefil(Principal principal, Users user, Model model) {
		var aux = inService.buscarUsuario(principal.getName());
		System.out.println("Datos del usuario");
		System.out.println("Nombre: " + aux.getName());
		System.out.println("correo: " + aux.getUsername());
		System.out.println("password: " + aux.getPassword());
		System.out.println("telefono: " + aux.getPhone());
		model.addAttribute("name", aux.getName());
		model.addAttribute("username", aux.getUsername());
		model.addAttribute("phone", aux.getPhone());
		return "layout/perfil";
	}
}
