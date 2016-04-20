package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Zhuosi on 4/20/16.
 */
public class MantraSettingStep2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantra_setting_step2);
        setTitle("Yoga Settings");

        ImageView view  = (ImageView) findViewById(R.id.imageView);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent startActivity = new Intent(MantraSettingStep2Activity.this,MantraSettingStep3Activity.class);
                startActivity(startActivity);

            }
        });
    }

}
