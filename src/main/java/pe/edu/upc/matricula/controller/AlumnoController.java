package pe.edu.upc.matricula.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.matricula.entities.Alumno;
import pe.edu.upc.matricula.serviceinterface.AlumnoService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumService;
	
	@GetMapping("/lista")
	public String listDocente(Model model) {
		try {
			model.addAttribute("alumno",new Alumno());
			model.addAttribute("lstAlumnos", alumService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/alumno/frmAlumno";
	}

	@PostMapping("/guardar")
	public String saveDocente(@Valid Alumno alumno, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "alumno/frmAlumno";
		} else {
			alumService.insert(alumno);
			model.addAttribute("lstAlumnos", alumService.list());
			return "redirect:/alumnos/lista";		}
	}

	@RequestMapping("/editar/{id}")
	public String UpdateDocente(@PathVariable("id")int id, Model model) {
		try {
		Optional<Alumno> alumno=alumService.findAlumno(id);
		model.addAttribute("alumno", alumno.get());
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "/alumno/updateAlumno";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String deleteDocente(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				alumService.delete(id);
				model.addAttribute("lstAlumnos", alumService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/alumnos/lista";
	}
	
	@PostMapping("/modificar")
	public String updateDocente(Model model,Alumno a) {
		alumService.update(a);
		model.addAttribute("lstAlumnos", alumService.list());
		return "redirect:/alumnos/lista";
	}
}
