package pe.edu.upc.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.matricula.entities.Alumno;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

}
