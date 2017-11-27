package com.example.jessedias.http;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jessedias on 06/11/2017.
 */

public class meusDados {


    private  String dados;
    private  String dados2;

    public meusDados(String descricao,String nome) {
       this.dados=nome;
        this.dados2=descricao;
        Log.d("dadosDescricao",dados2);
        Log.d("dadosNome",dados);
        }


    public String getDados(){

        return dados;
    }
}
