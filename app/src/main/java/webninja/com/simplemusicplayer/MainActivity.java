/*
    Author: Keith Levi Lumanog <keith@webninjamobile.com>

    Feel free to use this software at your own risk
    Challenge for everyone:
    1. add 5th item called album cover and display it in the playactivity as an image
    2. add controls like stop and rewind

 */

package webninja.com.simplemusicplayer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<ListItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<ListItem>();


        data.add( new ListItem("Murmer", "Chamomile","murmer","http://myspace.com/chamomile"));
        data.add( new ListItem("Bughici - Suite for Violin,", "Advent Chamber Orchestra","bughici","http://freemusicarchive.org/music/Advent_Chamber_Orchestra/Selections_from_the_November_2006_Concert/Advent_Chamber_Orchestra_-_08_-_Bughici_-_Suite_for_Violin_8_Ardeleneasca_moderato"));
        data.add( new ListItem("The Hug", "The Freak Fandango Orchestra","hug","http://www.freakfandango.es/"));
        data.add( new ListItem("Cadaver", "Chastity Belt","cadaver","http://chastity-belt.bandcamp.com/"));

        ListView lv = (ListView) findViewById(R.id.musiclist);
        lv.setAdapter(new ArrayAdapter<ListItem>(this, R.layout.list, R.id.title, data));

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView< ?> parent, View view, int position, long id) {
                Log.d("musicplayer",String.valueOf(position));
                Log.d("musicplayer",data.get(position).file);

                Intent i = new Intent(MainActivity.this, PlayActivity.class);
                i.putExtra("name",data.get(position).title );
                i.putExtra("file", data.get(position).file);
                i.putExtra("attr", data.get(position).attr);

                startActivity(i);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
