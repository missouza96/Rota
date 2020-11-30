package com.example.rota.activity.repository;

import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.rota.activity.model.Viagem;
import java.util.ArrayList;

public class ViagemRepositorio {
    private EditText origem, destino, data, veiculo;

    public ArrayList<Viagem> criaViagens(){
        ArrayList<Viagem> viagens = new ArrayList();

        Viagem viagem = new Viagem();
        viagens.add(viagem);

        return viagens;

    }
}
