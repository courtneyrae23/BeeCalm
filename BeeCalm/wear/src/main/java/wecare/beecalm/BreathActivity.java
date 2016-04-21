package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import wecare.beecalm.R;
import wecare.beecalm.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by Zhuosi on 4/20/16.
 */

public class BreathActivity extends Activity implements SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath);


        // Detect touched area
        detector = new SimpleGestureFilter(this,this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }
    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {
            case SimpleGestureFilter.SWIPE_LEFT :
                Intent intent_left = new Intent(this, MantrasActivity.class);
                startActivity(intent_left);;
                break;

        }
    }

    @Override
    public void onDoubleTap() {
    }

}
