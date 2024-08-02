package br.edu.iftm.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.model.Pacote;
import br.edu.iftm.service.PacoteService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    
    @PostMapping
    public ResponseEntity<Pacote> cadastrarPacote(@RequestBody Pacote pacote) {
        Pacote novoPacote = pacoteService.cadastrarPacote(pacote);
        return ResponseEntity.ok(novoPacote);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Pacote> atualizarPacote(@PathVariable String id, @RequestBody Pacote pacoteAtualizado) {
        Pacote pacote = pacoteService.atualizarPacote(id, pacoteAtualizado);
        if (pacote != null) {
            return ResponseEntity.ok(pacote);
        }
        return ResponseEntity.notFound().build();
    }

   
    @PutMapping("/{id}/status")
    public ResponseEntity<Pacote> atualizarStatus(@PathVariable String id,
                                                  @RequestParam String status,
                                                  @RequestParam String localizacao) {
        Pacote pacoteAtualizado = pacoteService.atualizarStatus(id, status, new Date(), localizacao);
        if (pacoteAtualizado != null) {
            return ResponseEntity.ok(pacoteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Pacote> consultarPacote(@PathVariable String id) {
        Pacote pacote = pacoteService.consultarPacote(id);
        if (pacote != null) {
            return ResponseEntity.ok(pacote);
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping
    public ResponseEntity<List<Pacote>> listarPacotes() {
        List<Pacote> pacotes = pacoteService.listarPacotes();
        return ResponseEntity.ok(pacotes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPacote(@PathVariable String id) {
        if (pacoteService.removerPacote(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
