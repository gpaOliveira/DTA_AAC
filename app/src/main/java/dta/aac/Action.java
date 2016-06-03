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
        ImageView image = (ImageView) rl.findViewById(R.id.img_row);
        image.setImageResource(this.imageHash);
        image.setContentDescription(this.name);
        TextView tvRow = (TextView) rl.findViewById(R.id.txt_row);
        tvRow.setText(this.name);
        image.setTag(this);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                activityContext.onActionClick(action, v);
            }
        });
        return rl;
    }

    public ImageButton renderImageButton(final AacActivity activityContext) {
        ImageButton imButton = new ImageButton(activityContext);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Data.getDPI(100, activityContext), Data.getDPI(100, activityContext));
        imButton.setLayoutParams(params);
        imButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imButton.setAdjustViewBounds(true);
        imButton.setImageResource(this.imageHash);
        imButton.setTag(this);
        imButton.setContentDescription(this.name);
        imButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action action = (Action) v.getTag();
                activityContext.onActionClick(action, v);
            }
        });
        return imButton;
    }

}
