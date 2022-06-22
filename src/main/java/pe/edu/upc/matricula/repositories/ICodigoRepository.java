package pe.edu.upc.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.matricula.entities.Codigo;

@Repository
public interface ICodigoRepository extends JpaRepository<Codigo, Integer> {
	/*@Query(value="INSERT INTO codigos(id_codigo,nombre)VALUES (1,'SI405'),(2,'DG284'),(3,'AD984'),(4,'AF764'),(5,'ED783');",nativeQuery=true)
	public List<Codigo[]>ListCod();*/
}
