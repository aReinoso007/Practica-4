package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula;
	@Column(nullable = false, length = 250)
	private String nombre;
	@Column(nullable = false, length = 50)
	private String apellido;
	@Column(nullable = false, length = 50)
	private String direccion;
	private String correo;
	private String contrasena;
	@OneToOne
	@JoinColumn
	private Rol rol;


	public Usuario() {
	
	}

	

	public Usuario(String cedula, String nombre, String apellido, String direccion, String correo, String contrasena) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.contrasena = contrasena;
	}


	public Usuario(String cedula, String nombre, String apellido, String direccion, String correo, String contrasena,
			Rol rol) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rol = rol;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
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



	public Rol getRol() {
		return rol;
	}



	public void setRol(Rol rol) {
		this.rol = rol;
	}

   
}
