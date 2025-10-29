package com.example.miprimeraapp;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// Alvaro Ernesto Garcia Segovia SOF-NO-8-6

public class SecondActivity extends AppCompatActivity {

    /* Creacion de actividad y llama al metodo padre super.onCreate(savedInstanceState) para su correcta
    Inicializacion */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); /* Permite mostrar todo el contenido en pantalla */
        setContentView(R.layout.activity_second); // Carga la segunda actividad
    }
}