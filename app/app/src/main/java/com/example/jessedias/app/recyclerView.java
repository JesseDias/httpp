package com.example.jessedias.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class recyclerView extends AppCompatActivity {

    private List listaEvento;

    private RecyclerView recyclerView;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        new donwloadDados().execute();


        recyclerView = (RecyclerView) findViewById(R.id.minhaRecyler);




        listaEvento=new ArrayList<>();

        adapter adpter = new adapter(listaEvento,this);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adpter);


        listaEvento.add(new donwloadDados().lista);
        Log.d("lista",listaEvento.toString());
    }

}
