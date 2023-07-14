package com.putrisuai201103646.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HotelAppMainActivity extends AppCompatActivity {

    private ImageView _imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_app_main);

        _imageView1 = (ImageView) findViewById(R.id.imageView1);

        String imageUrl = "https://thumbs.dreamstime.com/b/sunrise-over-beach-cancun-beautiful-mexico-40065727.jpg";
        Picasso.with(this).load(imageUrl).into(_imageView1);
    }
}