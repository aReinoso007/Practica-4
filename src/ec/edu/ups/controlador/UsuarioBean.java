package ec.edu.ups.controlador;

import javax.ejb.EJB;

import org.jboss.weld.context.ejb.Ejb;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Usuario;

public class UsuarioBean {
	
	public UsuarioBean() {
		
	}
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String deireccion;
	private String correo;
	private String pwd;
	public UsuarioFacade getEjbUsuarioFacade() {
		return ejbUsuarioFacade;
	}
	public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
		this.ejbUsuarioFacade = ejbUsuarioFacade;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDeireccion() {
		return deireccion;
	}
	public void setDeireccion(String deireccion) {
		this.deireccion = deireccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//Aqui le agregamos las funcionalidades
	
	public String add(Usuario u) {
		ejbUsuarioFacade.create(u);
		return null;
	}
	
	public String remove(Usuario u) {
		ejbUsuarioFacade.create(u);
		ejbUsuarioFacade.findAll();
		return null;
	}
	
}
