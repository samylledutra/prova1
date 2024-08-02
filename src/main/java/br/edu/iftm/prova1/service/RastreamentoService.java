package br.edu.iftm.prova1.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.prova1.model.Rastreamento;
import br.edu.iftm.prova1.repository.RastreamentoRepository;

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
