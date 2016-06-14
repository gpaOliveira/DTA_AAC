package dta.aac;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by oliveiga on 6/14/2016.
 */
public class ActionLeftRightAdapter extends RecyclerView.Adapter<ActionLeftRightAdapter.ActionHolder> {
    ArrayList<Action> _actions;
    AacActivity _context;
    int _count;

    // Constructor
    public ActionLeftRightAdapter(AacActivity ctx, ArrayList<Action> actions, int numberOfButtonsPerColumn) {
        _actions = actions;
        _context =ctx;
        _count = numberOfButtonsPerColumn;
    }

    @Override
    public ActionLeftRightAdapter.ActionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_horizontal, parent, false);

        return new ActionHolder(itemView, _context, _count);
    }

    @Override
    public void onBindViewHolder(ActionHolder holder, int position) {
        int index = position * 3;
        if (index < _actions.size()) {
            holder.setAction(_actions.get(index), 0);
        }
        index++;
        if (index < _actions.size()) {
            holder.setAction(_actions.get(index), 1);
        }
        index++;
        if (index < _actions.size()) {
            holder.setAction(_actions.get(index), 2);
        }
    }


    @Override
    public int getItemCount() {
        return (int) Math.ceil(_actions.size() / _count) + 1;
    }

    public class ActionHolder extends RecyclerView.ViewHolder {
        ArrayList<ImageView> images;
        AacActivity _context;
        int _count;

        public ActionHolder(View v, AacActivity ctx, int count){
            super(v);
            _count = count;
            _context = ctx;
            images = new ArrayList<ImageView>();
            for(int i = 0; i < _count; i++) {
                images.add(getImageViewFromString(v, "img_row_" + String.valueOf(i)));
            }
        }

        private ImageView getImageViewFromString(View v, String s){
            return (ImageView) v.findViewById(_context.getResources().getIdentifier(s, "id", _context.getPackageName()));
        }

        public void setAction(final Action a, int index){
            images.get(index).setImageResource(a.getImage());
            images.get(index).setContentDescription(a.getName());
            images.get(index).setTag(_context);
            images.get(index).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AacActivity activity = (AacActivity) v.getTag();
                    activity.onActionClick(a , v);
                }
            });
        }

    }
}
