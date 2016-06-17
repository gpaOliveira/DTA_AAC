package dta.aac;

import android.widget.GridView;
import android.widget.TableRow;

import java.util.ArrayList;

public class ScrollingUpDownActivity extends AacActivity {

    GridView actionsView = null;

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_scrolling_up_down;
    }

    @Override
    protected String getLayoutTitleText(){
        return "Left/Right and Up/Down";
    }

    @Override
    protected void localOnCreate(int numberOfButtonsPerColumn){
        actionsView = (GridView)findViewById(R.id.gridview);
        actionsView.setAdapter(new ActionUpDownAdapter(this, new ArrayList<Action>(), ActionUpDownAdapter.ScrollingWay.VERTICAL));
    }

    @Override
    protected void renderCategories() {
        TableRow internaltblRow = (TableRow) categoriesView;
        internaltblRow.removeAllViews();
        System.gc();
        for (Category c:data.getCategories()){
            internaltblRow.addView(c.renderButton(this));
        }
    }

    @Override
    protected void renderActions(Category c, ArrayList<Action> actions, int numberOfButtonsPerColumn) {
        ActionUpDownAdapter op = new ActionUpDownAdapter(this, actions, ActionUpDownAdapter.ScrollingWay.VERTICAL);
        op.notifyDataSetChanged();
        System.gc();
        actionsView.setAdapter(op);
    }
}
