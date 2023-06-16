package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Categoria;
import com.example.model.dto.CategoriaEntradaDto;
import com.example.model.dto.CategoriaSaidaDto;
import com.example.service.CategoriaService;


@RestController
@RequestMapping("categoria")

public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@PostMapping
	public CategoriaSaidaDto criar(@RequestBody CategoriaEntradaDto categoriaEntrada) {
		return service.criar(categoriaEntrada);
	}
	
	@PutMapping("/{id}")
	public void alterar(@PathVariable("id")  Long id,@RequestBody CategoriaEntradaDto categoriaEntrada) {
			service.alterar(id, categoriaEntrada);
	}
	
	@GetMapping("/{id}")
	public CategoriaSaidaDto pegarUm(@PathVariable("id") Long id) {
			return service.pegarUm(id);
	}
	
	@DeleteMapping("/{id}")   
	public void excluir(@PathVariable("id") Long id) {
			service.excluir(id);
	}
	
	@GetMapping
	public List<Categoria> listar() {
			return service.listarCategorias();
	}

}
