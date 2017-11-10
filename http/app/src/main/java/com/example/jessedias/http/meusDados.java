package com.example.jessedias.http;

import android.util.Log;

/**
 * Created by jessedias on 06/11/2017.
 */

public class meusDados {

    private String nome;

    public meusDados(String nome){
        this.nome=nome;
        Log.d("nome",nome);
    }

    public String getNome(){

        return nome;
    }
}
