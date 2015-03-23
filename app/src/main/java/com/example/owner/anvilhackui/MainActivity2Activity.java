package com.example.owner.anvilhackui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_activity2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
    public void SwapLayout(View view){
        Intent act1 = new Intent(getApplicationContext(),MainActivity.class);
        String newString= getIntent().getStringExtra("tx");
        String newString2= getIntent().getStringExtra("tx2");
        String newString3= getIntent().getStringExtra("tx3");
        String newString4= getIntent().getStringExtra("tx4");
        String newString5= getIntent().getStringExtra("tx5");
        act1.putExtra("ArollOutput",newString);
        act1.putExtra("ArollOutput2",newString2);
        act1.putExtra("ArollOutput3",newString3);
        act1.putExtra("ArollOutput4",newString4);
        act1.putExtra("ArollOutput5",newString5);
        startActivity(act1);
    }


}
