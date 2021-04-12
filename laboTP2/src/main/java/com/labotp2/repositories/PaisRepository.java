package com.labotp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labotp2.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	
}
