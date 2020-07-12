package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.entidad.Factura;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Rol;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable{


	private static final long serialVersionUID = 1L;
	@EJB
	private PersonaFacade ejbPersonaFacade;
	private FacturaFacade ejbFacturaFacade;
	private String cedula;
	private String apellido;
	private String correo;
	private String direccion;
	private String nombre;
	private Persona persona;
	private List<Factura>listaFacturas;
	private List<Persona> listaPersonas;
	

	public PersonaBean() {}
	
	@PostConstruct
	public void init() {
		//persona = new Persona();
		//listaFacturas = ejbFacturaFacade.findAll();
		listaPersonas = ejbPersonaFacade.findAll();
	}
	
	public String add() {
		ejbPersonaFacade.create(persona);
		return null;
	}

	public List<Persona> listarPersonas() {
		System.out.println(persona.getCedula());
		listaPersonas = ejbPersonaFacade.findAll();
		return listaPersonas;
	}
	
	
	////////////////////////////////////////////////////
	public PersonaFacade getEjbPersonaFacade() {
		return ejbPersonaFacade;
	}

	public void setEjbPersonaFacade(PersonaFacade ejbPersonaFacade) {
		this.ejbPersonaFacade = ejbPersonaFacade;
	}

	public FacturaFacade getEjbFacturaFacade() {
		return ejbFacturaFacade;
	}

	public void setEjbFacturaFacade(FacturaFacade ejbFacturaFacade) {
		this.ejbFacturaFacade = ejbFacturaFacade;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
	
	
}
