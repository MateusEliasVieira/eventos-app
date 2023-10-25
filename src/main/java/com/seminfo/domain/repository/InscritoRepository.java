package com.seminfo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seminfo.domain.model.InscritoModel;

@Repository
public interface InscritoRepository extends JpaRepository<InscritoModel,Long>{

}
