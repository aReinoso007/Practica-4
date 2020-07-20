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

import com.sun.faces.util.Json;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Rol;
import ec.edu.ups.entidad.Usuario;

@Path("/Usuarios/")
public class UsuarioResource {
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private RolFacade ejbRolFacade;
	
	private Usuario usuario;
	private Rol rol;
	
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listadoUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Jsonb jsonb = JsonbBuilder.create();
		
		listaUsuarios = ejbUsuarioFacade.findAll();
		System.out.println("usuarios recuperados: "+listaUsuarios);
		
		return Response.ok(jsonb.toJson(listaUsuarios))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}
	
	@GET
	@Path("/{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuario(@PathParam("cedula") String cedula) {
		Usuario usu = new Usuario();
		Jsonb jsonb = JsonbBuilder.create();
		usu = ejbUsuarioFacade.find(cedula);
		System.out.println("usuario recuperado: "+usu);
		
		return Response.ok(jsonb.toJson(usu))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
		
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response registrar(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("cedula") String cedula, 
			@FormParam("direccion") String direccion, @FormParam("correo") String correo, @FormParam("contrasena") String contrasena) {
		
		System.out.println("creando nuevo usuario");
		rol = ejbRolFacade.find(1);
		System.out.println("rol de cliente: "+rol);
		usuario = new Usuario(cedula, nombre, apellido, direccion, correo, contrasena, rol);
		System.out.println("persistiendo usuario");
		ejbUsuarioFacade.create(usuario);
		
		return Response.ok("exito")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}

}
