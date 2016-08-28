package br.com.pbldg.apis2.model;


import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTeste {
	
	Calculadora calculadora = new Calculadora();
	
	@Test
	public void testaSomaCalculadora(){
		int a = 4;
		int b = 5;
		int soma = this.calculadora.soma(a, b);
		Assert.assertEquals(9, soma);
	}

}
