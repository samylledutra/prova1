package br.edu.iftm.prova1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.prova1.model.Endereco;



@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
