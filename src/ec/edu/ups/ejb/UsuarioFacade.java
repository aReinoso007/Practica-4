package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Usuario;


@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{
	
	 @PersistenceContext(unitName = "Practica-4")
	 private EntityManager em;

	public UsuarioFacade() {
		 super(Usuario.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listarClientes(){
    	Query nq = em.createNativeQuery("SELECT * FROM usuario", Usuario.class);
    	System.out.println("Listando clientesde desde facade usuario");
    	System.out.println("lista desde usufacade"+nq.getResultList());
    	return (List<Usuario>) nq.getResultList();
    }

    
    @SuppressWarnings("unchecked")
	public Usuario validarIngreso(String correo, String pass) {
    	System.out.println("Validando ingreso");
    	Query query = em.createNamedQuery("getByCorreo");
    	query.setParameter("correo", correo);
    	query.setParameter("pass", pass);
    	List<Usuario> resultado = query.getResultList();
    	Usuario respuesta = null;
    	if(resultado != null) {
    		System.out.println("resultado: "+resultado);
    		respuesta = (Usuario) resultado.get(0);
    		System.out.println("respuesta: "+respuesta);
    		System.out.println("exito");
    	}
    	return (Usuario) respuesta;
    }

}
