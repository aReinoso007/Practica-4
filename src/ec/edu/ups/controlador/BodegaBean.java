package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.ManagedProperty;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UbicacionFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Producto;
import ec.edu.ups.entidad.Ubicacion;
import ec.edu.ups.entidad.Usuario;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named

@SessionScoped
public class BodegaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private BodegaFacade ejbBodegaFacade;
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB
	private UbicacionFacade ejbUbicacionFacade;
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	

	
	private List<Bodega> listaBodega;
	private List<Producto> listaProducto;
	private List<Ubicacion> listaUbicacion;
	private List<Usuario> listAdministrador;
	
	
	private String nombreBodega;
	
	private Producto producto;
	private Ubicacion ubicacion;
	private Usuario administrador;
	
	private String cedulaAdm;
	
	/////
	
	private String provincia;
	private String ciudad;
	private String callePrincipal;
	private String calleSecundaria;
	private String numero;
	////
	
	private int resultadoPro;
	private Ubicacion resultadoUbi;
	private Usuario resultadoUsu;
	
	public BodegaBean() {
		super();
	}
	
	@PostConstruct
	public void init() {
		listaBodega = ejbBodegaFacade.findAll();
		listaBodega = ejbBodegaFacade.listarBodegas();
		//System.out.println("Listado Bodegas");
		listaProducto = ejbProductoFacade.findAll();
		listaProducto = ejbProductoFacade.listarProductos();
		listAdministrador = ejbBodegaFacade.obtenerAdministradores();
		System.out.println("Lista de administradores: "+listAdministrador);
		//System.out.println("Listado Productos");	
	}
	
	public void obtenerProducto(AjaxBehaviorEvent evento) {
		this.producto = new Producto();
		this.producto = ejbProductoFacade.find(this.producto);
		if (producto != null) {
			this.resultadoPro = ejbProductoFacade.count();
		} else {
			this.resultadoPro = 0; 
		}	
	}
	
	public void obtenerUbicabion(AjaxBehaviorEvent evento) {
		this.ubicacion = new Ubicacion();
		this.ubicacion = ejbUbicacionFacade.find(this.ubicacion);
		if (ubicacion != null) {
			this.resultadoUbi = ejbUbicacionFacade.find(this.ubicacion);
		} else {
			this.resultadoUbi = null; 
		}	
	}
	/*
	public void obtenerUsuario(AjaxBehaviorEvent evento) {
		
		this.administrador = new Usuario();
		this.administrador = ejbUsuarioFacade.find(this.administrador);
		if (administrador != null) {
			this.resultadoUsu = ejbUsuarioFacade.find(this.administrador);
		} else {
			this.resultadoUsu = null; 
		}	
	}
	*/
	public String add() {
		

		ejbUbicacionFacade.create(new Ubicacion(this.provincia, this.ciudad, this.callePrincipal, this.calleSecundaria, this.numero));
		ubicacion = ejbUbicacionFacade.buscarUbicacion(this.provincia, this.ciudad, this.numero);
		
		System.out.println("ubicacion creada: "+ubicacion);
		
		Usuario administradors = new Usuario();
		administradors = ejbUsuarioFacade.find(cedulaAdm);
		System.out.println("usuario recuperado: "+administradors);
		
		ejbBodegaFacade.create(new Bodega(this.nombreBodega,this.ubicacion, administradors));
		System.out.println("bodega ingresada");
		System.out.println("recuperando lista de bodegas");
		listaBodega = ejbBodegaFacade.findAll();
		return null;
	}
	
	public String delete(Bodega b) {
		ejbBodegaFacade.remove(b);
		listaBodega = ejbBodegaFacade.findAll();
		return null;
	}
	
	public String edit(Bodega b) {
		b.setEditable(true);
		return null;
	}
	
	public String save(Bodega b) {
		ejbBodegaFacade.edit(b);
		b.setEditable(false);
		return null;
	}
	
	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}
	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}
	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}
	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}
	public UbicacionFacade getEjbUbicacionFacade() {
		return ejbUbicacionFacade;
	}
	public void setEjbUbicacionFacade(UbicacionFacade ejbUbicacionFacade) {
		this.ejbUbicacionFacade = ejbUbicacionFacade;
	}	
	public UsuarioFacade getEjbUsuarioFacade() {
		return ejbUsuarioFacade;
	}
	public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
		this.ejbUsuarioFacade = ejbUsuarioFacade;
	}

	public List<Bodega> getListaBodega() {
		return listaBodega;
	}
	public void setListaBodega(List<Bodega> listaBodega) {
		this.listaBodega = listaBodega;
	}
	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	public List<Ubicacion> getListaUbicacion() {
		return listaUbicacion;
	}
	public void setListaUbicacion(List<Ubicacion> listaUbicacion) {
		this.listaUbicacion = listaUbicacion;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getResultadoPro() {
		return resultadoPro;
	}
	public void setResultadoPro(int resultadoPro) {
		this.resultadoPro = resultadoPro;
	}
	public List<Usuario> getListAdministrador() {
		return listAdministrador;
	}
	public void setListAdministrador(List<Usuario> listAdministrador) {
		this.listAdministrador = listAdministrador;
	}
	public Usuario getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}
	public Ubicacion getResultadoUbi() {
		return resultadoUbi;
	}
	public void setResultadoUbi(Ubicacion resultadoUbi) {
		this.resultadoUbi = resultadoUbi;
	}
	public Usuario getResultadoUsu() {
		return resultadoUsu;
	}
	public void setResultadoUsu(Usuario resultadoUsu) {
		this.resultadoUsu = resultadoUsu;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedulaAdm() {
		return cedulaAdm;
	}

	public void setCedulaAdm(String cedulaAdm) {
		this.cedulaAdm = cedulaAdm;
	}
	
	

	
	/////
	
	
	
	

}
