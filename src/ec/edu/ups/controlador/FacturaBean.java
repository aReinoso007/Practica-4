package ec.edu.ups.controlador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad.Factura;
import ec.edu.ups.entidad.FacturaDetalle;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Producto;
import ec.edu.ups.entidad.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaBean implements Serializable {

	public FacturaBean() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@EJB
	private FacturaFacade ejbFacturaFacade;

	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade;

	@EJB
	private PersonaFacade ejbPersonaFacade;
	
	@EJB
	private RolFacade ejbRolFacade;
	
	@EJB
	private PedidoFacade ejbPedidoFacade;
	
	
	private Factura facturaCabecera;
	private FacturaDetalle facturaDetFcat;

	private String identificacion;
	private String resultado;

	private int codigoFactura;
	private Date fecha;
	private Persona persona;
	private List<Factura> list;
	private Double total;
	private Double iva;
	private Double subtotal;
	private String estadoFactura ;

	private int codigoFactDet;
	private List<FacturaDetalle> listFD;
	private int cantidad;
	private Producto producto;
	private Factura factura;
	
	@PostConstruct
	public void init() {
		
		//list=ejbFacturaFacade.findAll();
		//System.out.println("Facturas:.."+list.toString().toString());
		
		

	}
	
	
	
	public String getIdentificacion() {
		return identificacion;
	}



	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	public String getResultado() {
		return resultado;
	}



	public void setResultado(String resultado) {
		this.resultado = resultado;
	}



	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public String getEstadoFactura() {
		return estadoFactura;
	}



	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}



	public void obtenerCliente(AjaxBehaviorEvent evento) {
		this.persona = new Persona();
		System.out.print("Cedula: "+this.identificacion);
		
		  this.persona = ejbPersonaFacade.find(this.identificacion); if (persona != null) {
		  this.resultado = persona.getNombre() + " " + persona.getApellido(); } else {
		  this.resultado = "El cliente no existe.."; }
		 
	}
	
	public void imprimir() {
		System.out.print("Identificacion: "+this.identificacion);
		
	}
	
	public String addFactura() {
		fecha = new Date(); 
		
//		
//		  facturaCabecera = new Factura();
//		  facturaCabecera.setFecha(this.fecha);
//		  facturaCabecera.setPersona(this.persona);
//		  facturaCabecera.setEstadoFactura(this.estadoFactura);
//		  ejbFacturaFacade.create(facturaCabecera); 
		  
			System.out.println(fecha.toString());
			Factura fact=ejbFacturaFacade.buscarFactura("2020-07-11 15:23:31", "0151027299");
			System.out.println(fact.getPersona().getApellido());
		 
		
		return null;
	}
	
}
