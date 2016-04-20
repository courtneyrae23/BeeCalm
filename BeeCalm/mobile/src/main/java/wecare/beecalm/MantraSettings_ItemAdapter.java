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

public class MantraSettings_ItemAdapter extends DragItemAdapter<Pair<Long, String>, MantraSettings_ItemAdapter.ViewHolder> {

    private int mLayoutId;
    private int mGrabHandleId;
    private ArrayList<ImageView> img_id = new ArrayList<>();
    private ImageView img_icon;
//    private TextView add_mantra;

    public MantraSettings_ItemAdapter(ArrayList<Pair<Long, String>> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
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
        img_icon = (ImageView) view.findViewById((R.id.image));
//        add_mantra = (TextView) view.findViewById((R.id.text));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String text = mItemList.get(position).second;
        holder.mText.setText(text);
        holder.itemView.setTag(text);
        if (mItemList.get(position).second == "Ride this wave.") {
            img_id.get(0).setImageResource(R.mipmap.blackarrow);
//            img_id.get(1).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), SideBarActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else if (mItemList.get(position).second == "This too, will pass.") {
            img_id.get(1).setImageResource(R.mipmap.blackarrow);
//            img_id.get(7).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), MantrasActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else if (mItemList.get(position).second == "It's okay to feel anxious.") {
            img_id.get(2).setImageResource(R.mipmap.blackarrow);
//            img_id.get(7).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), MantrasActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else if (mItemList.get(position).second == "Don't let a bad day scare...") {
            img_id.get(3).setImageResource(R.mipmap.blackarrow);
//            img_id.get(7).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), MantrasActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        } else {
            img_icon.setImageResource(R.mipmap.plussign);
//            add_mantra.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), SideBarActivity.class);
//                    v.getContext().startActivity(intent);
//                }
//            });
        }


    }

    @Override
    public long getItemId(int position) {
        return mItemList.get(position).first;
    }

    public class ViewHolder extends DragItemAdapter<Pair<Long, String>, MantraSettings_ItemAdapter.ViewHolder>.ViewHolder {
        public TextView mText;

        public ViewHolder(final View itemView) {
            super(itemView, mGrabHandleId);
            mText = (TextView) itemView.findViewById(R.id.text);
        }
    }
}