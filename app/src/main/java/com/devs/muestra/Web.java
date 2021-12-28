package com.devs.muestra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;

import com.devs.muestra.Util.Globales;
import com.devs.muestra.Util.Objetos;

import muestra.R;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        OBJETOS();

        TOOLBAR();

        WEB();

    }

    Objetos o = new Objetos();
    Globales g = new Globales();

    private void OBJETOS(){

        o.web = findViewById(R.id.web);

    }

    private void BOTONES(){

    }

    private void TOOLBAR(){
        getSupportActionBar().setTitle("Web");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void WEB(){
        final WebSettings ajustesVisorWeb = o.web.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        o.web.loadUrl(g.url);
    }
}