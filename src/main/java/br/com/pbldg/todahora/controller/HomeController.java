package br.com.pbldg.todahora.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeController {
	
	private String todahora = "agora vai!";

	public String getTodahora() {
		return todahora;
	}

	public void setTodahora(String todahora) {
		this.todahora = todahora;
	}
	
}
