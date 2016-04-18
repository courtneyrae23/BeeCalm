package wecare.beecalm;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
/**
 * Created by fendyzhou on 4/17/16.
 */
public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    private View mScrollingView;

    public MySwipeRefreshLayout(Context context) {
        super(context);
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canChildScrollUp() {
        return mScrollingView != null;
    }

    public void setScrollingView(View scrollingView) {
        mScrollingView = scrollingView;
    }
}