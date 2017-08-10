package com.example.joan0.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button SymPage,exPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SymPage=(Button)findViewById(R.id.medPage);
        SymPage.setOnClickListener(SymLis);
        exPage=(Button)findViewById(R.id.exPage);
        exPage.setOnClickListener(exLis);
    }

    private Button.OnClickListener SymLis=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,SymActivity.class);
            startActivity(intent);
        }
    };
    private Button.OnClickListener exLis=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,ExActivity.class);
            startActivity(intent);
        }
    };
}
