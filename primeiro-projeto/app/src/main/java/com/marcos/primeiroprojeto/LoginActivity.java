package com.marcos.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUsuario;
    EditText edSenha;
    Button btnEntrar;
    Button btnCancelar;
    //Guardar dados de usuarios
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Referência aos componentes  do layout*/

        edUsuario = findViewById(R.id.edUsuario);
        edSenha = findViewById(R.id.edSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCancelar = findViewById(R.id.btnCancelar);

        //Imprimir mensagem quando acionar botão
        //Toast.makeText(getActivity(), edUsuario.getText().toString(), Toast.LENGTH_SHORT).show();

        String usuario, senha;
        //Verificar se arquivo com dados login existe
        preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        usuario = preferences.getString("user", null);
        senha = preferences.getString("pass", null);

        if(usuario != null && senha != null){
            //Carregar activity
            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.putExtra("user", usuario);
            startActivity(intent);
            finish();
        }

        //Trabalhar com ações dos botões
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String usuario = edUsuario.getText().toString();
               String  senha = edSenha.getText().toString();
                if( usuario.equals("aluno") && senha.equals("aluno")){

                    //Criar o arquivo para armazenar os dados do usuario e aponta o contexto do seu uso
                    //entrar no modo de edição do arquivo
                    //preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("user", usuario);
                    editor.putString("pass", senha);
                    editor.commit();

                    //Carregar activity
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("user", edUsuario.getText().toString());
                    startActivity(intent);
                    finish();
                }
                if(usuario.equals("aluno")){ edSenha.requestFocus();}
                if(senha.equals("aluno")){edUsuario.requestFocus();}
                else{
                    //Setar focus
                    edUsuario.requestFocus();
                }
            }
        });
        //Imprimir mensagem
        //Toast.makeText(this, edUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    //Retornar propria activity
    public Context getActivity() {
        return this;
    }
}
