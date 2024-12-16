package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button choivoimay,choihainguoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        choivoimay=(Button) findViewById(R.id.btnChoiVoiMay);
        choihainguoi=(Button) findViewById(R.id.btnChoi2Nguoi);
        choivoimay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChonCheDo.class);
                Bundle bundle=new Bundle();
                bundle.putString("CheDo","ChoiVoiMay");
                intent.putExtra("du_lieu",bundle);
                startActivity(intent);
            }
        });
        choihainguoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ChonCheDo.class);
                Bundle bundle=new Bundle();
                bundle.putString("CheDo","ChoiHaiNguoi");
                intent.putExtra("du_lieu",bundle);
                startActivity(intent);
            }
        });

    }
}