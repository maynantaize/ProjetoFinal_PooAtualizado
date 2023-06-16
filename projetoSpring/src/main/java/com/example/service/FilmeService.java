package com.example.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Categoria;
import com.example.model.Filme;
import com.example.model.dto.FilmeEntradaDto;
import com.example.model.dto.FilmeSaidaDto;
import com.example.repository.CategoriaRepository;
import com.example.repository.FilmeRepository;

@org.springframework.stereotype.Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper mapper;

	public FilmeSaidaDto criar(FilmeEntradaDto filmeEntrada) {

		Filme filme = mapper.map(filmeEntrada, Filme.class);
		Optional<Categoria> buscandoCategoria = categoriaRepository.findById(filmeEntrada.getIdCategoria());
		if (buscandoCategoria.isPresent()) {
			Categoria categoria = buscandoCategoria.get();
			filme.setCategoria(categoria);
		}

		repository.save(filme);
		FilmeSaidaDto saida = mapper.map(filme, FilmeSaidaDto.class);

		return saida;
	}

	public void alterar(Long id, FilmeEntradaDto filmeEntrada) {
			Optional<Filme> filme = repository.findById(id);
			Filme entityBanco = filme.get();
			
			Optional<Categoria> buscandoCategoria = categoriaRepository.findById(filmeEntrada.getIdCategoria());
			if (buscandoCategoria.isPresent()) {
				Categoria categoria = buscandoCategoria.get();
				entityBanco.setCategoria(categoria);
			}
			
			mapper.map(filmeEntrada, entityBanco);
			repository.save(entityBanco);
		
	}


	public FilmeSaidaDto pegarUm(Long id) {
			Optional<Filme> buscandoFilme = repository.findById(id);
			Filme entityBanco = buscandoFilme.get();
			FilmeSaidaDto saida = mapper.map(entityBanco, FilmeSaidaDto.class);
			return saida;
		
	}

	public void excluir(Long id) {
			repository.deleteById(id);
		
	}
	 public List<Filme> listarFilmes() {
	        return repository.findAll();
	    }
}
