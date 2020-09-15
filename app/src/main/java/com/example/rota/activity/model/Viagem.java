package com.example.rota.activity.model;

public class Viagem {
    private String viagem;
    private String veiculo;
    private String data;

    public Viagem(String viagem, String veiculo, String data) {
        this.viagem = viagem;
        this.veiculo = veiculo;
        this.data = data;
    }

    public String getViagem() {
        return viagem;
    }

    public void setViagem(String viagem) {
        this.viagem = viagem;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

