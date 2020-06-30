package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Persona extends AbstractFacade<Persona> {

	@PersistenceContext(unitName = "Practica-4")
    private EntityManager em;
	public Persona() {
		super(Persona.class);
	}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
