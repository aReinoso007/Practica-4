package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Factura
 *
 */
@Entity

public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoFactura;
	
	private Date fecha;
	
	

	@ManyToOne
	@JoinColumn
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="factura")
	private List<FacturaDetalle> detallesFactura;
	
	private Double total;
	private Double iva;
	private Double subtotal;
	private boolean estadoFactura;

	public Factura() {
		
	}

	public Factura(Date fecha, Persona persona, List<FacturaDetalle> detallesFactura, Double total, Double iva,
			Double subtotal, boolean estadoFactura) {
		super();
		this.fecha = fecha;
		this.persona = persona;
		this.detallesFactura = detallesFactura;
		this.total = total;
		this.iva = iva;
		this.subtotal = subtotal;
		this.estadoFactura = estadoFactura;
	}

	public int getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<FacturaDetalle> getDetallesFactura() {
		return detallesFactura;
	}

	public void setDetallesFactura(List<FacturaDetalle> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(boolean estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoFactura;
		result = prime * result + ((detallesFactura == null) ? 0 : detallesFactura.hashCode());
		result = prime * result + (estadoFactura ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((iva == null) ? 0 : iva.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (codigoFactura != other.codigoFactura)
			return false;
		if (detallesFactura == null) {
			if (other.detallesFactura != null)
				return false;
		} else if (!detallesFactura.equals(other.detallesFactura))
			return false;
		if (estadoFactura != other.estadoFactura)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (iva == null) {
			if (other.iva != null)
				return false;
		} else if (!iva.equals(other.iva))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	


	
	
   
}
