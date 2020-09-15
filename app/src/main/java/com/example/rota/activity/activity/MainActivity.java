package com.example.rota.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.rota.R;
import com.example.rota.activity.adapter.AdapterFeed;
import com.example.rota.activity.model.Viagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Viagem> listaViagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // listagem de viagens
        this.criarViagens();


        // configurar adapter
        AdapterFeed adapterFeed = new AdapterFeed(listaViagens);


        // configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFeed);


    }

    public void criarViagens(){

        Viagem viagem = new Viagem("Itaperuna x Campos", "Meriva", "01/2020");
        listaViagens.add(viagem);

        viagem = new Viagem("Itaperuna x Guarapari", "Viação Real", "03/2020");
        listaViagens.add(viagem);

        viagem = new Viagem("Manhuaçu x BH", "Viação 1001", "05/2020");
        listaViagens.add(viagem);

        viagem = new Viagem("Itaperuna x SJC", "Viação Kaissara", "10/2020");
        listaViagens.add(viagem);

        viagem = new Viagem("BH x Brasilia", "Viação Cometa", "12/2020");
        listaViagens.add(viagem);


    }
}
