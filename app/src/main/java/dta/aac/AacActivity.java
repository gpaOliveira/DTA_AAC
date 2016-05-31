package dta.aac;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public abstract class AacActivity  extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    //Stop complaining about NullPointers !
    ImageButton btnShare = null;
    TextView tvAction = null;
    View categoriesView = null;
    View actionsView = null;
    TextToSpeech tts;
    int MY_DATA_CHECK_CODE = 0x1204;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutResourceId());
        getSupportActionBar().setTitle(this.getLayoutTitleText());
        btnShare = (ImageButton) findViewById(R.id.btn_share);
        tvAction = (TextView) findViewById(R.id.txtBuffer);
        categoriesView = findViewById(R.id.tblCategorias);
        actionsView = findViewById(R.id.tblAcoes);

        //tts control
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

        //populate categories and load the actions of the first one
        this.renderCategories();
        Category c = Data.getInstance().getCategories().get(0);
        renderActions(c, c.getActions());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                tts = new TextToSpeech(this, this);
                tts.setLanguage(Locale.US);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
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
    public void onListenClick(View v){
        String text = tvAction.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    protected void onDestroy() {
        if (tts!=null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int speechStatus) {

    }

    protected abstract int getLayoutResourceId();
    protected abstract String getLayoutTitleText();
    protected abstract void renderCategories();
    protected abstract void renderActions(Category c, ArrayList<Action> actions);
}
