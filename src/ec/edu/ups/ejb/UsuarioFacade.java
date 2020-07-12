package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    	/*String sql = "SELECT * FROM USUARIO";
    	List<Usuario> list = em.createQuery(sql).getResultList();
    	System.out.println("Listado de clientes : "+list);*/
    	return null;
    }

    
    public Usuario validarIngreso(String correo, String pass) {
    	Query query = em.createNamedQuery("getByCorreo");
    	query.setParameter("correo", correo);
    	query.setParameter("pass", pass);
    	List resultado = query.getResultList();
    	Usuario respuesta = null;
    	if(!resultado.isEmpty()) {
    		respuesta = (Usuario) resultado.get(0);
    	}
    	return respuesta;
    }

}
