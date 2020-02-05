package com.marcos.primeiroprojeto.listaDinamica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marcos.primeiroprojeto.R;
import com.marcos.primeiroprojeto.com.example.entity.Produto;

import java.util.List;

public class AdapterListaPedidos extends RecyclerView.Adapter<AdapterListaPedidos.MyViewHolder> {

    public List<Produto> produtoList;

    public AdapterListaPedidos(List<Produto> produtos) {
        this.produtoList = produtos;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtDescricao;
        TextView txtValor;
        Button btnAdicionar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            txtValor = itemView.findViewById(R.id.txtValor);
            btnAdicionar = itemView.findViewById(R.id.btnAdicionar);
        }
    }

    @NonNull
    @Override
    public AdapterListaPedidos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_pedidos,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
