package dta.aac;

import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class ScrollingUpDownActivity extends AacActivity {

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_scrolling_up_down;
    }

    @Override
    protected String getLayoutTitleText(){
        return "Swipe Left/Right on categories and Up/Down on actions";
    }

    @Override
    protected void renderCategories() {
        TableRow internaltblRow = (TableRow) categoriesView;
        internaltblRow.removeAllViews();
        for (Category c:Data.getInstance().getCategories()){
            internaltblRow.addView(c.renderButton(this));
        }
    }

    @Override
    protected void renderActions(Category c, ArrayList<Action> actions) {
        TableLayout internal_tblActions  = (TableLayout) actionsView;
        internal_tblActions.removeAllViews();
        int i = 0;
        TableRow tr = null;
        for (Action a : actions) {
            tr = useOrReuseTblRow(internal_tblActions, tr, i);
            tr.addView(a.render(this));
            i++;
        }
        internal_tblActions.addView(tr);
    }

    private TableRow useOrReuseTblRow(TableLayout tblActions, TableRow tr, int i){
        int numberOfButtonsPerColumn = 3;//may it be received as a parameter someday or we will read it from somewhere else?
        if (i % numberOfButtonsPerColumn == 0) {
            if (i != 0) {
                tblActions.addView(tr);
            }
            tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        }
        return tr;
    }

    @Override
    public void onInit(int status) {

    }
}
