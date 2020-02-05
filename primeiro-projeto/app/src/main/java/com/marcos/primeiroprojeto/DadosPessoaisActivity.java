package com.marcos.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;


import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.marcos.primeiroprojeto.com.example.entity.Cliente;
import com.marcos.primeiroprojeto.com.example.entity.Constante;
import com.marcos.primeiroprojeto.com.example.entity.Pessoa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DadosPessoaisActivity extends AppCompatActivity{

    List<String> pessoas = new ArrayList();

    ListView dadosPessoas;

    //ListView lsvDadosPessoais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);

        //Ativar opção(seta) para retornar a activity anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dados Pessoais");


        /*lsvDadosPessoais = findViewById(R.id.lsvDados);
        List<String> clientes = new ArrayList();
        Cliente c1 = new Cliente("Thányla", "Sales");
        Cliente c2 = new Cliente("Tháttyla", "Sales");
        Cliente c3 = new Cliente("Thávyla", "Sales");
        clientes.add(c1.getNome());
        clientes.add(c2.getNome());
        clientes.add(c3.getNome());


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, clientes);
        lsvDadosPessoais.setAdapter(adapter);*/

        new AsyncHttpClient().get(Constante.URL_BASE+"/pessoa/lista",
                new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);

                        if(response != null){
                            for (int i = 0; i < response.length(); i++){
                                Pessoa p1;
                                try {

                                    JSONObject objJson = response.getJSONObject(i);

                                    p1 = new Gson().fromJson(objJson.toString(), Pessoa.class);
                                    pessoas.add(p1.getNome());



                                }catch(JSONException e){

                                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();

                                }
                            }

                            dadosPessoas = findViewById(R.id.lsvDados);
                            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, pessoas);
                            dadosPessoas.setAdapter(adapter);

                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);

                        Toast.makeText(getActivity(),"erro de Conexão", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public Context getActivity(){
        return this;
    }

    /*Ação para setDisplayHomeAsUpEnabled
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
