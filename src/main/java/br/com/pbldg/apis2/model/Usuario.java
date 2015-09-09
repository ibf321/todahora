package br.com.pbldg.apis2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO", schema="apis2")
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

}
