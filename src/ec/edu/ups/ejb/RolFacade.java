package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public Rol obtenerRol(String nombreRol) {
    	Rol rol = new Rol();
    	String sql = "SELECT r FROM ROL r where r.descripcion='"+nombreRol+"'";
    	rol = (Rol) em.createQuery(sql).getSingleResult();
    	return rol;
    }
    
    @SuppressWarnings("unchecked")
	public List<Rol> listarRoles(){
    	List<Rol> listaRoles = new ArrayList<Rol>();
    	String sql = "SELECT * FROM ROL";
    	
    	listaRoles = em.createQuery(sql).getResultList();
    	System.out.println("roles: "+listaRoles);
    	return listaRoles;
    }	

}
