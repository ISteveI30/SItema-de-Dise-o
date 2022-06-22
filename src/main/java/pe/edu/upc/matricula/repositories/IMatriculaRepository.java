package pe.edu.upc.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.matricula.entities.Matricula;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Integer>{

}
