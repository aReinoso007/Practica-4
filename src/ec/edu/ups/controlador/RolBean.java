package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class RolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private RolFacade ejbRolFacade;
	private int codigo;
	private String descripcion;
	private List<Rol> lista;
	
	public RolBean() {
		
	}
	
	@PostConstruct
	public void init() {
		lista = ejbRolFacade.findAll();
		System.out.println("lista: "+lista);
		
	}
	
	
	
	public List<Rol> getLista() {
		return lista;
	}

	public void setLista(List<Rol> lista) {
		this.lista = lista;
	}

	public RolFacade getEjbRolFacade() {
		return ejbRolFacade;
	}

	public void setEjbRolFacade(RolFacade ejbRolFacade) {
		this.ejbRolFacade = ejbRolFacade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
