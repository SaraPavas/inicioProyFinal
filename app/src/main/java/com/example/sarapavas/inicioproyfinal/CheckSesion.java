package com.example.sarapavas.inicioproyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckSesion extends AppCompatActivity {
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        session = new UserSessionManager(getApplicationContext());
        super.onCreate(savedInstanceState);

        if (session.isUserLoggedIn()) {
            Intent i = new Intent().setClass(CheckSesion.this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent().setClass(CheckSesion.this, InicioSesion.class);
            startActivity(i);
            finish();

        }
    }
}
