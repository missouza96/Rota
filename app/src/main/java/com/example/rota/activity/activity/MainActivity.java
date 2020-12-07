package com.example.rota.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.rota.R;
import com.example.rota.activity.adapter.AdapterFeed;
import com.example.rota.activity.model.Viagem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private RecyclerView recyclerView;
    private List<Viagem> listaViagens = new ArrayList<>();
    public FloatingActionButton fab;
    public static final String VIAGENS = "viagens";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        componentesTela();
        eventosClick();

        //configura adapter
        AdapterFeed adapterFeed = new AdapterFeed();
        recyclerView.setAdapter(adapterFeed);

        // configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFeed);
    }
    private void eventosClick() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastroViagem.class);
                startActivity(i);
            }
        });
    }

    public void componentesTela() {
            recyclerView = findViewById(R.id.recyclerView);
            fab = findViewById(R.id.floatingActionButton);
        }

}
