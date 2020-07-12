package ec.edu.ups.ejb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.FacturaDetalle;

@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle>{

	 @PersistenceContext(unitName = "Practica-4")
	    private EntityManager em;
	
	public FacturaDetalleFacade() {
		super(FacturaDetalle.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

	public List<FacturaDetalle> buscarFacturaDetalle(int codigo){
    	
		List<FacturaDetalle> list = new ArrayList<FacturaDetalle>();
		list = em.createQuery("SELECT * FROM facturadetalle WHERE facturadetalle.CODIGOFACTDET= :codigo", FacturaDetalle.class).setParameter("codigo", codigo).getResultList();


		return list;
	}

}
