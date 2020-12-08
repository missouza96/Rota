package com.example.rota.activity.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rota.R;
import com.example.rota.activity.model.Viagem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CadastroViagem extends AppCompatActivity {

    private EditText origem, destino, data, veiculo;
    private Button btnCadastrarViagem, btnCancelar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_viagem);

        origem = (EditText) findViewById(R.id.ACTextViewOrigem);
        destino = (EditText) findViewById(R.id.ACTextViewDestino);
        data = (EditText) findViewById(R.id.ACTextViewDate);
        veiculo = (EditText) findViewById(R.id.ACTextViewVeiculo);
        btnCadastrarViagem = (Button) findViewById(R.id.buttonCadastrar);
        btnCancelar = (Button) findViewById(R.id.button);

        btnCadastrarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String o = origem.getText().toString();
                String d = destino.getText().toString();
                String v = veiculo.getText().toString();
                String dt = data.getText().toString();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Viagem viagem = new Viagem(o, d, v, dt);
                db.collection("viagens").add(viagem);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
