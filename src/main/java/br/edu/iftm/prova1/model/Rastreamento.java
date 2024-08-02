package br.edu.iftm.prova1.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    private String status;
    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "pacote_id", nullable = false)
    private Pacote pacote;

    

    public Rastreamento() {
    }

    public Rastreamento(Date dataHora, String status, String localizacao, Pacote pacote) {
        this.dataHora = dataHora;
        this.status = status;
        this.localizacao = localizacao;
        this.pacote = pacote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getResumo() {
        return "Data e Hora: " + dataHora + ", Status: " + status + ", Localização: " + (localizacao != null ? localizacao : "N/A");
    }
}
