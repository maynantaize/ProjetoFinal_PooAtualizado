package com.example.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FilmeEntradaDto {

	@NotBlank(message = "campo obrigatório")
	private String nome;
	
	@Size( max=500, message="ERRO, máximo permitido é 500 caracters")
	private String descricao;
	
	@URL(message="inválido")
	@NotBlank(message = "campo obrigatório")
	private String url;
	
	@NotNull(message = "campo obrigatório")
	private Long idCategoria;
	

}
