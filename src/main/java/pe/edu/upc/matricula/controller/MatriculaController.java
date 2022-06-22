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

import pe.edu.upc.matricula.entities.Matricula;
import pe.edu.upc.matricula.serviceinterface.AlumnoService;
import pe.edu.upc.matricula.serviceinterface.CursoService;
import pe.edu.upc.matricula.serviceinterface.MatriculaService;
import pe.edu.upc.matricula.serviceinterface.PeriodoService;
import pe.edu.upc.matricula.serviceinterface.SeccionService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private SeccionService seccionService;
	
	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private CursoService cursoService;
	
	/*@Autowired
	private RegistroService registroService;*/
	/*@Autowired
	private InstitutoService institutoService;*/
	
	@GetMapping("/lista")
	public String listMatricula(Model model) {
		try {
			Matricula m= new Matricula();
			
			model.addAttribute("matricula",m);
			model.addAttribute("lstMatriculas", matriculaService.list());
			model.addAttribute("lstAlumnos", alumnoService.list());
			model.addAttribute("lstSecciones", seccionService.list());
			model.addAttribute("lstPeriodos", periodoService.list());
			model.addAttribute("lstCursos", cursoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/matricula/frmMatricula";
	}

	@PostMapping("/guardar")
	public String saveMatricula(@Valid Matricula matricula, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "/matricula/frmMatricula";
		} else {
			matriculaService.insert(matricula);
			/*Registro reg= new Registro();
			reg.setMatricula(matricula);
			for (Alumno alumno : matricula.getAlumno()) {
				reg.setAlumno(alumno);
			}registroService.insert(reg);*/
			model.addAttribute("lstMatriculas", matriculaService.list());
			model.addAttribute("lstAlumnos", alumnoService.list());
			model.addAttribute("lstSecciones", seccionService.list());
			model.addAttribute("lstPeriodos", periodoService.list());
			model.addAttribute("lstCursos", cursoService.list());
			return "redirect:/matriculas/lista";		}
	}

	@RequestMapping("/reporte/{id}")
	public String UpdateMatricula(@PathVariable("id")int id, Model model) {
		try {
		Optional<Matricula> matricula=matriculaService.findMatricula(id);
		model.addAttribute("m", matricula.get());
		/*model.addAttribute("lstMatriculas", matriculaService.list());
		model.addAttribute("lstAlumnos", alumnoService.list());
		model.addAttribute("lstSecciones", seccionService.list());
		model.addAttribute("lstPeriodos", periodoService.list());
		model.addAttribute("lstCursos", cursoService.list());*/
		} catch (Exception e) {
		model.addAttribute("error", e.getMessage());
		}
		return "/matricula/reporte";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String deleteMatricula(@PathVariable("id") int id, Model model) {
		try {
			if (id > 0) {
				matriculaService.delete(id);
				model.addAttribute("lstMatriculas", matriculaService.list());
				model.addAttribute("lstAlumnos", alumnoService.list());
				model.addAttribute("lstSecciones", seccionService.list());
				model.addAttribute("lstPeriodos", periodoService.list());
				model.addAttribute("lstCursos", cursoService.list());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/matriculas/lista";
	}
	
	@PostMapping("/modificar")
	public String updateMatricula(Model model,Matricula m) {
		matriculaService.update(m);
		model.addAttribute("lstMatriculas", matriculaService.list());
		model.addAttribute("lstAlumnos", alumnoService.list());
		model.addAttribute("lstSecciones", seccionService.list());
		model.addAttribute("lstPeriodos", periodoService.list());
		model.addAttribute("lstCursos", cursoService.list());
		return "redirect:/matriculas/lista";
	}
	
}
