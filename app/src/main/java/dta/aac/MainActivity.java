package dta.aac;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageButton;
import android.util.TypedValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    static final Map<String, Integer> IMAGES_FROM_STR = Collections.unmodifiableMap(new HashMap<String, Integer>() {
        {
            put("x", R.drawable.x);
            put("bandera", R.drawable.bandera);
            put("barco_1", R.drawable.barco_1);
            put("banar", R.drawable.banar);
            put("ic_Launcher", R.drawable.ic_launcher);
            put("banos_2", R.drawable.banos_2);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateCategories();
        populateDataWithCategory("x");//just default one...shall we remove it ?
    }

    protected void populateCategories(){
        //yeah, someday we WILL read it from somewhere else, someday
        String[] images = new String[]{"x", "bandera", "barco_1", "banar", "ic_Launcher","banos_2"};

        LinearLayout categories = (LinearLayout)findViewById(R.id.categories);
        categories.removeAllViews();

        for (String image : images) {
            ImageButton button = createDataButton(image);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageButton button = (ImageButton) v;
                    populateDataWithCategory((String)button.getTag());
                }
            });
            categories.addView(button);
        }
    }

    protected void populateDataWithCategory(String categoryImage){
        RelativeLayout data = (RelativeLayout)findViewById(R.id.data);
        data.removeAllViews();

        int numberOfColumns = 4;//may it be received as a parameter someday or we will read it from somewhere else?
        int numberOfButtonsPerColumn = 3;//may it be received as a parameter someday or we will read it from somewhere else?
        for (int c = 0; c < numberOfColumns; c++){
            LinearLayout linearLayout = this.createColumn();
            for (int b = 0; b < numberOfButtonsPerColumn; b++){
                ImageButton button = createDataButton(categoryImage);//in the future, we may want to read it from somewhere else
                linearLayout.addView(button);
            }
            appendToRelativeLayout(data, linearLayout);
        }
    }

    protected void appendToRelativeLayout(RelativeLayout data, LinearLayout layout){
        if (data.getChildCount() > 0){
            int lastCreatedLinearLayoutId = data.getChildAt(data.getChildCount() - 1).getId();
            ((RelativeLayout.LayoutParams)layout.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, lastCreatedLinearLayoutId );
        }
        data.addView(layout);
    }

    protected LinearLayout createColumn(){
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setId(View.generateViewId());
        return linearLayout;
    }

    protected ImageButton createDataButton(String categoryImage){
        ImageButton button = new ImageButton(this);
        button.setLayoutParams(new RelativeLayout.LayoutParams(getDPI(100), getDPI(100)));
        button.setScaleType(ImageView.ScaleType.FIT_CENTER);
        button.setAdjustViewBounds(true);
        button.setImageResource(IMAGES_FROM_STR.get(categoryImage));
        button.setTag(categoryImage);
        button.setId(View.generateViewId());
        return button;
    }

    protected int getDPI(int n){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, getResources().getDisplayMetrics());
    }
}
