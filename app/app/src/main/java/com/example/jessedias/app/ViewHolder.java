package com.example.jessedias.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jessedias on 13/11/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    final TextView txtNome;
    final TextView txtDescricao;
    final ImageView fotoImagem;


    public ViewHolder (View itemview){
        super(itemview);

        txtNome =(TextView) itemview.findViewById(R.id.tristeza);
        txtDescricao=(TextView) itemview.findViewById(R.id.descricao);
        fotoImagem=(ImageView) itemview.findViewById(R.id.fotoShow);


    }
}