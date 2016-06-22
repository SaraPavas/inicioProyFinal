package com.example.sarapavas.inicioproyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class InicioSesion extends AppCompatActivity {
    EditText email,pass;
    private static final String FIREBASE_URL="https://circuitlogic.firebaseio.com/";
    private Firebase firebasedatos;
    private UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
            email = (EditText)findViewById(R.id.emailU);
            pass =  (EditText)findViewById(R.id.passU);
        session = new UserSessionManager(getApplicationContext());
        Firebase.setAndroidContext(this);
        firebasedatos= new Firebase(FIREBASE_URL);


    }

    public void correo(View v){
        Intent i = new Intent().setClass(InicioSesion.this, loginfacebookActivity.class);
        startActivity(i);
        finish();
    }
    public void google(View v){
        Intent i = new Intent().setClass(InicioSesion.this, loginGoogleActivity.class);
        startActivity(i);
        finish();
    }
    public void logic(View v){
        Intent i = new Intent().setClass(InicioSesion.this, LoginCLogicActivity.class);
        startActivity(i);
        finish();
    }
    public void iniciarSesion(View v){
        final String sEmail = email.getText().toString();
        final String sPass = pass.getText().toString();

        Firebase ref = new Firebase(FIREBASE_URL);
        ref.authWithPassword(sEmail, sPass, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                session.createUserLoginSession(sEmail,sPass);
                Intent i = new Intent().setClass(InicioSesion.this, MainActivity.class);
                startActivity(i);
                finish();
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
            }
        });

    }
}
