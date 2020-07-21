package ec.edu.ups.controlador;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.FacturaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.entidad.Bodega;
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

	@EJB
	private ProductoFacade ejbProductoFacade;

	@EJB
	private BodegaFacade ejbBodegaFacade;

	private int codigoB;

	private Factura facturaCabecera;
	private FacturaDetalle facturaDetFcat;
	private String nomproducto;

	private String identificacion;
	private String resultado;

	private int codigoProducto;

	private List<Bodega> bodegas;
	private Bodega bodega;

	private int codigoFactura;
	private Date fecha;
	private Persona persona;
	private List<Factura> list;
	private double total;
	private double iva;
	private double subtotal;
	private String estadoFactura;

	private int codigoFactDet;
	private List<FacturaDetalle> listFD;
	private int cantidad;
	private Producto producto;
	private Factura factura;

	private Persona cliente;

	@PostConstruct
	public void init() {

		// list=ejbFacturaFacade.findAll();
		// System.out.println("Facturas:.."+list.toString().toString());
		list = ejbFacturaFacade.findAll();

		bodegas = ejbBodegaFacade.findAll();

	}

	public List<Factura> getList() {
		return list;
	}

	public void setList(List<Factura> list) {
		this.list = list;
	}

	public int getCodigoB() {
		return codigoB;
	}

	public void setCodigoB(int codigoB) {
		this.codigoB = codigoB;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
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

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
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

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getListFD() {
		return listFD;
	}

	public void setListFD(List<FacturaDetalle> listFD) {
		this.listFD = listFD;
	}

	public String getNomproducto() {
		return nomproducto;
	}

	public void setNomproducto(String nomproducto) {
		this.nomproducto = nomproducto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void obtenerCliente(AjaxBehaviorEvent evento) {
		this.persona = new Persona();
		if (this.identificacion != null) {
			System.out.print("Cedula: " + this.identificacion);

			this.persona = ejbPersonaFacade.find(this.identificacion);

			if (persona != null) {
				this.resultado = persona.getNombre() + " " + persona.getApellido();
				this.cliente = persona;
				this.resultado = "Cliente Registrado:";
			} else {
				this.resultado = "El cliente no existe..";
				this.cliente.setApellido(" ");
				this.cliente.setCedula(" ");
				this.cliente.setNombre(" ");
				this.cliente.setDireccion(" ");
				this.cliente.setCorreo(" ");
			}

		}

	}

	public void obtenerProducto(AjaxBehaviorEvent evento) {
		System.out.println("BUSCANDO PRODUCTO....");

		if (this.codigoProducto > 0) {
			this.producto = ejbProductoFacade.find(this.codigoProducto);

			if (this.producto != null) {
				this.nomproducto = producto.getNombre();
			} else {
				this.nomproducto = "Producto no registrado..";

			}
		} else {
			this.codigoProducto = 0;
		}

		System.out.println("Nombre Producto: " + nomproducto);

	}

	public void imprimir() {
		System.out.print("Identificacion: " + this.identificacion);

	}

	public String addFactura() {

		if (this.facturaCabecera == null) {
			fecha = new Date();

			DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
			DateFormat formatoFecha = new SimpleDateFormat("yyyy:MM:dd");

			System.out.println("Son las: " + formatoHora.format(fecha) + " de fecha: " + formatoFecha.format(fecha));

			System.out.println("Codigo Bodega.." + this.codigoB);
			this.bodega = ejbBodegaFacade.find(this.codigoB);
			System.out.println("Estado Factur.." + this.estadoFactura);

			facturaCabecera = new Factura();
			facturaCabecera.setFecha(this.fecha);
			String date = formatoFecha.format(fecha) + " " + formatoHora.format(fecha);
			System.out.println("STRING FECHA: " + date);
			facturaCabecera.setPersona(this.persona);
			facturaCabecera.setEstadoFactura(this.estadoFactura);
			facturaCabecera.setBodega(this.bodega);
			ejbFacturaFacade.create(this.facturaCabecera);

			System.out.println("ID..." + facturaCabecera.getCodigoFactura());

			// facturaCabecera = ejbFacturaFacade.buscarFactura(date, this.identificacion);

			ejbFacturaDetalleFacade.create(new FacturaDetalle(this.cantidad, this.producto, this.facturaCabecera));
			listFD = ejbFacturaDetalleFacade.listarFacturaDetalle(this.facturaCabecera.getCodigoFactura());
			System.out.println("Detalle: " + listFD.get(0).getProducto().getNombre());
			this.facturaCabecera.setDetallesFactura(this.listFD);
			ejbFacturaFacade.edit(this.facturaCabecera);

		} else {

			ejbFacturaDetalleFacade.create(new FacturaDetalle(this.cantidad, this.producto, this.facturaCabecera));

			listFD = ejbFacturaDetalleFacade.listarFacturaDetalle(this.facturaCabecera.getCodigoFactura());

			this.facturaCabecera.setDetallesFactura(this.listFD);
			ejbFacturaFacade.edit(this.facturaCabecera);

		}

		calcularPagos();
		return null;
	}

	public double calcularTotal() {

		double t = 0.0;
		double ivaCal = this.subtotal * 0.12;
		t = this.subtotal + ivaCal;

		return t;
	}

/////////////////////////////////////////////////////////
	public double calcularSubtotal() {
		double sub = 0.0;
		for (FacturaDetalle fact : listFD) {

			sub += fact.getProducto().getPrecioVenta() * fact.getCantidad();
		}

		return sub;
	}

	public void calcularPagos() {
		this.subtotal = redondearDecimales(calcularSubtotal(), 2);
		this.total = redondearDecimales(calcularTotal(), 2);

	}

	public static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}

	public String finalizarFactura() {
		this.facturaCabecera.setIva(0.12);
		this.facturaCabecera.setSubtotal(this.subtotal);
		this.facturaCabecera.setTotal(this.total);

		ejbFacturaFacade.edit(this.facturaCabecera);
		list = ejbFacturaFacade.findAll();
		return "facturado";
	}

	public String delete(FacturaDetalle c) {
		ejbFacturaDetalleFacade.remove(c);
		listFD=ejbFacturaDetalleFacade.listarFacturaDetalle(this.facturaCabecera.getCodigoFactura());
		return null;
	}

	public String edit(FacturaDetalle c) {
		c.setEditable(true);
		return null;
	}

	public String save(FacturaDetalle c) {

		ejbFacturaDetalleFacade.edit(c);
		listFD=ejbFacturaDetalleFacade.listarFacturaDetalle(this.facturaCabecera.getCodigoFactura());
		calcularPagos();
		c.setEditable(false);
		return null;
	}

}
