package com.example.jessedias.work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;
    private JSONObject o;
    private Intent j;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.usuario);
        senha = (EditText) findViewById(R.id.senha);


      token token = new token();
        String meutoken = token.gerarToken.toString();
        Log.d("meutoken",meutoken);
    }


      /*  public void login(View view){
        Ion.with(this).load("POST","http://dev.unasusamazonia.com.br").setBodyParameter("usuario",usuario.getText().toString())
                .setBodyParameter("senha",senha.getText().toString()).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                email = result;
                Log.d("token",email);
                password=senha.getText().toString();
                j = new Intent(getApplicationContext(),segudaTela.class);
                startActivity(j);



                String token=o.optString("token");
                 Log.d("token2",token);






            }
        });

    */
}


