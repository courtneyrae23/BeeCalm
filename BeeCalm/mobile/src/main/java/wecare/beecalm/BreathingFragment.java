package wecare.beecalm;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Zhuosi on 4/16/16.
 */
public class BreathingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.breathing_view, container, false);
        MediaController mc= new MediaController(getActivity());
        VideoView ballonView = (VideoView)rootView.findViewById(R.id.videoview_ballon);

        mc.setAnchorView(ballonView);
        ballonView.setMediaController(mc);
        ballonView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.ballon);
        ballonView.start();

        ballonView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        VideoView clockView = (VideoView)rootView.findViewById(R.id.videoview_clock);

        mc.setAnchorView(clockView);
        clockView.setMediaController(mc);
        clockView.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + R.raw.clock);
        clockView.start();

        clockView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        return rootView;
    }
}

