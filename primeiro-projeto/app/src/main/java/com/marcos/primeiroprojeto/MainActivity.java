package com.marcos.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nomeUser;
    Button btnDadosPessoais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Acessar dados enviados via Activity Login
        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("user");

        //Outra forma de obter dados enviados via Activity Login
       // Intent intent = getIntent();
       // String user = intent.getStringExtra("user");

        //Referenciar e exibir dados na Activity Main
        //nomeUser =  findViewById(R.id.nomeUsuario);
        //nomeUser.setText(user);

        //Referência ao botão dash Dados Pessoais
        btnDadosPessoais = findViewById(R.id.btnDadosPessoais);
        btnDadosPessoais.setOnClickListener(actDadosPessoais());
    }

    private View.OnClickListener actDadosPessoais() {
        return new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DadosPessoaisActivity.class);
                startActivity(intent);
            }
        };
    }

    /*Método referente ao botão dash Meus Pedidos
    * @param view
    */
    public void actPedidos(View view) {
        /*Chamada de activity resumida*/
        startActivity(new Intent(getActivity(), ProdutoActivity.class));
    }

    public void actProdutos(View view){
        startActivity(new Intent(getActivity(), ProdutoActivity.class));
    }
    public Context getActivity() {
        return this;
    }
}
