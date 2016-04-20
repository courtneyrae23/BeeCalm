package wecare.beecalm;

/**
 * Created by fendyzhou on 4/17/16.
 */
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.woxthebox.draglistview.DragItemAdapter;

import java.util.ArrayList;

public class ItemAdapter extends DragItemAdapter<Pair<Long, String>, ItemAdapter.ViewHolder> {

    private int mLayoutId;
    private int mGrabHandleId;
    private ArrayList<ImageView> img_id = new ArrayList<>();

    public ItemAdapter(ArrayList<Pair<Long, String>> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
        super(dragOnLongPress);
        mLayoutId = layoutId;
        mGrabHandleId = grabHandleId;
        setHasStableIds(true);
        setItemList(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        final ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img_id.add(img);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String text = mItemList.get(position).second;
        holder.mText.setText(text);
        holder.itemView.setTag(text);
        if (mItemList.get(position).second == "Mantras") {
            img_id.get(2).setImageResource(R.mipmap.blackarrow);
            img_id.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MantraSettingsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        } else if (mItemList.get(position).second == "Yoga") {
            img_id.get(4).setImageResource(R.mipmap.blackarrow);
            img_id.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), YogaSettingActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } else if (mItemList.get(position).second == "Tapping Points") {
            img_id.get(5).setImageResource(R.mipmap.blackarrow);
            img_id.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), TappingPointsSettingActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }


    }

    @Override
    public long getItemId(int position) {
        return mItemList.get(position).first;
    }

    public class ViewHolder extends DragItemAdapter<Pair<Long, String>, ItemAdapter.ViewHolder>.ViewHolder {
        public TextView mText;

        public ViewHolder(final View itemView) {
            super(itemView, mGrabHandleId);
            mText = (TextView) itemView.findViewById(R.id.text);
        }
    }
}