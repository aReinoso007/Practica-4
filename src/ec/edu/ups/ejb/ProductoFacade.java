package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.entidad.Producto;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "Practica-4")
    private EntityManager em;
    
	public ProductoFacade() {
		super(Producto.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @SuppressWarnings("unchecked")
	public List<Producto> listarProductos(){
    	Query nq = em.createNativeQuery("SELECT * FROM producto", Producto.class);
    	System.out.println("Listando productos desde facade usuario");
    	System.out.println("Lista desde Productofacade"+nq.getResultList());
    	return (List<Producto>) nq.getResultList();
    }
    
    public Producto obtenerProductos(String porducto) {
    	Query nq = em.createNativeQuery("SELECT * FROM producto WHERE nombre= ?", Producto.class);
    	nq.setParameter(1, porducto);
    	System.out.println("Obteniendo producto desde categoriafacade");
    	System.out.println("Producto obtenido: "+nq.getSingleResult());
    	return (Producto) nq.getSingleResult();
    }

}
