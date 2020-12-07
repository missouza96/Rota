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

public class AdapterFeed extends RecyclerView.Adapter<AdapterFeed.MyViewHolder> {

    private List<Viagem> listaViagens;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_feed, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.set(listaViagens.get(position));
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public void update(List<Viagem> toObjects){
        this.listaViagens = toObjects;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView origem, destino, veiculo, data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            origem = itemView.findViewById(R.id.textOrigem);
            destino = itemView.findViewById(R.id.textDestino);
            veiculo = itemView.findViewById(R.id.textVeiculo);
            data = itemView.findViewById(R.id.textData);
        }

        public void set(Viagem viagem) {
            origem.setText(viagem.getOrigem());
            destino.setText(viagem.getDestino());
            veiculo.setText(viagem.getVeiculo());
            data.setText(viagem.getData());

        }
    }
}

