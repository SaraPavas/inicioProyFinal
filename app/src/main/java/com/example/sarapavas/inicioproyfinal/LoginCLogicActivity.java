package com.example.sarapavas.inicioproyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map;



public class LoginCLogicActivity extends AppCompatActivity {

    EditText nombre,email,pass;
    Button cancelar,registro;
    private static final long SPLASH_SCREEN_DELAY = 5000;
    Integer count=0;

    private static final String FIREBASE_URL="https://circuitlogic.firebaseio.com/";
    private Firebase firebasedatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_clogic);

        Firebase.setAndroidContext(this);
        firebasedatos= new Firebase(FIREBASE_URL);

        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);

        cancelar=(Button)findViewById(R.id.cancelar);
        registro=(Button)findViewById(R.id.registro);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginCLogicActivity.this, "Usuario Registrado ", Toast.LENGTH_SHORT).show();
                String sNombre = nombre.getText().toString();
                String sEmail = email.getText().toString();
                String sPass = pass.getText().toString();

                Firebase ref = new Firebase(FIREBASE_URL);
                ref.createUser(sEmail, sPass, new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        System.out.println("Successfully created user account with uid: " + result.get("uid"));
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                    }
                });
            }
        });

    }
}
