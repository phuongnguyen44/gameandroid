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

public class ChonCheDo extends AppCompatActivity {
    Button chedo3,chedo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chon_che_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        chedo3=(Button) findViewById(R.id.btn3x3);
        chedo5=(Button) findViewById(R.id.btn5x5);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("du_lieu");
        if(bundle !=null){
            String chedo=bundle.getString("CheDo");
            if(chedo.equals("ChoiVoiMay")){
                chedo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent chedo3x3May=new Intent(ChonCheDo.this, Chedo3x3cuachoivoimay.class);
                        startActivity(chedo3x3May);
                    }
                });
                chedo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent chedo5x5May=new Intent(ChonCheDo.this, Chedo5x5cuachoivoimay.class);
                        startActivity(chedo5x5May);
                    }
                });
            }
            if(chedo.equals("ChoiHaiNguoi")){
                chedo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent chedo3x3Nguoi=new Intent(ChonCheDo.this, Chedo3x3cuachoi2nguoi.class);
                        startActivity(chedo3x3Nguoi);
                    }
                });
                chedo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent chedo5x5Nguoi=new Intent(ChonCheDo.this, Chedo5x5cuachoi2nguoi.class);
                        startActivity(chedo5x5Nguoi);
                    }
                });
            }
        }
    }
}