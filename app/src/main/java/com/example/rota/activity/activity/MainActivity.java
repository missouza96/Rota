package com.example.rota.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.example.rota.R;
import com.example.rota.activity.adapter.AdapterFeed;
import com.example.rota.activity.model.Viagem;
import com.example.rota.activity.repository.ViagemRepositorio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    private RecyclerView recyclerView;
    private List<Viagem> listaViagens = new ArrayList<>();
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*cadastro de usuário
        usuario.createUserWithEmailAndPassword("");
        firebase - salvando dados
        DatabaseReference viagens = referencia.child("viagens");

        //firebase - recuperando dados
        viagens.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        Viagem viagem = new Viagem();
        viagem.setOrigem("Itaperuna");
        viagem.setDestino("Guarapari");
        viagem.setVeiculo("meriva");
        viagem.setData("12/12/2020");
        listaViagens.add(viagem);

        viagens.child("001").setValue(viagem);*/


        //buscar id
        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingActionButton);

        //configurar floatingActionbutton para levar a outra activity
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroViagem.class);
                startActivity(intent);
            }
        });

        listaViagens = new ViagemRepositorio().criaViagens();

        // configurar adapter
        AdapterFeed adapterFeed = new AdapterFeed(listaViagens);

        // configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFeed);
    }
}
