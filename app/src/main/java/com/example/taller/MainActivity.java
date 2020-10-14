package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editNombre, editApellido, editCorreo, editContraseña;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre=(EditText) findViewById(R.id.Nombre);
        editApellido=(EditText) findViewById(R.id.Apellido);
        editCorreo=(EditText) findViewById(R.id.Correo);
        editContraseña=(EditText) findViewById(R.id.Contraseña);
        btnRegistrar=(Button) findViewById(R.id.btn_enviar);
        final BaseDatos BaseDatos = new BaseDatos(getApplicationContext());


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseDatos.AgregarEstudiante(editNombre.getText().toString(),editApellido.getText().toString(),editCorreo.getText().toString(),editContraseña.getText().toString());
                Toast.makeText(getApplicationContext(),"Se agregaron los datos correctamente", Toast.LENGTH_LONG).show();
            }
        });
    }
}