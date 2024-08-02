package br.edu.iftm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.model.Rastreamento;
import br.edu.iftm.repository.RastreamentoRepository;

import java.util.List;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

   
    public Rastreamento adicionarRastreamento(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    
    public List<Rastreamento> consultarRastreamentosPorPacoteId(String pacoteId) {
        return rastreamentoRepository.findAllByPacoteId(pacoteId);
    }
}
