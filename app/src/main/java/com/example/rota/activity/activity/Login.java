package com.example.rota.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rota.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

        private EditText editEmail, editSenha;
        private Button btnLogar, btnCriarCadastro;

        private FirebaseAuth auth;
        private FirebaseUser user;

        public void OnCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login);

            inicializaComponentes();
            eventoClicks();
        }

    private void eventoClicks() {
            btnCriarCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), CadastroUsuario.class);
                    startActivity(i);
                }
            });

    }

    private void inicializaComponentes() {
            editEmail = (EditText) findViewById(R.id.ACTextViewEmail);
            editSenha = (EditText) findViewById(R.id.ACTextViewSenha);
            btnLogar = (Button) findViewById(R.id.buttonLogin);
            btnCriarCadastro = (Button) findViewById(R.id.buttonCriarCadastro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        //verificaUser();
    }

    /*private void verificaUser() {
            if(user == null){
                finish();
            }else{
                editEmail.setText("Email: " + user.getEmail());
                editSenha.setText("Senha: "+ user.getUid());
            }
    }*/
}
