package br.edu.iftm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.model.Pacote;
import br.edu.iftm.repository.PacoteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    
    public Pacote cadastrarPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    
    public Pacote atualizarPacote(String id, Pacote pacoteAtualizado) {
        Optional<Pacote> optionalPacote = pacoteRepository.findById(id);
        if (optionalPacote.isPresent()) {
            Pacote pacote = optionalPacote.get();
            pacote.setDestinatario(pacoteAtualizado.getDestinatario());
            pacote.setEndereco(pacoteAtualizado.getEndereco());
            pacote.setStatus(pacoteAtualizado.getStatus());
            return pacoteRepository.save(pacote);
        }
        return null; 
    }

    public Pacote atualizarStatus(String pacoteId, String novoStatus, Date dataHora, String localizacao) {
        Optional<Pacote> optionalPacote = pacoteRepository.findById(pacoteId);
        if (optionalPacote.isPresent()) {
            Pacote pacote = optionalPacote.get();
            pacote.atualizarStatus(novoStatus, dataHora, localizacao);
            return pacoteRepository.save(pacote);
        }
        return null; 
    }

    
    public Pacote consultarPacote(String pacoteId) {
        return pacoteRepository.findById(pacoteId).orElse(null);
    }

    
    public List<Pacote> listarPacotes() {
        return pacoteRepository.findAll();
    }

    
    public boolean removerPacote(String pacoteId) {
        if (pacoteRepository.existsById(pacoteId)) {
            pacoteRepository.deleteById(pacoteId);
            return true;
        }
        return false;
    }
}
