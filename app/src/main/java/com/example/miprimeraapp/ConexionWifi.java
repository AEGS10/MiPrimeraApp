package com.example.miprimeraapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

// Alvaro Ernesto Garcia Segovia SOF-NO-8-6

public class ConexionWifi extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {


        /*
        ConnectivityManager Gestiona el estado de red y devuelve la informacion por
        medio de getActiveNetworkInfo()
         */

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            Toast.makeText(context, "Conectado a Internet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
