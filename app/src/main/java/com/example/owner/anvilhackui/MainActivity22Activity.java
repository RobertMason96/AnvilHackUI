package com.example.owner.anvilhackui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;


public class MainActivity22Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity22);

        String text1 = getIntent().getStringExtra("macIn");
        TextView tx = (TextView) findViewById(R.id.textView6);
        tx.setText(text1);

        String text2 = getIntent().getStringExtra("macIn2");
        TextView tx2 = (TextView) findViewById(R.id.textView7);
        tx2.setText(text2);

        String text3 = getIntent().getStringExtra("macIn3");
        TextView tx3 = (TextView) findViewById(R.id.textView8);
        tx3.setText(text3);

        String text4 = getIntent().getStringExtra("macIn4");
        TextView tx4 = (TextView) findViewById(R.id.textView9);
        tx4.setText(text4);

        String text5 = getIntent().getStringExtra("macIn5");
        TextView tx5 = (TextView) findViewById(R.id.textView10);
        tx5.setText(text5);

        String text6 = getIntent().getStringExtra("macIn6");
        TextView tx6 = (TextView) findViewById(R.id.textView11);
        tx6.setText(text6);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity22, menu);
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
    public Integer macroSelected;
    public void SwapLayout(View view){
        Intent act1 = new Intent(getApplicationContext(),MainActivity.class);

        TextView tx = (TextView) findViewById(R.id.textView6);



        String newString= getIntent().getStringExtra("tx");

        String newString5= getIntent().getStringExtra("tx5");
        act1.putExtra("ArollOutput",newString);

        act1.putExtra("ArollOutput5",newString5);

        String rollOutput = tx.getText().toString();
        act1.putExtra("mac",rollOutput);
        TextView tx2 = (TextView) findViewById(R.id.textView7);
        String rollOutput2 = tx2.getText().toString();
        act1.putExtra("mac2",rollOutput2);
        TextView tx3 = (TextView) findViewById(R.id.textView8);
        String rollOutput3 = tx3.getText().toString();
        act1.putExtra("mac3",rollOutput3);
        TextView tx4 = (TextView) findViewById(R.id.textView9);
        String rollOutput4 = tx4.getText().toString();
        act1.putExtra("mac4",rollOutput4);
        TextView tx5 = (TextView) findViewById(R.id.textView10);
        String rollOutput5 = tx5.getText().toString();
        act1.putExtra("mac5",rollOutput5);
        TextView tx6 = (TextView) findViewById(R.id.textView11);
        String rollOutput6 = tx6.getText().toString();
        act1.putExtra("mac6",rollOutput6);
        startActivity(act1);
    }
    public void UseMacro(View view){

            Intent act1 = new Intent(getApplicationContext(),MainActivity.class);





            String newString= getIntent().getStringExtra("tx");

            String newString5 = "NaaN";
            act1.putExtra("ArollOutput",newString);



            if (macroSelected == 1){
                TextView tx = (TextView) findViewById(R.id.textView7);
                newString5= tx.getText().toString();
            }
            else if (macroSelected==2){
                TextView tx = (TextView) findViewById(R.id.textView9);
                newString5= tx.getText().toString();
            }
            else if(macroSelected==3){
                TextView tx = (TextView) findViewById(R.id.textView11);
                newString5= tx.getText().toString();
            }
            act1.putExtra("ArollOutput5",newString5);
            TextView tx = (TextView) findViewById(R.id.textView6);
            String rollOutput = tx.getText().toString();
            act1.putExtra("mac",rollOutput);
            TextView tx2 = (TextView) findViewById(R.id.textView7);
            String rollOutput2 = tx2.getText().toString();
            act1.putExtra("mac2",rollOutput2);
            TextView tx3 = (TextView) findViewById(R.id.textView8);
            String rollOutput3 = tx3.getText().toString();
            act1.putExtra("mac3",rollOutput3);
            TextView tx4 = (TextView) findViewById(R.id.textView9);
            String rollOutput4 = tx4.getText().toString();
            act1.putExtra("mac4",rollOutput4);
            TextView tx5 = (TextView) findViewById(R.id.textView10);
            String rollOutput5 = tx5.getText().toString();
            act1.putExtra("mac5",rollOutput5);
            TextView tx6 = (TextView) findViewById(R.id.textView11);
            String rollOutput6 = tx6.getText().toString();
            act1.putExtra("mac6",rollOutput6);
            startActivity(act1);


    }
    public void Macro1Func(View view){
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        EditText editMacro = (EditText) findViewById(R.id.editMacro);
        Button commitBtn = (Button) findViewById(R.id.commitBtn);
        Button useBtn = (Button) findViewById(R.id.useBtn);
        editTitle.setVisibility(View.VISIBLE);
        editMacro.setVisibility(View.VISIBLE);
        commitBtn.setVisibility(View.VISIBLE);
        TextView tx = (TextView) findViewById(R.id.textView6);
        if (tx.getText() != "") {
            useBtn.setVisibility(View.VISIBLE);
        }
        macroSelected = 1;
    }

    public void Macro2Func(View view){
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        EditText editMacro = (EditText) findViewById(R.id.editMacro);
        Button commitBtn = (Button) findViewById(R.id.commitBtn);
        Button useBtn = (Button) findViewById(R.id.useBtn);
        editTitle.setVisibility(View.VISIBLE);
        editMacro.setVisibility(View.VISIBLE);
        commitBtn.setVisibility(View.VISIBLE);
        TextView tx = (TextView) findViewById(R.id.textView8);
        if (tx.getText() != "") {
            useBtn.setVisibility(View.VISIBLE);
        }
        macroSelected = 2;
    }

    public void Macro3Func(View view){
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        EditText editMacro = (EditText) findViewById(R.id.editMacro);
        Button commitBtn = (Button) findViewById(R.id.commitBtn);
        Button useBtn = (Button) findViewById(R.id.useBtn);
        editTitle.setVisibility(View.VISIBLE);
        editMacro.setVisibility(View.VISIBLE);
        commitBtn.setVisibility(View.VISIBLE);
        TextView tx = (TextView) findViewById(R.id.textView10);
        if (tx.getText() != "") {
            useBtn.setVisibility(View.VISIBLE);
        }
        macroSelected = 3;
    }

    public void CommitMacro(View view){
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        EditText editMacro = (EditText) findViewById(R.id.editMacro);
        String Title = editTitle.getText().toString();
        String Macro = editMacro.getText().toString();
        if (macroSelected == 1){
            TextView tx = (TextView) findViewById(R.id.textView6);
            TextView tx2 = (TextView) findViewById(R.id.textView7);
            tx.setText(Title);
            tx2.setText(Macro);
            //File file = new File(context.getFilesDir(), "Macros");
        }
        else if (macroSelected==2){
            TextView tx = (TextView) findViewById(R.id.textView8);
            TextView tx2 = (TextView) findViewById(R.id.textView9);
            tx.setText(Title);
            tx2.setText(Macro);
        }
        else if (macroSelected==3){
            TextView tx = (TextView) findViewById(R.id.textView10);
            TextView tx2 = (TextView) findViewById(R.id.textView11);
            tx.setText(Title);
            tx2.setText(Macro);
        }
    }
}
