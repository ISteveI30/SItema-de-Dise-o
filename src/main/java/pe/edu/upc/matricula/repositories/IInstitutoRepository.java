package pe.edu.upc.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.matricula.entities.Instituto;

@Repository
public interface IInstitutoRepository extends JpaRepository<Instituto, Integer> {


	
}
