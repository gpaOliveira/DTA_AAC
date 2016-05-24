package dta.aac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class AacActivity  extends AppCompatActivity {

    //Stop complaining about NullPointers !
    ImageButton btnShare = null;
    TextView tvAction = null;
    View categoriesView = null;
    View actionsView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());
        getSupportActionBar().setTitle(this.getLayoutTitleText());
        btnShare = (ImageButton) findViewById(R.id.btn_share);
        tvAction = (TextView) findViewById(R.id.txtBuffer);
        categoriesView = findViewById(R.id.tblCategorias);
        actionsView = findViewById(R.id.tblAcoes);
        this.renderCategories();
    }

    public void onActionClick(Action a, View v){
        tvAction.setText(tvAction.getText() + " " + a.getName());
    }

    public void onCategoryClick(Category c, View v){
        renderActions(c, c.getActions());
    }

    public void onShareClick(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = tvAction.getText().toString();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    protected abstract int getLayoutResourceId();
    protected abstract String getLayoutTitleText();
    protected abstract void renderCategories();
    protected abstract void renderActions(Category c, ArrayList<Action> actions);
}
