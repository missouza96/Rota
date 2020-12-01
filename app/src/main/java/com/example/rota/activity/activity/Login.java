package com.example.rota.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rota.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

        private EditText editEmail, editSenha;
        private Button btnLogar, btnCriarCadastro;

        private FirebaseAuth auth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
            btnLogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = editEmail.getText().toString().trim();
                    String senha = editSenha.getText().toString().trim();
                    login(email, senha);
                }
            });

    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(Login.this, MainActivity.class);
                            startActivity(i);
                        }else{
                            alert("Email ou senha inválidos!");

                        }
                    }
                });
    }

    private void alert(String s) {
        Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
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
    }
}
