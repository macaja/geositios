package presentacion;
import Negocio.gestion.Persona;
import Negocio.gestion.Propietario;
import Negocio.gestion.Usuario;
import datos.ValidarRepository;
public class LogInFacade {
	public Usuario usario;
	public Propietario propietario;
	
	public Persona validar(String email,String clave){
		System.out.println("Vamos en el facade");
		ValidarRepository validarRepository = new ValidarRepository();
		Persona persona=validarRepository.consultarPersona(email, clave);
		
		return persona;
		
	}	
}

