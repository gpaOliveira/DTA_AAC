package dta.aac;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ScrollingLeftRightActivity extends AacActivity{

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_scrolling_left_right;
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
    protected void renderActions(Category c, ArrayList<Action> actions, int numberOfButtonsPerColumn) {

        RelativeLayout data = (RelativeLayout) findViewById(R.id.tblAcoes);
        data.removeAllViews();
        int howManyColumnsAreNeeded = (int)Math.ceil(actions.size()/numberOfButtonsPerColumn) + 1;
        LinearLayout[] layouts = new LinearLayout[howManyColumnsAreNeeded];
        for(int i = 0; i < howManyColumnsAreNeeded; i++){
            layouts[i] = createColumn();
            appendToRelativeLayout(data, layouts[i]);
        }

        //populate layouts
        int action_index = 0, layout_index = 0;
        for (Action a : actions) {
            try {
                //add the button to the correct layout
                layouts[layout_index].addView(a.renderImageButton(this));
                action_index++;

                //reset data if needed
                if (action_index % numberOfButtonsPerColumn == 0) {
                    layout_index++;
                }
            }
            catch (Exception e){
                System.out.println("\nProblem detected on action " + a.getName() + ".\n" +
                                   "Category: " + c.getName() + "\n" +
                                   "Index: " + String.valueOf(action_index) + "\n" +
                                   "Layout: " + String.valueOf(layout_index) + "\n");
                throw e;
            }
        }
    }

    protected LinearLayout createColumn(){
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setId(View.generateViewId());
        return linearLayout;
    }

    protected void appendToRelativeLayout(RelativeLayout data, LinearLayout layout) {
        if (data.getChildCount() > 0) {
            int lastCreatedLinearLayoutId = data.getChildAt(data.getChildCount() - 1).getId();
            ((RelativeLayout.LayoutParams) layout.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, lastCreatedLinearLayoutId);
        }
        data.addView(layout);
    }

}
