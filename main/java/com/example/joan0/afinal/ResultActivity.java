package com.example.joan0.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    String result;
    TextView out;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer reg[]= new Integer[16];
        for(int i = 0 ;i<16;i++){
            reg[i]=0;
        }
        setContentView(R.layout.activity_result);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        result = bundle.getString("result");
        String[] tokens=result.split(" ");
        for(String token:tokens){
            reg[Integer.valueOf(token)]++;
        }
        String output="如果您有服用以下藥物:\n";
        for(int i=1;i<16;i++){
            if(reg[i]>0){
                switch (i){
                    case 1:
                        output+="Indapamide SR (Natrilix)\n(鈉催離持續性藥效膜衣錠)\n";
                        break;
                    case 2:
                        output+="Propranolol (Inderal)\n(恩特來錠)\n";
                        break;
                    case 3:
                        output+="Captopril (Ceporin)\n(血樂平錠)\n";
                        break;
                    case 4:
                        output+="Candesartan (Blopress)\n(博脈舒錠)\n";
                        break;
                    case 5:
                        output+="Chlopropamide (Diabinese)\n(降血糖錠)\n";
                        break;
                    case 6:
                        output+="Doxazosin XL (Doxaben)\n(可迅持續性藥效錠)\n";
                        break;
                    case 7:
                        output+="Glucophage (Metformin)\n(庫魯化錠)\n";
                        break;
                    case 8:
                        output+="Amlodipine (Norvasc)\n(脈優錠)\n";
                        break;
                    case 9:
                        output+="acarbose (Glucobay)\n(醣祿錠)\n";
                        break;
                    case 10:
                        output+="miglitol (Glyset)\n(麥若醣膜衣錠)\n";
                        break;
                    case 11:
                        output+="Sitagliptin (Januvia)\n(佳糖維)\n";
                        break;
                    case 12:
                        output+="rosiglitazone  (Avandia)\n(梵帝雅膜衣錠)\n";
                        break;
                    case 13:
                        output+="Glimepiride (Amaryl)\n(瑪爾胰錠)\n";
                        break;
                    case 14:
                        output+="Repaglinide (NovoNorm)\n(諾和隆錠)\n";
                        break;
                    default:
                        output+="";
                        break;
                }
            }
        }
        output+="那您所感受到的不適很有可能是藥物副作用所引起，\n如果並未服用上述藥物，或是感受不適之時間超過兩小時，請盡速就醫！";
        out = (TextView) findViewById(R.id.textView5);
        out.setText(output);
    }
}
