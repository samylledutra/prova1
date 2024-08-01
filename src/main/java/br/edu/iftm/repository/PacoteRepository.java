package br.edu.iftm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, String> {
}
