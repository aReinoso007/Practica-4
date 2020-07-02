package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad.Rol;

@SessionScoped
@Named
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class RolBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private RolFacade ejbRolFacade;
	private int codigo;
	private String descripcion;
	
	public RolBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
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
