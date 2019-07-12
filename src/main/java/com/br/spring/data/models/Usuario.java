package com.br.spring.data.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "O nome não pode ficar em branco")
	private String nome;
	@NotNull
	@NotBlank(message = "O e-mail não pode ficar em branco")
	private String email;
	@NotNull
	@NotBlank(message = "O CPF não pode ficar em branco")
	@Size(min = 11, max = 11, message = "CPF INVALIDO")
	private String cpf;
	@Min(value = 18, message = "É preciso ser maior de 18 anos")
	@Max(value = 100)
	private int idade;
	
	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
