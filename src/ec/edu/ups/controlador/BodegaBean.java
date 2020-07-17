package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.entidad.Bodega;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private BodegaFacade ejbBodegaFacade;
	private List<Bodega> listBodega;
	private String nombre;
	
	
}
