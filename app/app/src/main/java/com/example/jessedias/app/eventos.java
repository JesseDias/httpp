package com.example.jessedias.app;

import android.util.Log;

/**
 * Created by jessedias on 13/11/2017.
 */

public class eventos {

    private final String nome;
    private final String descricao;

    public eventos(String nome, String descricao) {

        this.nome = nome;
        this.descricao=descricao;

        Log.d("NomeDes", nome);
        Log.d("NomeDes",descricao);
    }


    public String getNome() {
        return nome;



    }
    public String getDescricao(){

        return descricao;
    }


}



