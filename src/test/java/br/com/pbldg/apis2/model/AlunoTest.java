package br.com.pbldg.apis2.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.pbldg.todahora.model.Aluno;


public class AlunoTest {
	
	@Test
	public void testSetAluno(){
		Aluno aluno = new Aluno();
		aluno.setNome("Joao");
		
		Assert.assertEquals("Joao", aluno.getNome());
	}

}
