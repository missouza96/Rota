package com.example.rota.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rota.R;
import com.example.rota.activity.model.Viagem;

import java.util.List;

public class  AdapterFeed extends RecyclerView.Adapter<AdapterFeed.MyViewHolder> {

    private List<Viagem> listaViagens;

    public AdapterFeed(List<Viagem> viagem) {
        this.listaViagens = viagem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_feed, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Viagem viagem = listaViagens.get(i);

        myViewHolder.origem.setText(viagem.getOrigem());
        myViewHolder.destino.setText(viagem.getDestino());
        myViewHolder.veiculo.setText(viagem.getVeiculo());
        myViewHolder.data.setText(viagem.getData());
    }


    @Override
    public int getItemCount() {
        return listaViagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView origem;
        TextView destino;
        TextView veiculo;
        TextView data;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            origem = itemView.findViewById(R.id.textOrigem);
            destino = itemView.findViewById(R.id.textDestino);
            veiculo = itemView.findViewById(R.id.textVeiculo);
            data = itemView.findViewById(R.id.textData);
        }
    }
}
