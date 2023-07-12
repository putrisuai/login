package com.putrisuai201103646.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

public class ImplicitMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_main);
    }

    public void tampilTelepon(View view) {
        Intent teleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(teleponIntent);
    }

    public void tampilSms(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_MAIN);
        smsIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsIntent);
    }

    public void tampilKalender(View view) {
        Intent kalenderIntent = new Intent(Intent.ACTION_MAIN);
        kalenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(kalenderIntent);
    }

    public void tampilBrowser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_MAIN);
        browserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(browserIntent);
    }

    public void tampilKalkuator(View view) {
        try {
            Intent kalkuatorIntent = new Intent(Intent.ACTION_MAIN);
            kalkuatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName("com.android.calcuator2", "com.android.calcuator2.Calcuator");
            kalkuatorIntent.setComponent(cn);

            startActivity(kalkuatorIntent);
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(getApplicationContext(), "Aplikasi tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    public void tampilGaleri(View view) {
        Intent galeriIntent = new Intent(Intent.ACTION_MAIN);
        galeriIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(galeriIntent);
    }

    public void tampilWiFi(View view) {
        Intent wifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
    }
}