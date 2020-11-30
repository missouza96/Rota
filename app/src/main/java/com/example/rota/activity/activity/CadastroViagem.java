package com.example.rota.activity.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rota.R;
import com.example.rota.activity.repository.ViagemRepositorio;

public class CadastroViagem extends AppCompatActivity {

    private EditText origem, destino, data, veiculo;
    private Button btnCadastrarViagem, btnCancelar;

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.cadastro_viagem);

        inicializaComponentes();
        eventoClicks();
    }

    private void eventoClicks() {
        btnCadastrarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inicializaComponentes() {
        origem = (EditText) findViewById(R.id.ACTextViewOrigem);
        destino = (EditText) findViewById(R.id.ACTextViewDestino);
        data = (EditText) findViewById(R.id.ACTextViewDate);
        veiculo = (EditText) findViewById(R.id.ACTextViewVeiculo);
        btnCadastrarViagem = (Button) findViewById(R.id.buttonCadastrar);
        btnCancelar = (Button) findViewById(R.id.button);

    }


}
