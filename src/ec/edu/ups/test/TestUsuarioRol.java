package ec.edu.ups.test;


import java.util.List;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.entidad.Rol;
import ec.edu.ups.entidad.Usuario;

public class TestUsuarioRol {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		UsuarioFacade usuF = new UsuarioFacade();
		RolFacade rolF;
		Rol rol;
		
		
		rol = new Rol("empleado");
		
		//usuarioF.create(new Usuario("1400898526", "test", "testAp", "macas", "test@test.com","123", rol));
		
		//Usuario usu = new Usuario("1400898526", "test", "testAp", "macas", "test@test.com","123", rol);
		//usuF.create( new Usuario("1400898526", "test", "testAp", "macas", "test@test.com","123", rol));
		List<Usuario> usu = usuF.findAll();
		System.out.println(usu);
	}

}
