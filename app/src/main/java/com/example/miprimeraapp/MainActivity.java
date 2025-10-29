package com.example.miprimeraapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Alvaro Ernesto Garcia Segovia SOF-NO-8-6

public class MainActivity extends AppCompatActivity {

    // Receptor como variable global para usar en OnResume() y OnPause()
    private ConexionWifi conexionWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón Saludar : Busca el boton por su Id y muestra un mensaje toast al clickear
        Button btnSaludar = findViewById(R.id.btnSaludar);
        btnSaludar.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "¡Hola Android!", Toast.LENGTH_SHORT).show()
        );

        // Botón Segunda Actividad : Se crea un intent para luego mostrarlo con startActivity
        Button btnSegunda = findViewById(R.id.btnSegunda);
        btnSegunda.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Botones iniciar/detener servicio: Se crea un servicio en segundo plano y se detiene el servicio

        Button btnIniciar = findViewById(R.id.btnIniciar);
        Button btnDetener = findViewById(R.id.btnDetener);
        btnIniciar.setOnClickListener(v ->
                startService(new Intent(this, MiServicio.class))
        );
        btnDetener.setOnClickListener(v ->
                stopService(new Intent(this, MiServicio.class))
        );

        // Inicializa el receptor
        conexionWifi = new ConexionWifi();
    }

    /* onResume() : aqui se registra el recpetor para escuchar los cambios de conexion y los muestra
    por ConnectivityManager.CONNECTIVITY_ACTION */

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(conexionWifi, filter);
    }

    /*onPause(): Cuando la actividad no esta visible se desregistra el receptor lo que ayuda
     a evitar los famosos memory leaks y errores por recibir eventos en segundo plano*/
    @Override
    protected void onPause() {
        super.onPause();
        // Desregistra el receptor para evitar memory leaks
        unregisterReceiver(conexionWifi);
    }
}
