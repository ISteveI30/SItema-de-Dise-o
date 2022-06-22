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

import pe.edu.upc.matricula.entities.Curso;
import pe.edu.upc.matricula.serviceinterface.CodigoService;
import pe.edu.upc.matricula.serviceinterface.CursoService;
import pe.edu.upc.matricula.serviceinterface.DocenteService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	@Autowired
	private CodigoService codigoService;
	@Autowired
	private DocenteService docenteService;

	@GetMapping("/lista")
	public String listCurso(Model model) {
		try {
			model.addAttribute("curso", new Curso());
			model.addAttribute("lstCursos", cursoService.list());
			model.addAttribute("lstCodigo", codigoService.list());
			model.addAttribute("lstDocente", docenteService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/curso/frmCurso";
	}

	@PostMapping("/guardar")
	public String saveCurso(@Valid Curso curso, BindingResult binRes, Model model) {
		/*if (binRes.hasErrors()) {
			return "curso/frmCurso";
		} else {*/
			System.out.println("Curso: "+curso.getNombre());
			
			cursoService.insert(curso);
			model.addAttribute("lstCursos", cursoService.list());
			return "redirect:/cursos/lista";
		/*}*/
	}

	@RequestMapping("/editar/{id}")
	public String UpdateCurso(@PathVariable("id") int id, Model model) {
		try {
			Optional<Curso> curso = cursoService.findCurso(id);
			model.addAttribute("curso", curso.get());
			model.addAttribute("lstCodigo", codigoService.list());
			model.addAttribute("lstDocente", docenteService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/curso/updateCurso";
	}

	@RequestMapping("/eliminar/{id}")
	public String deleteCurso(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				cursoService.delete(id);
				model.addAttribute("lstCursos", cursoService.list());
				model.addAttribute("lstDocente", docenteService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/cursos/lista";
	}

	@PostMapping("/modificar")
	public String updateCurso(Model model, Curso c) {
		cursoService.update(c);
		model.addAttribute("lstCursos", cursoService.list());
		model.addAttribute("lstCodigo", codigoService.list());
		model.addAttribute("lstDocente", docenteService.list());
		return "redirect:/cursos/lista";
	}
}
