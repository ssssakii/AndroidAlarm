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

    int num1 = rnd.nextInt(100) + 100;
    int num2 = rnd.nextInt(100) + 500;

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
		Random rnd = new Random();
		int ran = rnd.nextInt(2);
        if (ran == 0) {
            player = MediaPlayer.create(this, R.raw.test_cbr);
        }else {
            player = MediaPlayer.create(this, R.raw.zinguru);
        }

        //player = MediaPlayer.create(this, R.raw.test_cbr);
        player.setLooping(true);
        player.start();

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        final EditText editText = (EditText) findViewById(R.id.edit_text);

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
}