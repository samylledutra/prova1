package br.edu.iftm.prova1.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Pacote {

    @Id
    private String id;
    private String destinatario;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Status status; 

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public Pacote() {
    }

    public Pacote(String id, String destinatario, Endereco endereco, Status status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Rastreamento> getRastreamentos() {
        return rastreamentos;
    }

    public void setRastreamentos(List<Rastreamento> rastreamentos) {
        this.rastreamentos = rastreamentos;
    }

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = Status.valueOf(novoStatus);
        Rastreamento rastreamento = new Rastreamento(dataHora, novoStatus, localizacao, this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder informacoes = new StringBuilder();
        informacoes.append("Pacote ID: ").append(id).append("\n")
                .append("Destinatário: ").append(destinatario).append("\n")
                .append("Endereço: ").append(endereco.getEnderecoCompleto()).append("\n")
                .append("Status: ").append(status).append("\n")
                .append("Rastreamentos: \n");

        for (Rastreamento r : rastreamentos) {
            informacoes.append(r.getResumo()).append("\n");
        }

        return informacoes.toString();
    }

    enum Status {
        PENDENTE, EM_TRANSPORTE, ENTREGUE
    }
}
