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
            img_id.get(1).setImageResource(R.mipmap.arrow_right);
//            img_id.get(1).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), SideBarActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else if (mItemList.get(position).second == "Audio Coach") {
            img_id.get(3).setImageResource(R.mipmap.arrow_right);
//            img_id.get(3).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), MantrasActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else if (mItemList.get(position).second == "Contact List") {
            img_id.get(7).setImageResource(R.mipmap.arrow_right);
//            img_id.get(7).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), MantrasActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
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