package com.marcos.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import cz.msebera.android.httpclient.Header;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.marcos.primeiroprojeto.com.example.entity.Constante;
import com.marcos.primeiroprojeto.com.example.entity.Produto;
import com.marcos.primeiroprojeto.listaDinamica.AdapterListaPedidos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProdutoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Produto> produtos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        //Ativar opção(seta) para retornar a activity anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Produtos");

        new AsyncHttpClient().get(Constante.URL_BASE + "/produto/lista",
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);

                        if (response != null) {
                            for (int i = 0; i < response.length(); i++) {
                                Produto p1;
                                try {

                                    JSONObject objJason = response.getJSONObject(i);
                                    p1 = new Gson().fromJson(objJason.toString(), Produto.class);
                                    produtos.add(p1);

                                } catch (JSONException e) {
                                    Toast.makeText(getActivity(), "Erro de Conexão", Toast.LENGTH_SHORT).show();
                                }
                            }
                            //lsvProdutos = findViewById(R.id.lsvProdutos);
                            AdapterListaPedidos adapter = new AdapterListaPedidos(produtos);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(getActivity(),"erro de Conexão", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /*Ação para setDisplayHomeAsUpEnabled
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Context getActivity(){
        return this;
    }
}
