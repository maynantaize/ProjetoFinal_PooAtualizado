package com.example.model.dto;

import com.example.model.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmeSaidaDto {

	private Long id;
	private String nome;
	private String descricao;
	private String url;
	private Categoria categoria;


}
