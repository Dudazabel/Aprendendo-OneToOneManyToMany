package com.weg.AprendendoRelacionamentosMTM_OTO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.AprendendoRelacionamentosMTM_OTO.model.Assento;

@Repository
public interface AssentoRespository extends JpaRepository<Assento, Long>{
    
}
