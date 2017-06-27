package jp.co.brilliantservice.hacks.useAlarm;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;


import java.util.Random;

public class WakeupActivity extends Activity {
	private MediaPlayer player;

    //Randomクラスの生成（シード指定なし）
    Random rnd = new Random();

    int num1,num2;

    int num3 = num1 * num2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wakeup);

		Log.i("@@@", "Called WakeupActivity onCreate");
		
        Time t = new Time();
        t.setToNow();

        // アラームをループ再生
		//Randomクラスのインスタンス化
		//Random rnd = new Random();
		int ran = rnd.nextInt(5);

        switch (ran) {
            case 0:
                player = MediaPlayer.create(this, R.raw.test_cbr);
            case 1:
                player = MediaPlayer.create(this, R.raw.zinguru);
            case 2:
                player = MediaPlayer.create(this, R.raw.morningglow);
            case 3:
                player = MediaPlayer.create(this, R.raw.coffeebreak);
            case 4:
                player = MediaPlayer.create(this, R.raw.morningglow);
        }

        //player = MediaPlayer.create(this, R.raw.test_cbr);
        player.setLooping(true);
        player.start();

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        final EditText editText = (EditText) findViewById(R.id.edit_text);

        ransu();
        Log.d("onClick","発生された値 は「" + num1 + "」");
        Log.d("onClick","発生された値 は「" + num2 + "」");
        textView1.setText(num1 + "×" + num2 + "の解を答えよ。" );

		Button stop_btn = (Button)findViewById(R.id.stop_btn);
		stop_btn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {

                // エディットテキストのテキストを取得
                String text = editText.getText().toString();
                Log.d("onClick","入力された値 は「" + text + "」");

                int result = Integer.parseInt(text);

                if (num3 == result){
                    // アラームを止める
                    player.stop();
                    // 画面遷移
                    Intent intent = new Intent(WakeupActivity.this, MainActivity.class);
                    startActivity(intent);
                }
			}
		});
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("@@@", "Called WakeupActivity onStop");
		
		player.stop();
		finish();
	}

    protected void ransu(){
        do {
            num1 = rnd.nextInt(100);
            num2 = rnd.nextInt(100);
        } while(num1 < 10 || num2 < 10);
    }
}