package webninja.com.simplemusicplayer;

import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;


public class PlayActivity extends ActionBarActivity {
    MediaPlayer myMediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle( getIntent().getStringExtra("name"));

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("attr"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);


    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            myMediaPlayer.start();
        } else {
            myMediaPlayer.pause();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        stopMusic();
    }

    @Override
    public void onResume() {
        super.onResume();
        String file   = getIntent().getStringExtra("file");
        myMediaPlayer = MediaPlayer.create(PlayActivity.this, getResources().getIdentifier(file, "raw","webninja.com.simplemusicplayer"));
        ToggleButton  tglbtn = (ToggleButton)findViewById(R.id.togglebutton);
        tglbtn.setChecked(false);
    }

    private void stopMusic(){
        if(myMediaPlayer.isPlaying()){
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }

    }


}
