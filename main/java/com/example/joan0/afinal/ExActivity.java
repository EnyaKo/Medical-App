package com.example.joan0.afinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExActivity extends AppCompatActivity {
    private SQLiteDatabase db = null;
    private final static String	CREATE_TABLE = "CREATE TABLE 'table01'('_id' INTEGER PRIMARY KEY,'date' TEXT,'rate' REAL)";
    int dnum=0;
    Button getd;
    EditText month,day,filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex);
        getd=(Button)findViewById(R.id.getd);
        Button bt2=(Button)findViewById(R.id.button02);
        month = (EditText) findViewById(R.id.Edittext1);
        day = (EditText) findViewById(R.id.Edittext2);
        filename= (EditText) findViewById(R.id.Edittext3);
        getd.setOnClickListener(getdata);
        db = openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        try{
            db.execSQL(CREATE_TABLE); // 執行資料庫指令
        }catch (Exception e){
        }
        bt2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db.execSQL("DROP TABLE table01");
                db.execSQL(CREATE_TABLE);
                Toast.makeText(ExActivity.this, "清空成功", Toast.LENGTH_LONG).show();
            }
        });


    }
    private Button.OnClickListener getdata=new Button.OnClickListener(){
        public void onClick(View v){

            int a =1;
            int cl=0;
            int b=1;
            try {
                //取得SD卡儲存路徑
                File mSDFile = Environment.getExternalStorageDirectory();
                //讀取文件檔路徑
                FileReader fr = new FileReader(mSDFile.getParent() + "/" + mSDFile.getName() + "/Download/"+filename.getText().toString());

                BufferedReader br =new BufferedReader(fr);
                String mReadText = "";
                String mTextLine = br.readLine();

                //一行一行取出文字字串裝入String裡，直到沒有下一行文字停止跳出
                while (mTextLine!=null)
                {
                    a++;
                    mTextLine = br.readLine();
                }
                String stringValue = Integer.toString(a);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int len = a *3+1;
            String input[]=new String[len];
            try {
                File mSDFile = Environment.getExternalStorageDirectory();
                //讀取文件檔路徑
                FileReader fr = new FileReader(mSDFile.getParent() + "/" + mSDFile.getName() + "/Download/"+filename.getText().toString());
                String mReadText = "";
                BufferedReader br =new BufferedReader(fr);
                String mTextLine = br.readLine();

                //一行一行取出文字字串裝入String裡，直到沒有下一行文字停止跳出
                while (mTextLine!=null)
                {
                    if(b>2){
                        input[cl]=mTextLine.substring(0,4);
                        cl++;
                        input[cl]=mTextLine.substring(5,9);
                        cl++;
                        input[cl]=mTextLine.substring(10,14);
                        cl++;
                    }
                    b++;
                    mTextLine=br.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Integer data[] = new Integer[len];
            String stt="";
            for(int i =0;i<len;i++){
                if(input[i]!=null) {
                    data[i] = Integer.valueOf(input[i], 16);
                    if (data[i] > 32767) {
                        stt=Integer.toBinaryString(Integer.valueOf(input[i], 16));
                        stt=stt.replaceAll("1","a");
                        stt=stt.replaceAll("0","1");
                        stt=stt.replaceAll("a","0");
                        data[i]=Integer.valueOf(stt,2);
                    }
                }else{
                    data[i]=0;
                }
            }

            int std=200;

            int last =0;
            double m1=0,nm1=0,m2=0,nm2=0,m3=0,nm3=0,t;

            if(len<80000) {
                for (int i = 0; i <= len-5; i++) {
                    if (i % 5 == 0) {
                        int ans = data[i] + data[i + 1] + data[i + 2] + data[i + 3] + data[i + 4];
                        ans = ans / 5;
                        ans = Math.abs(last - ans);
                        if (ans > std) {
                            m1++;
                        } else {
                            nm1++;
                        }
                        last = ans;
                    }
                    dnum = 1;
                }
            }
            if(len>=80000) {
                for(int i =0;i<=80000;i++){
                    if(i%5==0){
                        int ans = data[i]+data[i+1]+data[i+2]+data[i+3]+data[i+4];
                        ans=ans/5;
                        ans=Math.abs(last-ans);
                        if(ans > std){
                            m1++;
                        }else{
                            nm1++;
                        }
                        last = ans;
                    }
                }
                for (int i = 80001; i <= 160000; i++) {
                    if (i % 5 == 0) {
                        int ans = data[i] + data[i + 1] + data[i + 2] + data[i + 3] + data[i + 4];
                        ans = ans / 5;
                        ans = Math.abs(last - ans);
                        if (ans > std) {
                            m2++;
                        } else {
                            nm2++;
                        }
                        last = ans;
                    }
                }
            }
            if(len>160001) {
                for (int i = 160001; i <= len-5; i++) {
                    if (i % 5 == 0) {
                        int ans = data[i] + data[i + 1] + data[i + 2] + data[i + 3] + data[i + 4];
                        ans = ans / 5;
                        ans = Math.abs(last - ans);
                        if (ans > std) {
                            m3++;
                        } else {
                            nm3++;
                        }
                        last = ans;
                    }
                }
            }
            Intent intent=new Intent();
            intent.setClass(ExActivity.this,MedActivity.class);
            Bundle bundle=new Bundle();
            Double d = m1/(m1+nm1);
            Double dd=0.0,ddd=0.0;
            if((m2+nm2)>0)
                dd = m2/(m2+nm2);
            if((m3+nm3)>0)
                ddd = m3/(m3+nm3);

            t=(m1+m2+m3)/(m1+m2+m3+nm1+nm2+nm3);
            String str;
            String str1;
            String str2;
            if(month.getText().length()!=0&&day.getText().length()!=0) {

                String nmonth = month.getText().toString();
                if(len > 160000){
                    int date1 = Integer.valueOf(day.getText().toString())-2;
                    int date2 = Integer.valueOf(day.getText().toString())-1;
                    int date3 = Integer.valueOf(day.getText().toString());
                    str = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date1) + "," + Double.toString(ddd) + ")";
                    str1 = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date2) + "," + Double.toString(dd) + ")";
                    str2 = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date3) + "," + Double.toString(d) + ")";

                    db.execSQL(str);
                    db.execSQL(str1);
                    db.execSQL(str2);

                    bundle.putString("date1",Integer.toString(date1));
                    bundle.putString("date2",Integer.toString(date2));
                    bundle.putString("date3",Integer.toString(date3));
                    dnum=3;
                }
                else if(len >80000){
                    int date2 = Integer.valueOf(day.getText().toString())-1;
                    int date3 = Integer.valueOf(day.getText().toString());
                    bundle.putString("date2",Integer.toString(date2));
                    bundle.putString("date3",Integer.toString(date3));
                    str1 = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date2) + "," + Double.toString(dd) + ")";
                    str2 = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date3) + "," + Double.toString(d) + ")";
                    db.execSQL(str1);
                    db.execSQL(str2);
                    dnum=2;
                }
                else {

                    int date3 = Integer.valueOf(day.getText().toString());
                    bundle.putString("date3",Integer.toString(date3));
                    str2 = "INSERT INTO table01 (date, rate) values (" + month.getText().toString() + Integer.toString(date3) + "," + Double.toString(d) + ")";
                    db.execSQL(str2);
                    dnum=1;
                }
                bundle.putDouble("total",t);
                bundle.putString("month",nmonth);
                bundle.putInt("dnum",dnum);
                intent.putExtras(bundle);
                startActivity(intent);
            }


        }
    };

}
