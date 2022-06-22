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

import pe.edu.upc.matricula.entities.Docente;
import pe.edu.upc.matricula.serviceinterface.DocenteService;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

	@Autowired
	private DocenteService docService;

	@GetMapping("/lista")
	public String listDocente(Model model) {
		try {
			model.addAttribute("docente", new Docente());
			model.addAttribute("lstdocentes", docService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/docente/frmDocente";
	}

	@PostMapping("/guardar")
	public String saveDocente(@Valid Docente docente, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "docente/frmDocente";
		} else {
			docService.insert(docente);
			model.addAttribute("lstdocentes", docService.list());
			return "redirect:/docentes/lista";
		}
	}

	@RequestMapping("/editar/{id}")
	public String UpdateDocente(@PathVariable("id") int id, Model model) {
		try {
			Optional<Docente> docente = docService.findDocente(id);
			model.addAttribute("docente", docente.get());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/docente/updateDocente";
	}

	@RequestMapping("/eliminar/{id}")
	public String deleteDocente(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				docService.delete(id);
				model.addAttribute("lstdocentes", docService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/docentes/lista";
	}

	@PostMapping("/modificar")
	public String updateDocente(Model model, Docente docente) {
		docService.update(docente);
		model.addAttribute("lstdocentes", docService.list());
		return "redirect:/docentes/lista";
	}
}
