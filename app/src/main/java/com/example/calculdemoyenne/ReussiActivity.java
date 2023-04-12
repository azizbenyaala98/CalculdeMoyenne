package com.example.calculdemoyenne;

import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.ACTION_SENDTO;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReussiActivity extends AppCompatActivity {
    Button btnHome ,btnSms;
    private TextView tv;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);
        btnHome=findViewById(R.id.home);
        btnSms=findViewById(R.id.sms);
        tv = findViewById(R.id.resultat);
        Intent j = getIntent();
        float m = j.getFloatExtra("moyenne", 0);
        String msg = "Félicitations, vous avez réussi avec une moyenne de " + m;
        tv.setText(msg);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReussiActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("smsto:53303470");
                i.setData(uri);

                i.putExtra("sms_body", msg);
                startActivity(i);
            }
        });


    }
}
