package br.com.pbldg.apis2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO", schema="apis2")
@SequenceGenerator(name = "UsuarioSequence", sequenceName = "SQ_ID_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSequence")
	private Long id;
	
    @Column(name = "LOGIN", length = 30, nullable = false)
    private String login;
    
    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
    private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void fazBesteira(){
		String s1 = "todahora";
		String s2 = "opa, quem foi que disse epa?";
		String s3 = "Igor está 'vivo'";
		if (s2.equals("todahora")){
			System.out.println("agora vai");
		}
		if (s3.equals("todahora")){
			System.out.println("agora vai");
		}
		if (s1.equals("todahora")) System.out.println("agora vai");
	}
    
    

}
