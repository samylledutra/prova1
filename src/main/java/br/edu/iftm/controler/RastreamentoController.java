package br.edu.iftm.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.model.Rastreamento;
import br.edu.iftm.service.RastreamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    
    @PostMapping
    public ResponseEntity<Rastreamento> adicionarRastreamento(@RequestBody Rastreamento rastreamento) {
        Rastreamento novoRastreamento = rastreamentoService.adicionarRastreamento(rastreamento);
        return ResponseEntity.ok(novoRastreamento);
    }

    
    @GetMapping("/{pacoteId}")
    public ResponseEntity<List<Rastreamento>> consultarRastreamentosPorPacote(@PathVariable String pacoteId) {
        List<Rastreamento> rastreamentos = rastreamentoService.consultarRastreamentosPorPacoteId(pacoteId);
        return ResponseEntity.ok(rastreamentos);
    }
}
