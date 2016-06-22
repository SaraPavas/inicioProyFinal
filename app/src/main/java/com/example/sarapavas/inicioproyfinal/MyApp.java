package com.example.sarapavas.inicioproyfinal;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.security.Signature;

/**
 * Created by Sara Pavas on 11/06/2016.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        printHashKey();
    }
    public void printHashKey(){
        try{
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.sarapavas.inicioproyfinal", PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures){
                MessageDigest nd = MessageDigest.getInstance("SHA");
                nd.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(nd.digest(), Base64.DEFAULT));
            }
        }catch (PackageManager.NameNotFoundException e){}
        catch (NoSuchAlgorithmException e){}
    }
}
