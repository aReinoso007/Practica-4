package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

//import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Rol;
import ec.edu.ups.entidad.Usuario;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	//private RolFacade ejbRolFacade;
	private List<Rol> lista;
	private List<Usuario> list;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String contrasena;
	private Rol rol;
	
	
	public UsuarioBean() {}
	
	@PostConstruct
	public void init() {
		list = ejbUsuarioFacade.findAll();
		//lista = ejbRolFacade.findAll();
	}	
	//Aqui le agregamos las funcionalidades
	/*
	public List<Rol> obtenerRol() {
		listaRoles = ejbRolFacade.findAll();
		return listaRoles;
	}*/
	public String add() {
		//Rol r = new Rol();
		ejbUsuarioFacade.create(new Usuario(this.cedula, this.nombres, this.apellidos, this.direccion, this.correo, this.contrasena, this.rol));
		return null;
	}
	
	public String remove(Usuario u) {
		ejbUsuarioFacade.remove(u);
		//ejbUsuarioFacade.findAll();
		return null;
	}

	public UsuarioFacade getEjbUsuarioFacade() {
		return ejbUsuarioFacade;
	}

	public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
		this.ejbUsuarioFacade = ejbUsuarioFacade;
	}

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public List<Rol> getLista() {
		return lista;
	}

	public void setLista(List<Rol> listaRoles) {
		this.lista = listaRoles;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
		
}
