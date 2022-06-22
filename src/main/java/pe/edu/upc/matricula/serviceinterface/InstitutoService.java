package pe.edu.upc.matricula.serviceinterface;

import pe.edu.upc.matricula.entities.Instituto;
import pe.edu.upc.matricula.util.Auxiliar;

public interface InstitutoService {
	public void insert(Instituto instituto);


	public Auxiliar buscarUsuario(String username);
}
