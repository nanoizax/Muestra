package com.devs.muestra.Util;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class Funciones {

    public void mensaje(Activity activity, String texto){

        Toast.makeText(activity,
                texto, Toast.LENGTH_LONG).show();

    }

    public void go(Activity activity, Class activity_go){

        Intent intent = new Intent(activity,activity_go);
        activity.startActivity(intent);

    }

}
