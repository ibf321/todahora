
package br.com.pbldg.apis2.service;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.com.pbldg.apis2.model.Mensagem;

import com.google.gson.Gson;


/**
 * Created by pablo on 5/5/16.
 */
public class MessageClientGet {

    public static void main(String args[]){
    	
    	
    	try {
	    	ResteasyClient client = new ResteasyClientBuilder().build();
	    	
	    	ResteasyWebTarget target = client.target("http://localhost:8080/todahora/messages/messageJSON");
	    	
	    	Response response = target.request().get();
	    	
            // Exemplo de requisição post:
//	    	Response response = target.request().post(Entity.entity(msg, "application/json"));
	
	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + response.getStatus());
	        }
	        
	        System.out.println("====> Status da resposta: " + response.getStatus() + "\n");
	
	        String resposta = response.readEntity(String.class);
	        System.out.println("====> Resporta do servidor:");
	        System.out.println( resposta + "\n");
	
	        Gson gson = new Gson();
	        Mensagem msg = gson.fromJson(resposta, Mensagem.class);
	        
	        System.out.println("====> Mensagem json transformada em objeto:");
	        System.out.println("Cabeçalho: " + msg.getCabecalho());
	        System.out.println("Corpo: " + msg.getCorpo());
	        
	        response.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

}
