package todahora;

import org.junit.Test;

import br.com.pbldg.todahora.model.Usuario;
import junit.framework.Assert;

public class UsuarioTest {
	
	@Test
	public void testAlteraSenhaUsuario(){
		Usuario usuario = new Usuario();
		usuario.setSenha("novasenha");
		
		Assert.assertEquals("novasenha", usuario.getSenha());
	}

}
