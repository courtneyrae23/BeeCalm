package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import wecare.beecalm.SimpleGestureFilter.SimpleGestureListener;

/**
 * Created by Zhuosi on 4/20/16.
 */
public class TappingActivity extends Activity implements SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapping);

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

            case SimpleGestureFilter.SWIPE_RIGHT :
                Intent intent_right = new Intent(this, YogaActivity.class);
                startActivity(intent_right);
                break;
            case SimpleGestureFilter.SWIPE_LEFT :
                Intent intent_left = new Intent(this, BiofeedbackActivity.class);
                startActivity(intent_left);
                break;
        }
    }

    @Override
    public void onDoubleTap() {
    }
}
