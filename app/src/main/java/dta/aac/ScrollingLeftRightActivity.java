package dta.aac;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

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
        for (Category c:Data.getInstance().getCategories()){
            categories.addView(c.renderImageButton(this));
        }
    }

    @Override
    protected void renderActions(Category c, ArrayList<Action> actions) {
        RelativeLayout data = (RelativeLayout) actionsView;
        data.removeAllViews();
        int i = 0;
        LinearLayout ll = null;
        for (Action a : actions) {
            ll = useOrReuseLinearLayout(data, ll, i);
            ll.addView(a.renderImageButton(this, c.getImageHash()));
            i++;
        }
        data.addView(ll);
    }

    private LinearLayout useOrReuseLinearLayout(RelativeLayout data, LinearLayout ll, int i){
        int numberOfButtonsPerColumn = 2;//may it be received as a parameter someday or we will read it from somewhere else?
        LinearLayout myll = ll;
        if (i % numberOfButtonsPerColumn == 0) {

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (ll != null) {
                data.addView(ll);
                params.addRule(RelativeLayout.RIGHT_OF, ll.getId());
                params.addRule(RelativeLayout.END_OF, ll.getId());
            }

            myll = new LinearLayout(this);
            myll.setOrientation(LinearLayout.VERTICAL);
            myll.setLayoutParams(params);
        }
        return myll;
    }

}
