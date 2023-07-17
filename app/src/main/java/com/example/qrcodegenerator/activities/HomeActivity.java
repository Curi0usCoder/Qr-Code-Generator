package com.example.qrcodegenerator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qrcodegenerator.MainActivity;
import com.example.qrcodegenerator.R;

public class HomeActivity extends AppCompatActivity {

    LinearLayout Scannerbtn,Generatorbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

        Scannerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ScannerActivity.class));
            }
        });

        Generatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

    }

    private void initViews(){
        Scannerbtn=findViewById(R.id.scanner_activity);
        Generatorbtn=findViewById(R.id.generator_activity);

    }

}