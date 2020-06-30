package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.UbicacionFacade;
import ec.edu.ups.entidad.Ubicacion;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UbicacionBean implements Serializable {

	public UbicacionBean() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;

    @EJB
    private UbicacionFacade ejbUbicacionFacade;
    private List<Ubicacion> list;
	private String provincia;
	private String ciudad;
	private String callePrincipal;
	private String calleSecundaria;
	private String numero;
    

  
    
    @PostConstruct
    public void init() {
	ejbUbicacionFacade.create(new Ubicacion( "Azuay", "Cuenca", "Luis Cordero", "Toma de Heres", "4-72"));
	ejbUbicacionFacade.create(new Ubicacion( "Azuay", "Cuenca", "Luis Cordero", "Toma de Heres", "4-72"));
	list = ejbUbicacionFacade.findAll();
    }
        
    public Ubicacion[] getList() {
	return list.toArray(new Ubicacion[0]);
    }

    public void setList(List<Ubicacion> list) {
	this.list = list;
    }

    public String getProvincia() {
	return provincia;
    }

    public void setProvincia(String provincia) {
	this.provincia = provincia;
    }
    
    public String getCiudad() {
	return ciudad;
    }

    public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
    }
    
    public String getCallePrincipal() {
	return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
	this.callePrincipal = callePrincipal;
    }
    
    public String getCalleSecundaria() {
	return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
	this.calleSecundaria = calleSecundaria;
    }
    
    public String getnumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String add() {
	ejbUbicacionFacade.create(new Ubicacion(this.provincia, this.ciudad, this.callePrincipal, this.calleSecundaria, this.numero));
	list = ejbUbicacionFacade.findAll();
	return null;
    }

    public String delete(Ubicacion c) {	
	ejbUbicacionFacade.remove(c);
	list = ejbUbicacionFacade.findAll();
	return null;
    }

    public String edit(Ubicacion c) {
	c.setCiudad("Quito");
	return null;
    }

    public String save(Ubicacion c) {
	ejbUbicacionFacade.edit(c);
	c.setCalleSecundaria("S/C");
	return null;
    }

}
