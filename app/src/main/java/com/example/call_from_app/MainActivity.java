package com.example.call_from_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.mobile);
        call=findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String number=text.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+"+91"+number));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED){
                    Log.d("Call",number);
                    startActivity(callIntent);
                }
                else
                {
                    startActivity(callIntent);
                }
            }
        });

    }
}