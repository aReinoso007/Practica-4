package ec.edu.ups.controlador;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.MovimientoBodegaFacade;
import ec.edu.ups.ejb.ProductoFacade;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@ApplicationScoped
public class MovimientoBodegaBean {
	
	@EJB
	private MovimientoBodegaFacade ejbMovBode;
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB
	private BodegaFacade ejbBodegaFacade;

}
