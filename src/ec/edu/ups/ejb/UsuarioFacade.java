package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Usuario;


@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{
	
	 @PersistenceContext(unitName = "Practica-4")
	 private EntityManager em;

	public UsuarioFacade() {
		 super(Usuario.class);
	}
	
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @SuppressWarnings("unchecked")
	public List<Usuario> listarClientes(){
    	String sql = "SELECT u FROM USUARIO u WHERE u.rol_codigo=1";
    	List<Usuario> list = em.createQuery(sql).getResultList();
    	System.out.println("Listado de clientes : "+list);
    	return list;
    }


}
