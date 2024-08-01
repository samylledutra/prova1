package br.edu.iftm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.model.Rastreamento;

import java.util.List;

@Repository
public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
    List<Rastreamento> findAllByPacoteId(String pacoteId);
}
