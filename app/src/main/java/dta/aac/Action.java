package dta.aac;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    public RelativeLayout render(final AacActivity activityContext) throws NullPointerException{
        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(activityContext).inflate(R.layout.action_vertical_row, null);
        rl.setFocusable(false);
        ImageView ivRow = (ImageView) rl.findViewById(R.id.img_row);
        ivRow.setContentDescription(this.name);
        TextView tvRow = (TextView) rl.findViewById(R.id.txt_row);
        tvRow.setText(this.name);
        ivRow.setTag(this);
        ivRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                activityContext.onActionClick(action, v);
            }
        });
        return rl;
    }

    public ImageButton renderImageButton(final AacActivity activityContext, int categoryImageHash) {
        ImageButton button = new ImageButton(activityContext);
        button.setLayoutParams(new RelativeLayout.LayoutParams(Data.getDPI(100, activityContext), Data.getDPI(100, activityContext)));
        button.setScaleType(ImageView.ScaleType.FIT_CENTER);
        button.setAdjustViewBounds(true);
        button.setImageResource(this.imageHash);
        button.setTag(this);
        button.setContentDescription(this.name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                activityContext.onActionClick(action, v);
            }
        });
        return button;
    }

}
