package dta.aac;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Console;

public class Action {
    private int imageHash;
    private String name;

    public Action(int imageHash, String name) {
        this.imageHash = imageHash;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return imageHash;
    }

    public RelativeLayout renderVertical(final AacActivity context) throws NullPointerException{
        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.action_vertical_row, null);
        rl.setFocusable(false);
        ImageView image = (ImageView) rl.findViewById(R.id.img_row);
        Log.d(this.getName(),this.getName());
        image.setImageResource(this.imageHash);
        image.setContentDescription(this.name);
        TextView tvRow = (TextView) rl.findViewById(R.id.txt_row);
        tvRow.setText(this.name);
        image.setTag(this);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                context.onActionClick(action, v);
            }
        });
        return rl;
    }

    public RelativeLayout renderHorizontal(final AacActivity context) throws NullPointerException{
        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.action_horizontal, null);
        rl.setFocusable(false);
        ImageView image = (ImageView) rl.findViewById(R.id.img_row);
        Log.d(this.getName(),this.getName());
        image.setImageResource(this.imageHash);
        image.setContentDescription(this.name);
        image.setTag(this);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                context.onActionClick(action, v);
            }
        });
        return rl;
    }

}
