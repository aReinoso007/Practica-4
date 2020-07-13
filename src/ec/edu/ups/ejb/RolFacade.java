package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Rol obtenerRol(int codigoRol) {
    	Query nq = em.createNativeQuery("SELECT * FROM rol where codigo=?", Rol.class);
    	nq.setParameter(1, codigoRol);
    	System.out.println("Obteniendo rol desde rolfacade");
    	return (Rol) nq.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<Rol> listarRoles(){
    	Query nq = em.createNativeQuery("SELECT * FROM rol", Rol.class);
    	System.out.println("obteniendo lista de roles");
    	System.out.println("lista de roles: "+nq.getResultList());
    	return (List<Rol>) nq.getResultList();
    }	

}
