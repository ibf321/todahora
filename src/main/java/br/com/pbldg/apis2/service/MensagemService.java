package br.com.pbldg.apis2.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.pbldg.apis2.model.Mensagem;

/**
 * Classe responsável por tratar serviços REST da entidade Mensagem.
 * 
 * @author <a href="mailto:pablo@cicoti.com.br">Pablo Diego</a>
 */
@Path("/messages")
public class MensagemService {

    /**
     * Método utilizado para recuperar uma mensagem estática.
     * @return Objeto mensagem com um conteúdo estático via json.
     */
    @GET
    @Path("/messageJSON")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Mensagem getMessageJSON(){
        Mensagem mensagem = new Mensagem();
        mensagem.setCabecalho("Cabeçalho");
        mensagem.setCorpo("Corpo da mensagem é esse aqui");
        return mensagem;
    }
    
    public Integer getTamanhoMensagemBytes(){
    	return 0;
    }
    
    
}
