package com.example.jessedias.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String meusDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   downloadDados downloadDados =(downloadDados) new downloadDados().execute();


        Log.d("dados",meusDados);



    }
}
