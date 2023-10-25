package com.seminfo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seminfo.domain.model.EventoModel;

@Repository
public interface EventoRepository extends JpaRepository<EventoModel, Long>{

}
