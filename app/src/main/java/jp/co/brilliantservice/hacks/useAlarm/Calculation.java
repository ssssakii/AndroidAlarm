package jp.co.brilliantservice.hacks.useAlarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import java.util.Random;
import android.widget.TextView;

/**
 * Created by SAKI on 2017/06/23.
 */

public class Calculation extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation);


        //Randomクラスの生成（シード指定なし）
        Random rnd = new Random();

        int num1 = rnd.nextInt(100) + 100;
        int num2 = rnd.nextInt(100) + 500;

        int num3 = num1 * num2;

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(num1 + "×" + num2 + "の解を答えよ。" );


        Button hand_btn = (Button)findViewById(R.id.hand_btn);
        hand_btn.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {

                TextView textView2 = (TextView) findViewById(R.id.textView2);
                // テキストビューのテキストを取得します
                String text = textView2.getText().toString();

                //if( == text){

                //}



            }

        });
    }
}
