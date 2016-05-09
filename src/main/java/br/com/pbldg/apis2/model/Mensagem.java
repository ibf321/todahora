package br.com.pbldg.apis2.model;

import java.io.Serializable;

/**
 * @author <a href="mailto:pablol@cicoti.com.br">Pablo Diego</a>
 * 
 */
public class Mensagem implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3256652952240186509L;

	private String cabecalho;

    private String corpo;

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

}
