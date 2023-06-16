package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	

	
}
