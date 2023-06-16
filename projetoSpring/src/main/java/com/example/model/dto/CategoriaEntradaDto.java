package com.example.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaEntradaDto {
	
	@NotBlank(message = "campo obrigatório")
	private String nome;

}
