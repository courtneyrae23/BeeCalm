package wecare.beecalm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Zhuosi on 4/20/16.
 */
public class TappingPointsSettingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapping_points_setting);
        setTitle("Yoga Settings");

        ImageView view  = (ImageView) findViewById(R.id.imageView);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}
