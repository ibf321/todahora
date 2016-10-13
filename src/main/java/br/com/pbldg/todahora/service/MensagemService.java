package br.com.pbldg.todahora.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pbldg.todahora.model.Mensagem;

/**
 * Classe responsável por tratar serviços REST da entidade Mensagem.
 * 
 * @author <a href="mailto:pablo@cicoti.com.br">Pablo Diego</a>
 */
@Path("/mensagem")
public class MensagemService {

    /**
     * Método utilizado para recuperar uma mensagem estática.
     * @return Objeto mensagem com um conteúdo estático via json.
     */
    @GET @Path("/mensagemGetJson") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Mensagem getMessageJSON(){
        Mensagem mensagem = new Mensagem();
        mensagem.setCabecalho("Cabeçalho");
        mensagem.setCorpo("Corpo da mensagem é esse aqui");
        return mensagem;
    }
    
    @POST
    @Path("/mensagemPostJson")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response consomeMensagemJSON(Mensagem mensagem){
    	String result = "Product created : " + mensagem;
		return Response.status(201).entity(result).build();
    }
    
    
}
