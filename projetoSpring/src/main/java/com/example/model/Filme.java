package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 200)
	private String nome;
	
	@Column(nullable = false, length = 500)
	private String descricao;
	
	@Column(nullable = false, length = 300)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
}
