package wecare.beecalm;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Zhuosi on 4/16/16.
 */
public class BreathingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.breathing_view, container, false);
//        MediaController mc= new MediaController(getActivity());
//        VideoView ballonView = (VideoView)rootView.findViewById(R.id.videoview_ballon);
//
//        mc.setAnchorView(ballonView);
//        ballonView.setMediaController(mc);
//        ballonView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.ballon);
//        ballonView.start();
//
//        ballonView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
//
//        VideoView clockView = (VideoView)rootView.findViewById(R.id.videoview_clock);
//
//        mc.setAnchorView(clockView);
//        clockView.setMediaController(mc);
//        clockView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.clock);
//        clockView.start();
//
//        clockView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    Fragment fragment = null;
                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {
                        Log.i("Respond", "onFling has been called!");
                        final int SWIPE_MIN_DISTANCE = 120;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                                return false;
                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                fragment = new MantrasFragment();
                                String title  = "Mantras";
                                if (fragment != null) {
                                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                    ft.replace(R.id.content_frame, fragment);
                                    ft.commit();
                                }

                                // set the toolbar title
                                if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
                                    ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
                                }
                            }
                        } catch (Exception e) {
                            // nothing
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        ImageView img1 = (ImageView) rootView.findViewById(R.id.imageView1);
        ImageView img2 = (ImageView) rootView.findViewById(R.id.imageView2);
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        return rootView;


    }
}

