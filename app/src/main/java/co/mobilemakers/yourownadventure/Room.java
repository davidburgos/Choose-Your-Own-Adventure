package co.mobilemakers.yourownadventure;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import java.util.Random;


public class Room extends ActionBarActivity {

    final static String WIN_MESSAGE = "You've reached the Gold!";
    final static String LOOSE_MESSAGE = "You've fallen into the pit of despair";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Button btnDoor_1 = (Button)findViewById(R.id.btn_door_1);
        Button btnDoor_2 = (Button)findViewById(R.id.btn_door_2);

    }

    public void OnClickButtons(View v){

        Random rn = new Random();

        if(rn.nextBoolean())
        {
            if(rn.nextBoolean()){
                Intent Room_intent = new Intent(Room.this, Room.class);
                startActivity(Room_intent);
            }else{
                Intent Alley_intent = new Intent(Room.this, Alley.class);
                startActivity(Alley_intent);
            }
        }else{
            Intent GameOverScreen = new Intent(Room.this, GameOver.class);

            if(rn.nextBoolean()){
                GameOverScreen.putExtra(Intent.EXTRA_TEXT, LOOSE_MESSAGE);
            }else{
                GameOverScreen.putExtra(Intent.EXTRA_TEXT, WIN_MESSAGE);
            }

            startActivity(GameOverScreen);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_room, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_room, container, false);
            return rootView;
        }
    }
}
