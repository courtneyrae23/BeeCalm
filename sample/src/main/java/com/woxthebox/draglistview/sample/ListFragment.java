/**
 * Copyright 2014 Magnus Woxblom
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.woxthebox.draglistview.sample;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItem;
import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayList<Pair<Long, String>> mItemArray;
    private DragListView mDragListView;
    private MySwipeRefreshLayout mRefreshLayout;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        mRefreshLayout = (MySwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mDragListView = (DragListView) view.findViewById(R.id.drag_list_view);
        mDragListView.getRecyclerView().setVerticalScrollBarEnabled(true);
        mItemArray = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
           switch(i) {
               case 0:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Breathing"));
                   break;
               case 1:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Mantras"));
                   break;
               case 2:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Simon Swipe"));
                   break;
               case 3:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Audio Coach"));
                   break;
               case 4:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Biofeedback"));
                   break;
               case 5:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Tapping"));
                   break;
               case 6:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Yoga"));
                   break;
               case 7:
                   mItemArray.add(new Pair<>(Long.valueOf(i), "Contact List"));
                   break;
            }
        }


        mRefreshLayout.setScrollingView(mDragListView.getRecyclerView());
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

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Settings");
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.menu_list, menu);
//    }
//
//    @Override
//    public void onPrepareOptionsMenu(Menu menu) {
//        super.onPrepareOptionsMenu(menu);
//        menu.findItem(R.id.action_disable_drag).setVisible(mDragListView.isDragEnabled());
//        menu.findItem(R.id.action_enable_drag).setVisible(!mDragListView.isDragEnabled());
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_disable_drag:
//                mDragListView.setDragEnabled(false);
//                getActivity().supportInvalidateOptionsMenu();
//                return true;
//            case R.id.action_enable_drag:
//                mDragListView.setDragEnabled(true);
//                getActivity().supportInvalidateOptionsMenu();
//                return true;
//            case R.id.action_list:
//                setupListRecyclerView();
//                return true;
//            case R.id.action_grid_vertical:
//                setupGridVerticalRecyclerView();
//                return true;
//            case R.id.action_grid_horizontal:
//                setupGridHorizontalRecyclerView();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void setupListRecyclerView() {
        mDragListView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemAdapter listAdapter = new ItemAdapter(mItemArray, R.layout.list_item, R.id.image, false);
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);
        mDragListView.setCustomDragItem(new MyDragItem(getContext(), R.layout.list_item));
    }

    private static class MyDragItem extends DragItem {

        public MyDragItem(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public void onBindDragView(View clickedView, View dragView) {
            CharSequence text = ((TextView) clickedView.findViewById(R.id.text)).getText();
            ((TextView) dragView.findViewById(R.id.text)).setText(text);
            dragView.setBackgroundColor(dragView.getResources().getColor(R.color.list_item_background));
        }
    }
}
