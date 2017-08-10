package com.example.joan0.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SymActivity extends AppCompatActivity {
    String Med;
    private Button Send;
    private CheckBox symcb10,symcb1,symcb2,symcb3,symcb4,symcb5,symcb6,symcb7,symcb8,symcb9;
    private CheckBox symcb20,symcb11,symcb12,symcb13,symcb14,symcb15,symcb16,symcb17,symcb18,symcb19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sym);

        findViews();
        addListener();

    }
    protected void findViews(){
        Send = (Button)findViewById(R.id.button2);
        symcb1 = (CheckBox) findViewById(R.id.symcb1);
        symcb2 = (CheckBox) findViewById(R.id.symcb2);
        symcb3 = (CheckBox) findViewById(R.id.symcb3);
        symcb4 = (CheckBox) findViewById(R.id.symcb4);
        symcb5 = (CheckBox) findViewById(R.id.symcb5);
        symcb6 = (CheckBox) findViewById(R.id.symcb6);
        symcb7 = (CheckBox) findViewById(R.id.symcb7);
        symcb8 = (CheckBox) findViewById(R.id.symcb8);
        symcb9 = (CheckBox) findViewById(R.id.symcb9);
        symcb10 = (CheckBox) findViewById(R.id.symcb10);
        symcb11 = (CheckBox) findViewById(R.id.symcb11);
        symcb12 = (CheckBox) findViewById(R.id.symcb12);
        symcb13 = (CheckBox) findViewById(R.id.symcb13);
        symcb14 = (CheckBox) findViewById(R.id.symcb14);
        symcb15 = (CheckBox) findViewById(R.id.symcb15);
        symcb16 = (CheckBox) findViewById(R.id.symcb16);
        symcb17 = (CheckBox) findViewById(R.id.symcb17);
        symcb18 = (CheckBox) findViewById(R.id.symcb18);
        symcb19 = (CheckBox) findViewById(R.id.symcb19);
        symcb20 = (CheckBox) findViewById(R.id.symcb20);

    }
    protected void addListener(){
        Send.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SymActivity.this,ResultActivity.class);

                String SymName = "";
                Bundle bundle=new Bundle();
                if(symcb1.isChecked())
                    SymName +="1 ";
                if(symcb2.isChecked())
                    SymName +="2 ";
                if(symcb3.isChecked())
                    SymName +="1 ";
                if(symcb4.isChecked())
                    SymName +="3 5 ";
                if(symcb5.isChecked())
                    SymName +="3 ";
                if(symcb6.isChecked())
                    SymName +="3 ";
                if(symcb7.isChecked())
                    SymName +="4 2 6 ";
                if(symcb8.isChecked())
                    SymName +="4 ";
                if(symcb9.isChecked())
                    SymName +="4 ";
                if(symcb10.isChecked())
                    SymName +="2 ";
                if(symcb11.isChecked())
                    SymName +="2 7 ";
                if(symcb12.isChecked())
                    SymName +="8 7 9 10 ";
                if(symcb13.isChecked())
                    SymName +="8 ";
                if(symcb14.isChecked())
                    SymName +="8 12 ";
                if(symcb15.isChecked())
                    SymName +="13 ";
                if(symcb16.isChecked())
                    SymName +="6 1 3 ";
                if(symcb17.isChecked())
                    SymName +="5 ";
                if(symcb18.isChecked())
                    SymName +="13 14 ";
                if(symcb19.isChecked())
                    SymName +="11 ";
                if(symcb20.isChecked())
                    SymName +="11 ";
                bundle.putString("result", SymName);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
