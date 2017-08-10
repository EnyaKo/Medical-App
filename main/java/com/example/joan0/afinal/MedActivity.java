package com.example.joan0.afinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class MedActivity extends AppCompatActivity {
    private LinearLayout llBarChart;
    private View vChart;
    private boolean flag = false;
    private SQLiteDatabase db = null;
    Double lastt=0.0,tt=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med2);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        int dnum = bundle.getInt("dnum");
        String date3 =bundle.getString("date3");
        String date2 =bundle.getString("date2");
        String date1 =bundle.getString("date1");
        String month =bundle.getString("month");
        final Double total =bundle.getDouble("total");
        String str="";
        String str1="";
        String str2="";
        lastt=0.0;
        final TextView TV = (TextView) findViewById(R.id.textView);
        final String[][] Top10ErrCode= new String[3][2];
        final String[][] Top10ErrCode2= new String[dnum][2];
        db = openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        if(dnum==3){
            Cursor cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date3+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date2+"'",null);
            if (cursor.moveToFirst()) {
                str1 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date1+"'",null);
            if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            Top10ErrCode2[0][0]=month+"/"+date1;
            Top10ErrCode2[0][1]=str2;
            Top10ErrCode2[1][0]=month+"/"+date2;
            Top10ErrCode2[1][1]=str1;
            Top10ErrCode2[2][0]=month+"/"+date3;
            Top10ErrCode2[2][1]=str;
            str="";
            str1="";
            str2="";
            int pred3=Integer.valueOf(date1)-1;
            int pred2=Integer.valueOf(date1)-2;
            int pred1=Integer.valueOf(date1)-3;
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred1+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred2+"'",null);
            if (cursor.moveToFirst()) {
                str1 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred3+"'",null);
            if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            Top10ErrCode[0][0]=month+"/"+pred1;
            Top10ErrCode[0][1]=str;
            Top10ErrCode[1][0]=month+"/"+pred2;
            Top10ErrCode[1][1]=str1;
            Top10ErrCode[2][0]=month+"/"+pred3;
            Top10ErrCode[2][1]=str2;

        }else if(dnum==2){
            Cursor cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date3+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date2+"'",null);
            if (cursor.moveToFirst()) {
                str1 = cursor.getString(cursor.getColumnIndex("rate"));
            }

            Top10ErrCode2[0][0]=month+"/"+date2;
            Top10ErrCode2[0][1]=str1;
            Top10ErrCode2[1][0]=month+"/"+date3;
            Top10ErrCode2[1][1]=str;
            int pred3=Integer.valueOf(date2)-1;
            int pred2=Integer.valueOf(date2)-2;
            int pred1=Integer.valueOf(date2)-3;
            str="";
            str1="";
            str2="";
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred1+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred2+"'",null);
            if (cursor.moveToFirst()) {
                str1 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred3+"'",null);
            if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            Top10ErrCode[0][0]=month+"/"+pred1;
            Top10ErrCode[0][1]=str;
            Top10ErrCode[1][0]=month+"/"+pred2;
            Top10ErrCode[1][1]=str1;
            Top10ErrCode[2][0]=month+"/"+pred3;
            Top10ErrCode[2][1]=str2;
        }else{
            Cursor cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+date3+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            Top10ErrCode2[0][0]=month+"/"+date3;
            Top10ErrCode2[0][1]=str;
            int pred3=Integer.valueOf(date3)-1;
            int pred2=Integer.valueOf(date3)-2;
            int pred1=Integer.valueOf(date3)-3;
            str="";
            str1="";
            str2="";
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred1+"'",null);
            if (cursor.moveToFirst()) {
                str = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred2+"'",null);
            if (cursor.moveToFirst()) {
                str1 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            cursor = db.rawQuery("SELECT * FROM `table01` WHERE `date`='"+month+pred3+"'",null);
            if (cursor.moveToFirst()) {
                str2 = cursor.getString(cursor.getColumnIndex("rate"));
            }
            Top10ErrCode[0][0]=month+"/"+pred1;
            Top10ErrCode[0][1]=str;
            Top10ErrCode[1][0]=month+"/"+pred2;
            Top10ErrCode[1][1]=str1;
            Top10ErrCode[2][0]=month+"/"+pred3;
            Top10ErrCode[2][1]=str2;
        }
        Double cou=0.0;
        if(!Top10ErrCode[0][1].equals("")){
            lastt += Double.valueOf(Top10ErrCode[0][1]);
            cou++;
        }
        if(!Top10ErrCode[1][1].equals("")){
            lastt+=Double.valueOf(Top10ErrCode[1][1]);
            cou++;
        }
        if(!Top10ErrCode[2][1].equals("")){
            lastt+=Double.valueOf(Top10ErrCode[2][1]);
            cou++;
        }
        if(cou>0)
            lastt=lastt/cou;
        tt=0.0;
        cou=0.0;
        if(!Top10ErrCode2[0][1].equals("")){
            tt += Double.valueOf(Top10ErrCode2[0][1]);
            cou++;
        }
        if(dnum>1&&!Top10ErrCode2[1][1].equals("")){
            tt+=Double.valueOf(Top10ErrCode2[1][1]);
            cou++;
        }
        if(dnum>2&&!Top10ErrCode2[2][1].equals("")){
            tt+=Double.valueOf(Top10ErrCode2[2][1]);
            cou++;
        }
        if(cou>0)
            tt=tt/cou;
        if(Double.toString(tt*100).length()>7)
            TV.setText("本週運動量比率:"+Double.toString(tt*100).substring(0,6)+"%");
        else
            TV.setText("本週運動量比率:"+Double.toString(tt*100)+"%");
        llBarChart = (LinearLayout) findViewById(R.id.llBarChart);
        final Button button01 = (Button)findViewById(R.id.button01);
        try{
            vChart = getBarChart("本周活動量比率表", "", "活動量比率", Top10ErrCode2);
            llBarChart.removeAllViews();
            //llBarChart.addView(vChart);
            llBarChart.addView(vChart, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 1000));

        }catch(Exception e) {
        }
        button01.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(flag) {
                    if(Double.toString(lastt*100).length()>7)
                        TV.setText("上週運動量比率:"+Double.toString(lastt*100).substring(0,6)+"%");
                    else
                        TV.setText("上週運動量比率:"+Double.toString(lastt*100)+"%");
                    button01.setText("本週");
                    flag = false;
                    try{
                        vChart = getBarChart("上周活動量比率表", "", "活動量比率", Top10ErrCode);
                        llBarChart.removeAllViews();
                        //llBarChart.addView(vChart);
                        llBarChart.addView(vChart, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 1000));

                    }catch(Exception e){
                    }
                }
                else{
                    if(Double.toString(tt*100).length()>7)
                        TV.setText("本週運動量比率:"+Double.toString(tt*100).substring(0,6)+"%");
                    else
                        TV.setText("本週運動量比率:"+Double.toString(tt*100)+"%");
                    button01.setText("上週");
                    flag = true;
                    try{
                        vChart = getBarChart("本周活動量比率表", "", "活動量比率", Top10ErrCode2);
                        llBarChart.removeAllViews();
                        //llBarChart.addView(vChart);
                        llBarChart.addView(vChart, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 1000));

                    }catch(Exception e){

                    }
                }
            }
        });
        if(tt>lastt&&tt>=0.3)
            Toast.makeText( MedActivity.this,"您的運動量比起上禮拜多了"+Double.toString((tt-lastt)*100)+"% \n而且您的運動量是足夠的。", Toast.LENGTH_LONG).show();
        else if(tt>lastt&&tt<0.3){
            Toast.makeText( MedActivity.this,"您的運動量比起上禮拜多了"+Double.toString((tt-lastt)*100)+"% \n不過仍然需要努力。", Toast.LENGTH_LONG).show();
        }
        else if(tt<lastt&&tt>=0.3){
            Toast.makeText( MedActivity.this,"您的運動量比起上禮拜少了"+Double.toString((lastt-tt)*100)+"% \n不過您的運動量是足夠的。", Toast.LENGTH_LONG).show();
        }
        else if(tt<lastt&&tt<0.3){
            Toast.makeText( MedActivity.this,"您的運動量比起上禮拜少了"+Double.toString((lastt-tt)*100)+"% \n而且您的運動量不足，仍然需要努力。", Toast.LENGTH_LONG).show();
        }
    }

    private View getBarChart(String chartTitle, String XTitle, String YTitle, String[][] xy){

        XYSeries Series = new XYSeries(YTitle);

        XYMultipleSeriesDataset Dataset = new XYMultipleSeriesDataset();
        Dataset.addSeries(Series);

        XYMultipleSeriesRenderer Renderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer yRenderer = new XYSeriesRenderer();
        Renderer.addSeriesRenderer(yRenderer);

        //Renderer.setApplyBackgroundColor(true);			//設定背景顏色
        //Renderer.setBackgroundColor(Color.BLACK);			//設定圖內圍背景顏色
        Renderer.setMarginsColor(Color.WHITE);				//設定圖外圍背景顏色
        Renderer.setTextTypeface(null, Typeface.BOLD);		//設定文字style

        Renderer.setShowGrid(true);							//設定網格
        Renderer.setGridColor(Color.GRAY);					//設定網格顏色

        //Renderer.setRange(new double[] {0d, 5d, 0d, 100d});
        Renderer.setMargins(new int[] { 150, 40, 100, 10 });  //設置外邊距，順序為：上左下右
        //Renderer.setLegendHeight(20);                       //设置说明的高度，單位px
        Renderer.setChartTitle(chartTitle);					//設定標頭文字
        Renderer.setLabelsColor(Color.BLACK);				//設定標頭文字顏色
        Renderer.setChartTitleTextSize(45);					//設定標頭文字大小
        Renderer.setLabelsTextSize(40);                     //設定說明文字大小
        Renderer.setAxesColor(Color.BLACK);					//設定雙軸顏色
        Renderer.setBarSpacing(0.7);						//設定bar間的距離
        Renderer.setLegendTextSize(40);                 //設定圖例文字大小
        Renderer.setZoomEnabled(false);                 //是否可縮放
        Renderer.setZoomButtonsVisible(false);          //設置可以縮放
        Renderer.setInScroll(false);                    // 设置可移动
        Renderer.setPanEnabled(false, false);           //是否可点击
        Renderer.setClickEnabled(false);

        //Renderer.setXTitle(XTitle);						//設定X軸文字
        //Renderer.setYTitle(YTitle);						//設定Y軸文字
        Renderer.setXLabelsColor(Color.BLACK);				//設定X軸文字顏色
        Renderer.setYLabelsColor(0, Color.BLACK);			//設定Y軸文字顏色
        Renderer.setXLabelsAlign(Paint.Align.CENTER);				//設定X軸文字置中
        Renderer.setYLabelsAlign(Paint.Align.CENTER);				//設定Y軸文字置中
        Renderer.setFitLegend(true);// 調整合適的位置
        Renderer.setXLabelsAngle(0); 						//設定X軸文字傾斜度

        Renderer.setXLabels(0); 							//設定X軸不顯示數字, 改以程式設定文字
        Renderer.setYAxisMin(0);							//設定Y軸文最小值
        Renderer.setYAxisMax(1);
        yRenderer.setColor(Color.BLUE);              		//設定Series顏色
        //yRenderer.setDisplayChartValues(true);			//展現Series數值
        Series.add(0, 0);
        Renderer.addXTextLabel(0, "");
        for(int r=0; r<xy.length; r++) {
            //Log.i("DEBUG", (r+1)+" "+xy[r][0]+"; "+xy[r][1]);
            Renderer.addXTextLabel(r+1, xy[r][0]);
            Series.add(r+1, Double.parseDouble(xy[r][1]));
        }
        Series.add(6, 0);
        Renderer.addXTextLabel(xy.length+1, "");

        View view = ChartFactory.getBarChartView(getBaseContext(), Dataset, Renderer, BarChart.Type.DEFAULT);
        return view;
    }
}
