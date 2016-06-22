package com.example.sarapavas.inicioproyfinal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class loginfacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginfacebook);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        fragment = new LoginFacebokFragment();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();



    }



}
