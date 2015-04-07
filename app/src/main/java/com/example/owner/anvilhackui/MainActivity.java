package com.example.owner.anvilhackui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.getpebble.android.kit.PebbleKit;


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
        Intent act3 = new Intent(getApplicationContext(),main_macro_screen.class);

        act3.putExtra("macIn",newString);
        act3.putExtra("macIn2",newString2);
        act3.putExtra("macIn3",newString3);
        act3.putExtra("macIn4",newString4);
        act3.putExtra("macIn5",newString5);
        act3.putExtra("macIn6",newString6);


        String rollOutput = tx.getText().toString();
        act3.putExtra("tx",rollOutput);

        EditText editText = (EditText) findViewById(R.id.rollTxt);
        String rollOutput5 = editText.getText().toString();
        act3.putExtra("tx5",rollOutput5);
        startActivity(act3);
    }

    public void setLayoutTrail(View view){
        Intent trail = new Intent(getApplicationContext(),TrailRolls.class);
        startActivity(trail);
    }

    public int NumberVerse = 0;
    public void Roll(View view) {
        String text = "";
        ScrollView scroll = (ScrollView) findViewById(R.id.scrollView);
        TextView tx = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.rollTxt);
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        String testString = "";
        if (day == 1 && month == 3){
            text = RickRoll(NumberVerse);
            NumberVerse = NumberVerse + 1;
            if(NumberVerse>13){
                NumberVerse = 1;
            }
            testString = text;
        } else if (((day==5 && month ==4)||(day==6 && month ==1)|| (day==30 && month==4)) && NumberVerse==0) {
            NumberVerse = NumberVerse + 1;
            text = "Happy Birthday";

        } else {
            String message = editText.getText().toString();
            int intResult = myMain(message);
            testString = Integer.toString(intResult);
            text = (tx.getText() + testString + "\n");
        }

        tx.setText(text);
        scroll.fullScroll(View.FOCUS_DOWN);
    }


    public static String RickRoll(int Verse) {
        if (Verse ==0){
            return("Oooh");
        }
        else if (Verse == 1) {
            return ("We're no strangers to love\n" +
                    "You know the rules and so do I\n" +
                    "A full commitment's what I'm thinking of\n" +
                    "You wouldn't get this from any other guy");
        }
        else if (Verse == 2) {
            return ("I just wanna tell you how I'm feeling\n" +
                    "Gotta make you understand");
        }
        else if (Verse == 3) {
            return ("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you");
        }
        else if (Verse == 4) {
            return ("We've known each other for so long\n" +
                    "Your heart's been aching, but\n" +
                    "You're too shy to say it\n" +
                    "Inside, we both know what's been going on\n" +
                    "We know the game and we're gonna play it");
        }
        else if (Verse == 5) {
            return ("And if you ask me how I'm feeling\n" +
                    "Don't tell me you're too blind to see");
        }
        else if (Verse == 6) {
            return ("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you");

        }
        else if (Verse == 7) {
            return ("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n");
        }
        else if (Verse == 8){
            return ("(Ooh, give you up)\n" +
                    "(Ooh, give you up)\n" +
                    "Never gonna give, never gonna give\n" +
                    "(Give you up)\n" +
                    "Never gonna give, never gonna give\n" +
                    "(Give you up)");
        }
        else if (Verse==9){
            return("We've known each other for so long\n" +
                    "Your heart's been aching, but\n" +
                    "You're too shy to say it\n" +
                    "Inside, we both know what's been going on\n" +
                    "We know the game and we're gonna play it");

        }
        else if (Verse==10){
            return("I just wanna tell you how I'm feeling\n" +
                    "Gotta make you understand");
        }
        else if (Verse==11){
            return("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you");
        }
        else if (Verse==12) {
            return ("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you");
        }
        else if (Verse==13) {
            return ("Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you");
        }
        else {
            return ("Oooh");
        }
    }



    public void SwapLayout(View view){
        TextView tx = (TextView) findViewById(R.id.textView);
        Intent act2 = new Intent(getApplicationContext(),help_screen.class);
        String rollOutput = tx.getText().toString();
        act2.putExtra("tx",rollOutput);

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

