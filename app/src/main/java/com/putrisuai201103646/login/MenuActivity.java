package com.putrisuai201103646.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button _tampilMahasiswaButton, _tampilForexButton, _tampilCuacaButton, _tampilImplicitButton, _tampilTabLayoutButton, _tampilHotelButton, _tampilWebLanjutanButton;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent, _tampilCuacaIntent, _tampilImplicitIntent, _tampilTabLayoutIntent, _tampilHotelIntent, _tampilWebLanjutanIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initTampilMahasiswaButton();
        initTampilForexButton();
        initTampilCuacaButton();
        initTampilImplicitButton();
        initTampilTabLayoutButton();
        initTampilHotelButton();
        initTampilWebLanjutanButton();

        Bundle bundle = getIntent().getExtras();
        String activityTitle = bundle.getString("username");

        this.setTitle("Menu " + activityTitle);
    }

    private void initTampilMahasiswaButton() {
        _tampilMahasiswaButton = (Button) findViewById(R.id.tampilMahasiswaButton);

        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilMahasiswaIntent);
            }
        });
    }

    private void initTampilForexButton() {
        _tampilForexButton = (Button) findViewById(R.id.tampilForexButton);

        _tampilForexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _tampilForexIntent = new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });
    }

    private void initTampilCuacaButton() {
        _tampilCuacaButton = findViewById(R.id.tampilCuacaButton);

        _tampilCuacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilCuacaIntent = new Intent(getApplicationContext(), CuacaMainActivity.class);
                startActivity(_tampilCuacaIntent);
            }
        });
    }

    private void initTampilImplicitButton() {
        _tampilImplicitButton = findViewById(R.id.tampilImplicitButton);

        _tampilImplicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilImplicitIntent = new Intent(getApplicationContext(), ImplicitMainActivity.class);
                startActivity(_tampilImplicitIntent);
            }
        });
    }

    private void initTampilTabLayoutButton() {
        _tampilTabLayoutButton = findViewById(R.id.tampilTabLayoutButton);

        _tampilTabLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilTabLayoutIntent = new Intent(getApplicationContext(), TabLayoutMainActivity.class);
                startActivity(_tampilTabLayoutIntent);
            }
        });
    }

    private void initTampilHotelButton() {
        _tampilHotelButton = findViewById(R.id.tampilHotelButton);

        _tampilHotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilHotelIntent = new Intent(getApplicationContext(), HotelAppMainActivity.class);
                startActivity(_tampilHotelIntent);
            }
        });
    }

    private void initTampilWebLanjutanButton() {
        _tampilWebLanjutanButton = findViewById(R.id.tampilWebLanjutanButton);

        _tampilWebLanjutanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilWebLanjutanIntent = new Intent(getApplicationContext(), WebLanjutanMainActivity.class);
                startActivity(_tampilWebLanjutanIntent);
            }
        });
    }
}