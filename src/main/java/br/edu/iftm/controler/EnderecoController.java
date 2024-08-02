package br.edu.iftm.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.model.Endereco;
import br.edu.iftm.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    
    @PostMapping
    public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.adicionarEndereco(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    
    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.ok(enderecos);
    }
}
