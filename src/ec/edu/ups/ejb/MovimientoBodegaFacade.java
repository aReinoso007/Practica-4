package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.MovimientoBodega;

@Stateless
public class MovimientoBodegaFacade  extends AbstractFacade<MovimientoBodega>{

	 @PersistenceContext(unitName = "Practica-4")
    private EntityManager em;
	public MovimientoBodegaFacade() {
		super(MovimientoBodega.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    @SuppressWarnings("unchecked")
	public List<MovimientoBodega> listarBodegaProductos(int codigo){
    	Query nq = em.createNativeQuery("SELECT * FROM movimientobodega WHERE bodega_codigobodea=?", MovimientoBodega.class);
    	nq.setParameter(1, codigo);
    	
    	return (List<MovimientoBodega>) nq.getResultList();
    }
    

}
