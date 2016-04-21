package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import wecare.beecalm.SimpleGestureFilter.SimpleGestureListener;

/**
 * Created by Zhuosi on 4/20/16.
 */
public class BiofeedbackActivity extends Activity implements SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biofeedback);

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
                Intent intent_right = new Intent(this, TappingActivity.class);
                startActivity(intent_right);
                break;
        }
    }

    @Override
    public void onDoubleTap() {
    }
}
