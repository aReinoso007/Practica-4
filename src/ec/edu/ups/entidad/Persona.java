package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy="persona")
	private List<Factura> facturas;

	public Persona() {

	}

	public Persona(String cedula, String nombre, String apellido, String direccion, String correo,
			List<Factura> facturas) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.facturas = facturas;
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

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	
}
