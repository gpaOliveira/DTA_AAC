package dta.aac;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class Category {
    private String name;
    private int imageHash;
    private ArrayList<Action> actions;

    public Category(String name, int imageHash, ArrayList<Action> actions) {
        this.name = name;
        this.imageHash = imageHash;
        this.actions = actions;
    }

    public ArrayList<Action> getActions(){
        return actions;
    }

    public int getImageHash(){
        return imageHash;
    }

    public String getName(){
        return name;
    }

    public Button renderButton(final AacActivity activityContext){
        Button bt = new Button(activityContext);
        TableRow.LayoutParams params = new TableRow.LayoutParams(400, 200);
        params.setMargins(20, 20, 20, 20);
        bt.setLayoutParams(params);
        bt.setText(this.name);
        bt.setTag(this);
        bt.setGravity(Gravity.CENTER);
        bt.setPadding(20, 20, 20, 20);
        bt.setBackgroundColor(Color.DKGRAY);
        bt.setTextColor(Color.WHITE);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = (Category) v.getTag();
                activityContext.onCategoryClick(c, v);
            }
        });
        return bt;
    }

    public ImageButton renderImageButton(final AacActivity activityContext) {
        ImageButton button = new ImageButton(activityContext);
        button.setLayoutParams(new RelativeLayout.LayoutParams(Data.getDPI(100, activityContext), Data.getDPI(100, activityContext)));
        button.setScaleType(ImageView.ScaleType.FIT_CENTER);
        button.setAdjustViewBounds(true);
        button.setImageResource(imageHash);
        button.setTag(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = (Category) v.getTag();
                activityContext.onCategoryClick(c, v);
            }
        });
        return button;
    }

    public ImageButton renderImageButton(Context c, DisplayMetrics displayMetrics) {
        ImageButton button = new ImageButton(c);
        //button.setLayoutParams(new RelativeLayout.LayoutParams(Data.getDPI(100, displayMetrics), Data.getDPI(100, displayMetrics)));
        button.setScaleType(ImageView.ScaleType.FIT_CENTER);
        button.setAdjustViewBounds(true);
        button.setImageResource(imageHash);
        // button.setTag(this);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category c = (Category) v.getTag();
                activityContext.onCategoryClick(c, v);
            }
        });*/
        return button;
    }

}
