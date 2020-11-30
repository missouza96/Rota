package com.example.rota.activity.model;

public class Viagem {
    private String origem;
    private String destino;
    private String veiculo;
    private String data;

    public Viagem(String origem, String destino, String veiculo, String data) {
        this.origem = origem;
        this.destino = destino;
        this.veiculo = veiculo;
        this.data = data;
    }

    public Viagem() {};

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() { return data; }

    public void setData(String data) {
        this.data = data;
    }
}

