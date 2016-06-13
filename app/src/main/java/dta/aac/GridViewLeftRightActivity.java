package dta.aac;

import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GridViewLeftRightActivity extends AacActivity {

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_grid_view_left_right;
    }

    @Override
    protected String getLayoutTitleText(){
        return "Swipe Left and Right only";
    }

    @Override
    protected void renderCategories() {
        LinearLayout categories = (LinearLayout) categoriesView;
        categories.removeAllViews();
        for (Category c:data.getCategories()){
            categories.addView(c.renderImageButton(this));
        }
    }

    @Override
    protected void setAdapter(){
        HorizontalGridView horizontalGrid = (HorizontalGridView)findViewById(R.id.layout);
        horizontalGrid.setAdapter(adapter);
    }

    @Override
    protected void renderActions(Category c, ArrayList<Action> actions, int numberOfButtonsPerColumn) {
        currentActions.clear();
        currentActions.addAll(actions);
        adapter.notifyDataSetChanged();
    }

}
