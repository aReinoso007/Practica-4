package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.MovimientoBodega;

@Stateless
public class MovimientoBodegaFacade  extends AbstractFacade<MovimientoBodega>{

	 @PersistenceContext(unitName = "Practica_EJB_JSF_JPA")
    private EntityManager em;
	public MovimientoBodegaFacade() {
		super(MovimientoBodega.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
