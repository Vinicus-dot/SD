package com.eventoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventoapp.models.Evento;


public interface EventoRepository extends JpaRepository<Evento, Long> {

	@Query(value="select * from evento where name like %?1%",nativeQuery = true)
	List<Evento> findLikeName(String name);

	
}
