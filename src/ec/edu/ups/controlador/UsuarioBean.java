package ec.edu.ups.controlador;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.weld.context.ejb.Ejb;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Usuario;

public class UsuarioBean {
	
	
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	private List<Usuario> list;
	
	public UsuarioBean() {}
	
	public void init() {
		list = ejbUsuarioFacade.findAll();
	}	
	//Aqui le agregamos las funcionalidades
	
	public String add() {
		ejbUsuarioFacade.create(new Usuario());
		ejbUsuarioFacade.findAll();
		return null;
	}
	
	public String remove(Usuario u) {
		ejbUsuarioFacade.remove(u);
		ejbUsuarioFacade.findAll();
		return null;
	}
	
	
	
}
