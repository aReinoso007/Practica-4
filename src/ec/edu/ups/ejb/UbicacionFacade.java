package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.Ubicacion;

@Stateless
public class UbicacionFacade  extends AbstractFacade<Ubicacion> {

	 @PersistenceContext(unitName = "Practica-4")
	    private EntityManager em;
	
	public UbicacionFacade() {
		super(Ubicacion.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
