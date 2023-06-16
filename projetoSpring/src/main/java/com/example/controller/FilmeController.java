package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Filme;
import com.example.model.dto.FilmeEntradaDto;
import com.example.model.dto.FilmeSaidaDto;
import com.example.service.FilmeService;

@RestController
@RequestMapping("filme")
public class FilmeController {

	@Autowired
	private FilmeService servico;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public FilmeSaidaDto criar(@RequestBody FilmeEntradaDto filmeEntrada) {
		return servico.criar(filmeEntrada);
	}
	@PutMapping("/{id}")
	public void alterar(@PathVariable("id")  Long id,@RequestBody FilmeEntradaDto filmeEntrada) {
			servico.alterar(id, filmeEntrada);
	}
	
	@GetMapping("/{id}")
	public FilmeSaidaDto pegarUm(@PathVariable("id") Long id) {
			return servico.pegarUm(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Long id) {
			servico.excluir(id);
	}
	
	@GetMapping
	public List<Filme> listar() {
			return servico.listarFilmes();
	}

}
