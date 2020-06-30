package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Categoria;

@Stateless
public class CategoriaFacade  extends AbstractFacade<Categoria>{

	  @PersistenceContext(unitName = "Practica_EJB_JSF_JPA")
	    private EntityManager em;
	
	
	public CategoriaFacade() {
		super(Categoria.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
