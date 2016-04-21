package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new CountDownTimer(2000, 1000) {
            public void onFinish() {
                Intent startActivity = new Intent(WelcomeActivity.this,BreathActivity.class);
                startActivity(startActivity);
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }

        }.start();
    }
}
