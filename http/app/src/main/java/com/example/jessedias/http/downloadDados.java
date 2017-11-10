package com.example.jessedias.http;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessedias on 06/11/2017.
 */

public class downloadDados extends AsyncTask<Void,Void,String>{
   public String nome;

    public void vaiDarCerto(){
        
    }
    @Override
    protected String doInBackground(Void... params) {


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));
            Log.d("reader",reader.toString());
            String linha;
            StringBuffer buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }

            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String dados) {
        try {
            JSONObject jason = new JSONObject(dados);
            JSONArray jasonArray = jason.getJSONArray("weather");
            JSONObject jasonOjet = jasonArray.getJSONObject(0);
            int id = jasonOjet.getInt("id");
            String decricao = jasonOjet.getString("description");
            String id2 = Integer.toString(id);
            Log.d("dadosId",id2);

            return;

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

        }





