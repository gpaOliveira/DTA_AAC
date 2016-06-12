package dta.aac;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ActionHolder> {

    ArrayList<Action> actions;
    AacActivity activityContext;
    int howManyColumns;

    public ActionAdapter(AacActivity activityContext, ArrayList<Action> actions, int howManyColumnsAreNeeded){
        this.activityContext = activityContext;
        this.actions = actions;
        this.howManyColumns = howManyColumnsAreNeeded;
    }

    @Override
    public ActionHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.action_horizontal, viewGroup, false);

        return new ActionHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ActionHolder holder, int i) {
        holder.setAction(activityContext, actions.get(i), 0);
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }

    public class ActionHolder extends RecyclerView.ViewHolder {

        ImageButton[] buttons;

        public ActionHolder(View v){
            super(v);
            buttons = new ImageButton[]{
                    (ImageButton) v.findViewById(R.id.action_image_0)
            };
        }

        public void setAction(final AacActivity activityContext, Action a, int index){
            if (index >= 1) throw new ArrayIndexOutOfBoundsException(index);
            buttons[index].setImageResource(a.getImage());
            buttons[index].setTag(a);
            buttons[index].setContentDescription(a.getName());
            buttons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Action action = (Action) v.getTag();
                    activityContext.onActionClick(action, v);
                }
            });
        }
    }
}
