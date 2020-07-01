package ec.edu.ups.controlador;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.entidad.Factura;
import ec.edu.ups.entidad.FacturaDetalle;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Producto;


public class FacturaBean {

	public FacturaBean() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@EJB
	private FacturaFacade ejbFacturaFacade;

	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade;
	
	
	private Factura facturaCabecera;
	private FacturaDetalle facturaDetFcat;
	
	

	private int codigoFactura;
	private Date fecha;
	private Persona persona;
	private List<Factura> list;
	private Double total;
	private Double iva;
	private Double subtotal;
	private boolean estadoFactura;

	private int codigoFactDet;
	private List<FacturaDetalle> listFD;
	private int cantidad;
	private Producto producto;
	private Factura factura;

	@PostConstruct
	public void init() {
		list = ejbFacturaFacade.findAll();
		listFD = ejbFacturaDetalleFacade.findAll();
	}

	

	public List<FacturaDetalle> getListFD() {
		return listFD;
	}



	public void setListFD(List<FacturaDetalle> listFD) {
		this.listFD = listFD;
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

	public List<Factura> getList() {
		return list;
	}

	public void setList(List<Factura> list) {
		this.list = list;
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

	public int getCodigoFactDet() {
		return codigoFactDet;
	}

	public void setCodigoFactDet(int codigoFactDet) {
		this.codigoFactDet = codigoFactDet;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String addFactura() {
		Date fecha = new Date();
		facturaCabecera = new Factura(fecha, persona);
		ejbFacturaFacade.create(facturaCabecera);
		list = ejbFacturaFacade.findAll();
		return null;
	}

	public String addFacturaDetalle() {
		facturaDetFcat = new FacturaDetalle( this.cantidad, this.producto, this.facturaCabecera);
		ejbFacturaDetalleFacade.create(facturaDetFcat);
		listFD = ejbFacturaDetalleFacade.findAll();
		return null;
	}

	public String delete(FacturaDetalle c) {
		ejbFacturaDetalleFacade.remove(c);
		listFD = ejbFacturaDetalleFacade.findAll();
		return null;
	}

	public String edit(FacturaDetalle c) {
	
		return null;
	}

	public String save(FacturaDetalle c) {
		ejbFacturaDetalleFacade.edit(c);

		return null;
	}

}
