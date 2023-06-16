package com.example.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Categoria;
import com.example.model.dto.CategoriaEntradaDto;
import com.example.model.dto.CategoriaSaidaDto;
import com.example.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private ModelMapper mapper;

	public CategoriaSaidaDto criar(CategoriaEntradaDto categoriaEntrada) {
			Categoria categoria = mapper.map(categoriaEntrada, Categoria.class);
			repository.save(categoria);
			CategoriaSaidaDto saida = mapper.map(categoria, CategoriaSaidaDto.class);
			return saida;
		
	}

	public void alterar(Long id, CategoriaEntradaDto categoriaEntrada) {
			Optional<Categoria> categoria = repository.findById(id);
			Categoria entityBanco = categoria.get();
			mapper.map(categoriaEntrada, entityBanco);
			repository.save(entityBanco);
		

	}

	public CategoriaSaidaDto pegarUm(Long id) {
			Optional<Categoria> buscandoCategoria = repository.findById(id);
			Categoria entityBanco = buscandoCategoria.get();
			CategoriaSaidaDto saida = mapper.map(entityBanco, CategoriaSaidaDto.class);
			return saida;

	}

	public void excluir(Long id) {
			repository.deleteById(id);
	}
	
	 public List<Categoria> listarCategorias() {
	        return repository.findAll();
	    }


}
