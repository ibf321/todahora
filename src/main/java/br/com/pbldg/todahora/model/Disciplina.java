package br.com.pbldg.todahora.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="apis2")
@SequenceGenerator(name = "DisciplinaSequence", sequenceName = "SQ_ID_DISCIPLINA", allocationSize = 1)
public class Disciplina {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DisciplinaSequence")
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy="disciplinas")
	private List<Aluno> alunos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
