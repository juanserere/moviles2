package com.example.listarconapirest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdministracionCrud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracion_crud);
    }

    public void Alumnos(View view) {
        Intent intent = new Intent(this, Alumnos.class);
        startActivity(intent);
        finish();
    }
    public void Ciclo(View view) {
        Intent intent = new Intent(this, Ciclo.class);
        startActivity(intent);
        finish();
    }
    public void Registro(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
        finish();
    }
    public void Cursos(View view) {
        Intent intent = new Intent(this, Cursos.class);
        startActivity(intent);
        finish();
    }
}