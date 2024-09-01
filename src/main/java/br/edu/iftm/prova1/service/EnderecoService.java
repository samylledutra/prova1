package br.edu.iftm.prova1.service;



import org.springframework.stereotype.Service;

import br.edu.iftm.prova1.model.Endereco;
import br.edu.iftm.prova1.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
    
    public Endereco adicionarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }
}
