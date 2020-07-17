package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Usuario;

@Path("/service2")
public class ApiRest2 {
	
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	@EJB
	private RolFacade ejbRolFacade;
	
	private Usuario usuario;
	
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
	

}
