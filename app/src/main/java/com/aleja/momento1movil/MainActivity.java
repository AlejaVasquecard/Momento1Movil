package com.aleja.momento1movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aleja.momento1movil.models.NotaModel;
import com.aleja.momento1movil.operantions.operations;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private NotaModel model;
    private operations operations;
    private EditText edtx_titulo, edtx_nota;
    private Button btn_guardar, btn_ver_notas;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtx_titulo= findViewById(R.id.edtx_titulo);
        edtx_nota = findViewById(R.id.edtx_nota);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_ver_notas = findViewById(R.id.btn_ver_notas);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {

                String titulo = edtx_titulo.getText().toString();
                String descripcion = edtx_nota.getText().toString();

                operations = new operations(MainActivity.this);

                model = new NotaModel(titulo, descripcion);
                //operations.insert(model);
                int r = operations.insert(model);
                if(r>0){
                    edtx_titulo.setText("");
                    edtx_nota.setText("");
                    Toast.makeText(MainActivity.this, "Guardado Exitosamente", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "No se Guardo la información", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_ver_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_notas = new Intent(MainActivity.this, ListarNotas.class);
                startActivity(intent_notas);
            }
        });
    }




}

