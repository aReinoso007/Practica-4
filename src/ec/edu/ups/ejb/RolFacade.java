package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Rol;

@Stateless
public class RolFacade extends AbstractFacade<Rol>{


	  @PersistenceContext(unitName = "Practica-4")
	  private EntityManager em;
	  
	public RolFacade() {
		super(Rol.class);
	}

	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
