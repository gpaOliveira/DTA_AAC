package dta.aac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eduardo on 12/06/2016.
 */
public class GridLayoutActivity extends AacActivity {

    ImageButton btnShare;
    TextView tvAction;
    LinearLayout categories = null;
    GridView actionsView = null;
    int MY_DATA_CHECK_CODE = 0x1204;
    int NUMBER_OF_BUTTONS_PER_COLUMN = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().setTitle(this.getLayoutTitleText());
        tvAction = (TextView) findViewById(R.id.txtBuffer);
        btnShare = (ImageButton) findViewById(R.id.btn_share);
        categories = (LinearLayout) findViewById(R.id.tblCategorias);
        actionsView = (GridView)findViewById(R.id.gridview);
        data = new Data(this);
        //tts control
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

        //populate categories and load the actions of the first one

        Category c = data.getCategories().get(0);
        //renderActions(c, c.getActions(), NUMBER_OF_BUTTONS_PER_COLUMN);
        actionsView.setAdapter(new OptionsAdapter(this,c.getActions()));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.layout_gridview;
    }

    @Override
    protected String getLayoutTitleText() {
        return "";
    }

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

        OptionsAdapter op = new OptionsAdapter(this, actions);
        op.notifyDataSetChanged();
        actionsView.setAdapter(op);


    }

    private TableRow useOrReuseTblRow(TableLayout tblActions, TableRow tr, int i, int numberOfButtonsPerColumn){
        /*if (i % numberOfButtonsPerColumn == 0) {
            if (i != 0) {
                tblActions.addView(tr);
            }
            tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        }
        return tr;*/
        return null;
    }
}
