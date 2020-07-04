package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void crearUsurio(Usuario u) {
    	
    }

}
