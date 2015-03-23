package com.example.owner.anvilhackui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.owner.anvilhackui.R;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import java.util.UUID;



public class BTenable extends ActionBarActivity {
     private final static UUID PEBBLE_APP_UUID = UUID.fromString("20c769c4-5920-4e58-b1ad-4e47bd8a5fe0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btenable);
        //PebbleKit.startAppOnPebble(getApplicationContext(), PEBBLE_APP_UUID);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_btenable, menu);
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

    /* public void BTbuttpress(View view){
        //check if can talk to last pebble
        boolean connected = PebbleKit.isWatchConnected(getApplicationContext());
        if (connected) {
            String someTxt = "Connection Established";
            TextView tx = (TextView) findViewById(R.id.BTstatustxt);
            tx.setText(someTxt);

        } else {


        }
        // PebbleDictionary total = new PebbleDictionary();
    }
    */



}
