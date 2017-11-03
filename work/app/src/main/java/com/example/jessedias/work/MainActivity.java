package com.example.jessedias.work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;
    private JSONObject o;
    private Intent j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText) findViewById(R.id.usuario);
        senha=(EditText) findViewById(R.id.senha);


    }


        public void login(){
        Ion.with(this).load("POST","http://192.168.32.126:8080/login").setBodyParameter("usuario",usuario.getText().toString())
                .setBodyParameter("senha",senha.getText().toString()).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
             if (e==null) {

                String token=o.optString("token");
                 Log.d("token",token);

                 j = new Intent(getApplication(),segudaTela.class);
                 startActivity(j);

             }


            }
        });

    }
}
