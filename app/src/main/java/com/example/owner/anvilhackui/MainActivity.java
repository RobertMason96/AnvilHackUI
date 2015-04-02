package com.example.owner.anvilhackui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.owner.anvilhackui.R;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;


import java.nio.charset.CharacterCodingException;
import java.util.*;

//GNU Terry Pratchett
public class MainActivity extends ActionBarActivity {

    private final static UUID PEBBLE_APP_UUID = UUID.fromString("20c769c4-5920-4e58-b1ad-4e47bd8a5fe0");
    public final static String EXTRA_MESSAGE = "com.example.owner.anvilhackui.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text1 = getIntent().getStringExtra("ArollOutput");
        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText(text1);

        String text2 = getIntent().getStringExtra("ArollOutput2");
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        tx2.setText(text2);

        String text3 = getIntent().getStringExtra("ArollOutput3");
        TextView tx3 = (TextView) findViewById(R.id.textView3);
        tx3.setText(text3);

        String text4 = getIntent().getStringExtra("ArollOutput4");
        TextView tx4 = (TextView) findViewById(R.id.textView4);
        tx4.setText(text4);

        String text5 = getIntent().getStringExtra("ArollOutput5");
        EditText editText = (EditText) findViewById(R.id.rollTxt);
        editText.setText(text5);


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


    public void bluetoothLayout(View view) {
        PebbleKit.startAppOnPebble(getApplicationContext(), PEBBLE_APP_UUID);

    }




    public void MacrosLayout(View view){
        String newString= getIntent().getStringExtra("mac");
        String newString2= getIntent().getStringExtra("mac2");
        String newString3= getIntent().getStringExtra("mac3");
        String newString4= getIntent().getStringExtra("mac4");
        String newString5= getIntent().getStringExtra("mac5");
        String newString6= getIntent().getStringExtra("mac6");

        TextView tx = (TextView) findViewById(R.id.textView);
        Intent act3 = new Intent(getApplicationContext(),MainActivity22Activity.class);

        act3.putExtra("macIn",newString);
        act3.putExtra("macIn2",newString2);
        act3.putExtra("macIn3",newString3);
        act3.putExtra("macIn4",newString4);
        act3.putExtra("macIn5",newString5);
        act3.putExtra("macIn6",newString6);


        String rollOutput = tx.getText().toString();
        act3.putExtra("tx",rollOutput);
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        String rollOutput2 = tx2.getText().toString();
        act3.putExtra("tx2",rollOutput2);
        TextView tx3 = (TextView) findViewById(R.id.textView3);
        String rollOutput3 = tx3.getText().toString();
        act3.putExtra("tx3",rollOutput3);
        TextView tx4 = (TextView) findViewById(R.id.textView4);
        String rollOutput4 = tx4.getText().toString();
        act3.putExtra("tx4",rollOutput4);
        EditText editText = (EditText) findViewById(R.id.rollTxt);
        String rollOutput5 = editText.getText().toString();
        act3.putExtra("tx5",rollOutput5);
        startActivity(act3);
    }

    public void setLayoutTrail(View view){
        Intent trail = new Intent(getApplicationContext(),TrailRolls.class);
        startActivity(trail);
    }

    public void Roll(View view) {

        TextView tx = (TextView) findViewById(R.id.textView);
        if (tx.getText() != "") {
            TextView tx2 = (TextView) findViewById(R.id.textView2);
            if (tx2.getText() != "") {
                TextView tx3 = (TextView) findViewById(R.id.textView3);
                if (tx3.getText() != "") {
                    TextView tx4 = (TextView) findViewById(R.id.textView4);
                    tx4.setText(tx3.getText());
                }
                tx3.setText(tx2.getText());
            }
            tx2.setText(tx.getText());
        }
        EditText editText = (EditText) findViewById(R.id.rollTxt);
        String message = editText.getText().toString();
        Integer intResult = myMain(message);
        String testString = Integer.toString(intResult);
        tx.setText(testString);

    }

    public void SwapLayout(View view){
        TextView tx = (TextView) findViewById(R.id.textView);
        Intent act2 = new Intent(getApplicationContext(),MainActivity2Activity.class);
        String rollOutput = tx.getText().toString();
        act2.putExtra("tx",rollOutput);
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        String rollOutput2 = tx2.getText().toString();
        act2.putExtra("tx2",rollOutput2);
        TextView tx3 = (TextView) findViewById(R.id.textView3);
        String rollOutput3 = tx3.getText().toString();
        act2.putExtra("tx3",rollOutput3);
        TextView tx4 = (TextView) findViewById(R.id.textView4);
        String rollOutput4 = tx4.getText().toString();
        act2.putExtra("tx4",rollOutput4);
        EditText editText = (EditText) findViewById(R.id.rollTxt);
        String rollOutput5 = editText.getText().toString();
        act2.putExtra("tx5",rollOutput5);
        startActivity(act2);
    }


    public static int myMain(String input)
    {
        input = input.trim();
        String[] diceCommands = input.split(" ");
        if((diceCommands.length+1)%2!=0)
        {
            return -255;
        }

        System.out.println("> " + diceCommands[0]);
        int total = handleDice(diceCommands[0]);

        for(int i = 0; i<((diceCommands.length-1)/2); i++)
        {
            System.out.println("> " + diceCommands[(i+1)*2]);
            if (diceCommands[i*2+1].equals("+"))
            {
                total += handleDice(diceCommands[(i+1)*2]);
            } else if(diceCommands[i*2+1].equals("-")) {
                total -= handleDice(diceCommands[(i+1)*2]);
            }
        }
        System.out.println(total);
        return total;
    }

    public static int handleDice(String diceInput)
    {
        String diceControl[]={"","",""};
        int x = 0;
        for (char ch: diceInput.toCharArray())
        {
            switch(x){
                case(0):
                    if (ch >= '0'&& ch<='9')
                    {
                        diceControl[0] += ch;
                        break;
                    } else if (ch == 'd' || ch == 'D') {
                        x++;
                        break;
                    }
                    return 1/0;
                case(1):
                    if (ch >= '0'&& ch<='9')
                    {
                        diceControl[1] += ch;
                        break;
                    } else {
                        x++;
                    }
                case(2):
                    diceControl[2] += ch;
            }
        }
        //System.out.println(diceControl[0]);
        //System.out.println(diceControl[1]);
        //System.out.println(diceControl[2]);
        if(diceControl[0].length() == 0 || diceControl[1].length() == 0)
        {
            return 1/0;
        }
        int[] rolls = new int[Integer.parseInt(diceControl[0])];
        for(int i = 0; i < Integer.parseInt(diceControl[0]);i++){
            rolls[i] = random_int(1, Integer.parseInt(diceControl[1])+1);
        }
        Arrays.sort(rolls);
        System.out.println(Arrays.toString(rolls));
        int total = eval(rolls, diceControl[2]);
        System.out.println(total);
        return total;
    }


    public static int random_int(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }

    public static int sum(int [] vals)
    {
        int sum = 0;
        for (int i : vals)
        {
            if(i!=-255){
                sum += i;
            }
        }
        return sum;
    }

    public static int eval(int[] vals, String mod) {
        if (mod.length() == 0) {
            return sum(vals);
        } else {
            String modchar = "";
            switch (mod.charAt(0)) {
                case ('h'):
                case ('H'):
                    Arrays.sort(vals);
                    for (int x = 0; x < (vals.length - 1); x++) {
                        vals[x] = -255;
                    }
                    mod = mod.substring(1);
                    break;
                case ('l'):
                case ('L'):
                    Arrays.sort(vals);
                    for (int x = 1; x < (vals.length); x++) {
                        vals[x] = -255;
                    }
                    mod = mod.substring(1);
                    break;
                case ('k'):
                case ('K'):
                    modchar = getNextInt(mod.substring(1));
                    Arrays.sort(vals);
                    for (int x = 0; x < vals.length - Integer.parseInt(modchar); x++) {
                        vals[x] = -255;
                    }
                    mod = mod.substring(1 + modchar.length());
                    break;
                case ('d'):
                case ('D'):
                    modchar = getNextInt(mod.substring(1));
                    Arrays.sort(vals);
                    for (int x = Integer.parseInt(modchar); x< vals.length; x++) {
                        vals[x] = -255;
                    }
                    mod = mod.substring(1 + modchar.length());
                    break;
                case ('>'):
                    modchar = getNextInt(mod.substring(1));
                    int totalGreater = 0;
                    for (int i = 0; i < vals.length; i++) {
                        if (vals[i] > Integer.parseInt(modchar)) {
                            totalGreater++;
                        }
                        vals[i] = -255;
                    }
                    vals[vals.length - 1] = totalGreater;
                    mod = mod.substring(1 + modchar.length());
                    break;
                case ('<'):
                    modchar = getNextInt(mod.substring(1));
                    int totalless = 0;
                    for (int i = 0; i < vals.length; i++) {
                        if (vals[i] < Integer.parseInt(modchar) && vals[i] != -255) {
                            totalless++;
                        }
                        vals[i] = -255;
                    }
                    vals[vals.length - 1] = totalless;
                    mod = mod.substring(1 + modchar.length());
                    break;
                case ('+'):
                    modchar = getNextInt(mod.substring(1));
                    int adder = sum(vals) + Integer.parseInt(modchar);
                    for (int i = 0; i < vals.length; i++) {
                        if (vals[i] != -255) {
                            vals[i] = -255;
                        }
                    }
                    vals[vals.length - 1] = adder;
                    mod = mod.substring(1 + modchar.length());
                    break;
                case ('-'):
                    modchar = getNextInt(mod.substring(1));
                    int subber = sum(vals) - Integer.parseInt(modchar);
                    for (int i = 0; i < vals.length; i++) {
                        if (vals[i] != -255) {
                            vals[i] = -255;
                        }
                    }
                    vals[vals.length - 1] = subber;
                    mod = mod.substring(1 + modchar.length());
                    break;
                default:
                    return -255;
            }
        }
        return eval(vals,mod);
    }



    public static String getNextInt(String mod)
    {
        String modint = "";
        for (char val : mod.toCharArray())
        {
            if (val >= '0' && val <= '9')
            {
                modint += val;
            } else {
                break;
            }
        }
        return modint;
    }



}

