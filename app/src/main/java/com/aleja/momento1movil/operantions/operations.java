package com.aleja.momento1movil.operantions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aleja.momento1movil.Database.DbHelper;
import com.aleja.momento1movil.models.NotaModel;

import java.util.ArrayList;

public class operations {

    private String DBNAME = "miappnotas.db";
    private int VERSION = 1;
    public final Context context;
    private SQLiteDatabase database;
    private DbHelper helper;
    private NotaModel model;

    private ArrayList<String> list;

    public operations(Context context) {
        this.context = context;
        helper = new DbHelper(context, DBNAME, null, VERSION);
    }

    protected void openRead(){
        database = helper.getReadableDatabase();
    }
    protected void openWrite(){
        database = helper.getWritableDatabase();
    }

    protected void close(){
        database.close();
    }

    public int insert(NotaModel model){
        ContentValues content = new ContentValues();
        content.put("titulo", model.getTitulo());
        content.put("descripcion",model.getDescripcion());

        openWrite();
        long id = database.insert("notas", null, content);
        close();

        return (int)id;
    }

    public ArrayList<String> list(){
        list = new ArrayList<>();

        openRead();

        Cursor cursor = database.query("notas", null, null, null, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String titulo, descripcion, consolidado;
            int id;
            do{
                id =  cursor.getInt(cursor.getColumnIndex("id"));
                titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));

                consolidado =String.valueOf(id) + " - " + titulo + '\n' + descripcion;
                list.add(consolidado);
            }while(cursor.moveToNext());
        }
        close();
        return list;
    }

}
