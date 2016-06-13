package dta.aac;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ActionHolder> {

    ArrayList<Action> actions;
    AacActivity activityContext;
    int rowsPerColumn;

    public ActionAdapter(AacActivity activityContext, ArrayList<Action> actions, int rowsPerColumn){
        this.activityContext = activityContext;
        this.actions = actions;
        this.rowsPerColumn = rowsPerColumn;
    }

    @Override
    public ActionHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.action_horizontal, viewGroup, false);

        return new ActionHolder(activityContext, itemView, rowsPerColumn);
    }

    @Override
    public void onBindViewHolder(ActionHolder holder, int i) {
        int index = i * rowsPerColumn;
        int increment = 0;
        while (increment < rowsPerColumn && index < actions.size()) {
            holder.setAction(activityContext, actions.get(index), increment);
            increment++;
            index++;
        }
    }

    @Override
    public int getItemCount() {
        //return actions.size();
        return (int)Math.ceil(actions.size()/rowsPerColumn) + 1;
    }

    public class ActionHolder extends RecyclerView.ViewHolder {

        ArrayList<ImageButton> buttons;

        public ActionHolder(AacActivity activityContext, View v, int rowsPerColumn){
            super(v);
            buttons = new ArrayList<ImageButton>(rowsPerColumn);
            for(int i = 0; i < rowsPerColumn; i++) {
                buttons.add(getImageButtonFromString(activityContext, v, "action_image_" + String.valueOf(i)));
            }
        }

        private ImageButton getImageButtonFromString(AacActivity activityContext, View v, String s){
            return (ImageButton) v.findViewById(activityContext.getResources().getIdentifier(s, "id", activityContext.getPackageName()));
        }

        public void setAction(final AacActivity activityContext, Action a, int index){
            if (index <= buttons.size()) {
                buttons.get(index).setImageResource(a.getImage());
                buttons.get(index).setTag(a);
                buttons.get(index).setContentDescription(a.getName());
                buttons.get(index).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Action action = (Action) v.getTag();
                        activityContext.onActionClick(action, v);
                    }
                });
            }
        }
    }
}
