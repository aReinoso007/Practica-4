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
    

	public List<FacturaDetalle> buscarFactura(int codigo){
    	
		List<FacturaDetalle> list = new ArrayList<FacturaDetalle>();
		
		ResultSet rs = (ResultSet) em.createQuery("SELECT * FROM facturadetalle WHERE facturadetalle.CODIGOFACTDET="+ codigo);
		try {
			while (rs.next()) {
				list.add(new FacturaDetalle(rs.getInt("CODIGOFACTDET"), rs.getInt("cantidad"), rs.getInt("FACTURA_CODIGOFACTURA"),rs.getInt("PRODUCTO_CODIGOPRODUCTO")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return list;
	}

}
