package ec.edu.ups.ejb;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Factura;

@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

	@PersistenceContext(unitName = "Practica-4")
	private EntityManager em;

	public FacturaFacade() {
		super(Factura.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Factura buscarFactura(String fecha, String cedula) {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM factura WHERE fecha = ? AND PERSONA_CEDULA =? ", Factura.class);
		nativeQuery.setParameter(1, fecha);
		nativeQuery.setParameter(2, cedula);

		return (Factura) nativeQuery.getSingleResult();
	}
}
