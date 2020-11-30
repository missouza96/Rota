package com.example.rota.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.rota.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroUsuario extends AppCompatActivity {

    private EditText editNome, editCriarEmail, editCriarSenha;
    private Button btnCriarCadastro, btnIrLogin;
    private FirebaseAuth auth;


    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_usuario);
        cadastrarUsuario();
        eventoclicks();
    }

    private void eventoclicks() {
        btnCriarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editCriarEmail.getText().toString().trim();
                String senha = editCriarSenha.getText().toString().trim();
                criarUser(email,senha);
            }
        });
    }

    private void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email,senha)
                .addOnCompleteListener(CadastroUsuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            alert("Usuário cadastrado com sucesso!");
                            Intent i = new Intent(CadastroUsuario.this, Login.class);
                            startActivity(i);
                            finish();
                        }else{
                            alert("Não foi possível cadastrar!");
                        }
                    }
                });
    }

    private void alert(String msg){
        Toast.makeText(CadastroUsuario.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void cadastrarUsuario() {
        editNome = (EditText) findViewById(R.id.ACTextViewCriarNome);
        editCriarEmail = (EditText) findViewById(R.id.ACTextViewCriarEmail);
        editCriarSenha = (EditText) findViewById(R.id.ACTextViewCriarSenha);
        btnCriarCadastro = (Button) findViewById(R.id.buttonCadastrarUsuario);
        btnIrLogin = (Button) findViewById(R.id.buttonIrLogin);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = new Conexao().getFirebaseAuth();
    }
}
