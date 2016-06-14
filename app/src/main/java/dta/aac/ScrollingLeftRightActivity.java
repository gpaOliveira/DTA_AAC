package dta.aac;

import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ScrollingLeftRightActivity extends AacActivity{

    HorizontalGridView  actionsView = null;
    ArrayList<Action> _actions = null;

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_scrolling_left_right;
    }

    @Override
    protected String getLayoutTitleText(){
        return "Swipe Left and Right only";
    }

    @Override
    protected void localOnCreate(int numberOfButtonsPerColumn){
        actionsView = (HorizontalGridView)findViewById(R.id.gridview);
        Category c = data.getCategories().get(0);
        _actions  = c.getActions();
        actionsView.setAdapter(new ActionLeftRightAdapter(this, _actions , numberOfButtonsPerColumn));
    }

    @Override
    protected void renderCategories() {
        LinearLayout categories = (LinearLayout) categoriesView;
        categories.removeAllViews();
        System.gc();
        for (Category c:data.getCategories()){
            categories.addView(c.renderImageButton(this));
        }
    }

    @Override
    protected void renderActions(Category c, ArrayList<Action> actions, int numberOfButtonsPerColumn) {
        _actions.clear();
        System.gc();
        _actions.addAll(actions);
        System.gc();
        actionsView.getAdapter().notifyDataSetChanged();
        //ActionLeftRightAdapter op = new ActionLeftRightAdapter(this,actions,numberOfButtonsPerColumn);
        //op.notifyDataSetChanged();
    }
}
