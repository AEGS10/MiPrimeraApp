package com.example.miprimeraapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Alvaro Ernesto Garcia Segovia SOF-NO-8-6


/*

Se uso Fragment que es una actividad reutilizable donde usamos onCreateView para crear la interfaz
y usamos inflater.inflate para convertirlo en un objeto view y establecemos falso para hacerlo una
Activity

*/
public class InfoFragment extends Fragment {

    // Constructor necesario para recrear el fragmento
    public InfoFragment() {

    }

    // Carga el layout dentro de la actividad
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment, container, false);
    }
}
