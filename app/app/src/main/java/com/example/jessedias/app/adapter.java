package com.example.jessedias.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jessedias on 13/11/2017.
 */

public class adapter extends RecyclerView.Adapter{


    private List<eventos> listaEnvento;
    private Context context;

    public adapter(List<eventos> listaEvento, Context context) {
        this.listaEnvento=listaEvento;

        this.context=context;

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ViewHolder holder = (ViewHolder) viewHolder;
        eventos listaEventoss = listaEnvento.get(position);

        Log.d("NomeD2",listaEnvento.toString());
        holder.txtNome.setText(listaEventoss.getNome());
        holder.txtDescricao.setText(listaEventoss.getDescricao());



    }


    @Override
    public int getItemCount() {
        return listaEnvento.size();
    }
}
