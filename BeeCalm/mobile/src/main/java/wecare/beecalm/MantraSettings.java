package wecare.beecalm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.woxthebox.draglistview.DragItem;
import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class MantraSettings extends Fragment {

    private ArrayList<Pair<Long, String>> mItemArray;
    private DragListView mDragListView;
    private MantraSettingsSwipeRefreshLayout mRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mantra_setting_view, container, false);
        mRefreshLayout = (MantraSettingsSwipeRefreshLayout) view.findViewById(R.id.mantra_setting_swipe_refresh_layout);
        mDragListView = (DragListView) view.findViewById(R.id.mantra_setting_drag_list_view);
        mDragListView.getRecyclerView().setVerticalScrollBarEnabled(true);
        mItemArray = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            switch(i) {
                case 0:
                    mItemArray.add(new Pair<>(Long.valueOf(i), "Ride this wave."));
                    break;
                case 1:
                    mItemArray.add(new Pair<>(Long.valueOf(i), "This too, will pass."));
                    break;
                case 2:
                    mItemArray.add(new Pair<>(Long.valueOf(i), "It's okay to feel anxious."));
                    break;
                case 3:
                    mItemArray.add(new Pair<>(Long.valueOf(i), "Don't let a bad day scare..."));
                    break;
                case 4:
                    mItemArray.add(new Pair<>(Long.valueOf(i), "Add Mantra"));
                    break;
            }
        }


        mRefreshLayout.setMantraScrollingView(mDragListView.getRecyclerView());
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.app_color));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        setupListRecyclerView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Mantra Settings");
    }

    private void setupListRecyclerView() {
        mDragListView.setLayoutManager(new LinearLayoutManager(getContext()));
        MantraSettings_ItemAdapter listAdapter = new MantraSettings_ItemAdapter(mItemArray, R.layout.mantra_setting_item, R.id.image, false);
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setCustomDragItem(new MyDragItem(getContext(), R.layout.mantra_setting_item));
    }

    private static class MyDragItem extends DragItem {

        public MyDragItem(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public void onBindDragView(View clickedView, View dragView) {
            CharSequence text = ((TextView) clickedView.findViewById(R.id.text)).getText();
            CharSequence drag = ((TextView) dragView.findViewById(R.id.text)).getText();
            ((TextView) dragView.findViewById(R.id.text)).setText(text);
            ImageView img = (ImageView) dragView.findViewById(R.id.imageView);
            ImageView img_icon = (ImageView) dragView.findViewById(R.id.image);
            if (text == "Ride this wave.") {
                img.setImageResource(R.mipmap.arrow_right);
                img .setVisibility(View.VISIBLE);
                img_icon.setImageResource(R.mipmap.dragdrop);
            } else if (text == "This too, will pass.") {
                img.setImageResource(R.mipmap.arrow_right);
                img_icon.setImageResource(R.mipmap.dragdrop);
                img.setVisibility(View.VISIBLE);
            } else if (text == "It's okay to feel anxious.") {
                img.setImageResource(R.mipmap.arrow_right);
                img_icon.setImageResource(R.mipmap.dragdrop);
                img.setVisibility(View.VISIBLE);
            } else if (text == "Don't let a bad day scare...") {
                img.setImageResource(R.mipmap.arrow_right);
                img.setVisibility(View.VISIBLE);
                img_icon.setImageResource(R.mipmap.dragdrop);
            } else {
                img_icon.setImageResource(R.mipmap.plus_icon);
                img.setVisibility(View.GONE);
            }
            dragView.setBackgroundColor(dragView.getResources().getColor(R.color.list_item_background));
        }
    }

}

class MantraSettingsSwipeRefreshLayout extends SwipeRefreshLayout {
    private View mScrollingView;

    public MantraSettingsSwipeRefreshLayout(Context context) {
        super(context);
    }

    public MantraSettingsSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canChildScrollUp() {
        return mScrollingView != null;
    }

    public void setMantraScrollingView(View scrollingView) {
        mScrollingView = scrollingView;
    }
}