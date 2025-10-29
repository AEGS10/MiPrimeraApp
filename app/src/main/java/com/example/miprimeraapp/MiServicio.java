package com.example.miprimeraapp;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

// Alvaro Ernesto Garcia Segovia SOF-NO-8-6

public class MiServicio extends Service {
    private Handler handler = new Handler();
    private Runnable runnable;
    /*En este codigo escribe un mensaje en el logcat para depuracion
     Y adicionalmente muestra otro mensaje cada 5 segundos para indicar su ejecucion postDelayed()*/
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MiServicio", "Servicio creado");

        runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("MiServicio", "Ejecutando tarea en segundo plano...");
                handler.postDelayed(this, 5000); // cada 5 segundos
            }
        };
        handler.post(runnable); // Incia la tarea la primera vez
    }

    /*Se ejecuta cada vez que se llama al id btnServicio y con START_STICKY se mata el servicio
     e intentara reiniciarlo */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MiServicio", "btnServicio"); // Sirve para indicar que el boton se clickeo
        return START_STICKY; // Reinicio
    }

    // Se usa para detener el servicio y handler.removeCallbacks(runnable) detiene las tareas repetitivas
    @Override
    public void onDestroy() {
        Log.d("MiServicio", "btnDetener");
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    // Los servicios pueden ser vinculados o no vinculados
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
