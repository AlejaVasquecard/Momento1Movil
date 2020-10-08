package com.aleja.momento1movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.aleja.momento1movil.models.NotaModel;
import com.aleja.momento1movil.operantions.operations;
import java.util.ArrayList;

public class ListarNotas extends AppCompatActivity {

    private ListView lv_notas_descripcion;
    private operations operations;
    private ArrayList<NotaModel> list;
    private ArrayList<String> listString;
    private ArrayAdapter<String> itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_notas);

        lv_notas_descripcion = findViewById(R.id.lv_notas_descripcion);
        operations= new operations(getApplicationContext());

        listString = operations.list();

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listString);
        lv_notas_descripcion.setAdapter(itemsAdapter);


    }
}