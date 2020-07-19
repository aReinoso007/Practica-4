package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Producto;
import ec.edu.ups.entidad.Rol;
import ec.edu.ups.entidad.Usuario;

@Path("/service2")
public class ApiRest2 {
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private RolFacade ejbRolFacade;
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	private Usuario usuario;
	private Rol rol;
	
	@GET
	@Path("/listadousuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Jsonb jsonb = JsonbBuilder.create();
		listaUsuarios = ejbUsuarioFacade.findAll();
		System.out.println("retornando lista de usuarios");
		return Response.ok(jsonb.toJson(listaUsuarios))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@GET
	@Path("/productos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProductos() {
		List<Producto> listaProductos = new ArrayList<Producto>();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println("listando productos");
		listaProductos = ejbProductoFacade.findAll();
		System.out.println("productos: "+listaProductos);
		return Response.ok(jsonb.toJson(listaProductos))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@POST
	@Path("/usuarios")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response post(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("cedula") String cedula, 
			@FormParam("direccion") String direccion, @FormParam("correo") String correo, @FormParam("contrasena") String contrasena) {
		
		System.out.println("creando nuevo usuario");
		rol = ejbRolFacade.find(1);
		System.out.println("rol del cliente: "+rol);
		
		usuario = new Usuario(cedula, nombre, apellido, direccion, correo, contrasena, rol);
		System.out.println("persistiendo usuario");
		ejbUsuarioFacade.create(usuario);
		
		
		return Response.ok("exito")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@POST
	@Path("/inicio")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inicio(@FormParam("correo") String correo, @FormParam("contrasena") String contrasena) {
		
		Usuario usu = new Usuario();
		System.out.println("validando ingreso de usuario");
		usu = ejbUsuarioFacade.validarIngresoPorRol(correo, contrasena);
		System.out.println("usuario recuperado: "+usu);
		return Response.ok("log in exitoso")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		
	}
	
	@GET
	@Path("/listadousuarios/correo/{correo}/contrasena/{contrasena}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario login(@PathParam("correo") String correo, @PathParam("contrasena") String contrasena) {
		Usuario usu = new Usuario();
		usu = ejbUsuarioFacade.validarIngresoPorRol(correo, contrasena);
		System.out.println("retornando usuario:"+usu);
		return usu;
	}
		

}
