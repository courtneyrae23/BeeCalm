package wecare.beecalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Zhuosi on 4/20/16.
 */
public class MantraSettingStep3Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantra_setting_step3);
        setTitle("Yoga Settings");

        ImageView view  = (ImageView) findViewById(R.id.imageView);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent startActivity = new Intent(MantraSettingStep3Activity.this,MantraSettingsActivity.class);
                startActivity(startActivity);

            }
        });
    }

}
