package wecare.beecalm;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Random;

/**
 * Created by Zhuosi on 4/16/16.
 */
public class SimonFragment  extends Fragment {

    private ArrayList<Integer> pattern = new ArrayList<Integer>();
    private ArrayList<Integer> tempPattern = new ArrayList<Integer>();
    private int counter = 1;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Random rand = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.simon_view, container, false);
        one = (Button) view.findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                showColor(one, "#2dbceb", "#8cdaf4", 200);
                if (tempPattern.get(0) != 1) {
                    startOver();
                } else {
                    contGame();
                }
            }
        });

        two = (Button) view.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                showColor(two, "#f4ff1a", "#fcffc7", 200);
                if (tempPattern.get(0) != 2) {
                    startOver();
                } else {
                    contGame();
                }
            }
        });

        three = (Button) view.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                showColor(three, "#ac49d0", "#d19ae5", 200);
                if (tempPattern.get(0) != 3) {
                    startOver();
                } else {
                    contGame();
                }
            }
        });

        four = (Button) view.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                showColor(four, "#12d3c0", "#72f3e6", 200);
                if (tempPattern.get(0) != 4) {
                    startOver();
                } else {
                    contGame();
                }
            }
        });

        pattern = makePattern(counter);
        tempPattern = new ArrayList<Integer>(pattern);
        final Handler handler = new Handler();
        Toast.makeText(getActivity(), "Let's get started!",
                Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showPattern(pattern);
            }
        }, 1000);
        return view;
    }

    public ArrayList<Integer> makePattern(int count) {
        Log.d("T", "Making Pattern");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<count;i++ ) {
            int r = rand.nextInt(4) + 1;
            list.add(r);
        }
        return list;
    }

    public void showPattern(ArrayList<Integer> list) {
        Log.d("T", "Displaying pattern: " + list);
        final Handler handler = new Handler();
        for (int i = 1; i<=list.size();i++) {
            final int square = list.get(i-1);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (square == 1) {
                        showColor(one, "#2dbceb", "#8cdaf4", 500);
                    } else if (square == 2) {
                        showColor(two, "#f4ff1a", "#fcffc7", 500);
                    } else if (square == 3) {
                        showColor(three, "#ac49d0", "#d19ae5", 500);
                    } else {
                        showColor(four, "#12d3c0", "#72f3e6", 500);
                    }
                }
            }, 1000 * i);
        }
    }

    public void showColor(final Button b, String pressColor, final String normColor, int time) {
        Log.d("T", "Changing color");
        b.setBackgroundColor(Color.parseColor(pressColor));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                b.setBackgroundColor(Color.parseColor(normColor));
            }
        }, time);
    }

    public void startOver() {
        Toast.makeText(getActivity(), "Oops! Wrong pattern. Let's start over.",
                Toast.LENGTH_SHORT).show();
        counter = 1;
        pattern = makePattern(counter);
        tempPattern = new ArrayList<Integer>(pattern);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showPattern(pattern);
            }
        }, 1000);

    }

    public void contGame() {
        tempPattern.remove(0);
        if (tempPattern.size() == 0) {
            Log.d("T", "Adding to old pattern: " + pattern);
            pattern.add(rand.nextInt(4) + 1);
            Log.d("T", "Added: " + pattern);
            tempPattern = new ArrayList<Integer>(pattern);
            showPattern(pattern);
        }
    }
}