package com.example.rota.activity.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rota.R;

public class CadastroGasto extends AppCompatActivity {
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);

        //layout referente
        setContentView(R.layout.cadastro_gasto);

        Button botao3 = (Button) findViewById(R.id.buttonCadastrarManutencao);
        //Button botao4 = (Button) findViewById(R.id.buttonCancelar2);

        //configura botao cadastrar
        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //mensagem confirmando cadastro
                Toast.makeText(getApplicationContext(), "Manutenção cadastrada!", Toast.LENGTH_LONG).show();
            }
        });

        //configura botão cancelar
        /*botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implementar
            }
        });*/


    }
}
