package com.example.taller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="bdproyecto.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ESTUDIANTE="create table estudiantes(Nombre text, apellido text,correo text, contraseña text)";

    public BaseDatos(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_ESTUDIANTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF exist"+TABLA_ESTUDIANTE);
        db.execSQL(TABLA_ESTUDIANTE);
    }
    public void AgregarEstudiante(String Nombre, String apellido, String correo, String contraseña ){
        SQLiteDatabase bd=getReadableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO estudiantes VALUES ('"+Nombre+"','"+apellido+"','"+correo+"','"+contraseña+"')");
            bd.close();
        }
    }
}
