package com.example.owner.anvilhackui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class TrailRolls extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_rolls);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trail_rolls, menu);
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


    public void Roll(View view) {
        TextView tx = (TextView) findViewById(R.id.rollOutput);
        EditText editText = (EditText) findViewById(R.id.editText);

        String message = editText.getText().toString();
        Integer intResult = myMain(message);
        String testString = Integer.toString(intResult);

        String text = (tx.getText() + testString + ",");
        if (tx.getText() == ""){
            tx.setMaxLines(1);
            tx.setMaxLines(1);
        }
        else {
            tx.setMaxLines(tx.getMaxLines() + 1);
            tx.setMaxLines(tx.getMinLines() + 1);
        }
        tx.setText(text);


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

    public static int eval(int [] vals,String mod)
    {
        if (mod.length() == 0)
        {
            return sum(vals);
        } else {
            String modchar="";
            switch(mod.charAt(0))
            {
                case('h'):
                case('H'):
                    vals[vals.length -1] = -255;
                    Arrays.sort(vals);
                    mod = mod.substring(1);
                    break;
                case('l'):
                case('L'):
                    for(int i=0;i<vals.length;i++)
                    {
                        if (vals[i] != -255)
                        {
                            vals[i] = -255;
                            break;
                        }
                    }
                    mod = mod.substring(1);
                    break;
                case('d'):
                case('D'):
                    modchar = getNextInt(mod.substring(1));
                    int modint = Integer.parseInt(modchar);
                    for(int i = 1; i < modint+1; i++)
                    {
                        vals[ vals.length - i ] = -255;
                    }
                    Arrays.sort(vals);
                    mod = mod.substring(1+modchar.length());
                    break;
                case('k'):
                case('K'):
                    modchar = getNextInt(mod.substring(1));
                    int x = 0;
                    while(vals[x] != -255)
                    {
                        x++;
                    }
                    for(int i = x; i< (x + vals.length - Integer.parseInt(modchar));i++)
                    {
                        vals[i] = -255;
                    }
                    Arrays.sort(vals);
                    mod = mod.substring(1+modchar.length());
                    break;
                case('>'):
                    modchar = getNextInt(mod.substring(1));
                    int totalgrater = 0;
                    for (int i = 0; i<vals.length;i++)
                    {
                        if (vals[i]>Integer.parseInt(modchar))
                        {
                            totalgrater++;
                        }
                        vals[i] = -255;
                    }
                    vals[vals.length-1] = totalgrater;
                    mod = mod.substring(1+modchar.length());
                    break;
                case('<'):
                    modchar = getNextInt(mod.substring(1));
                    int totalless = 0;
                    for (int i = 0; i<vals.length;i++)
                    {
                        if (vals[i]<Integer.parseInt(modchar)&&vals[i]!=-255)
                        {
                            totalless++;
                        }
                        vals[i] = -255;
                    }
                    vals[vals.length-1] = totalless;
                    mod = mod.substring(1+modchar.length());
                    break;
                case('+'):
                    modchar = getNextInt(mod.substring(1));
                    int adder = sum(vals) + Integer.parseInt(modchar);
                    for (int i = 0; i<vals.length;i++)
                    {
                        if(vals[i] != -255)
                        {
                            vals[i]=-255;
                        }
                    }
                    vals[vals.length-1] = adder;
                    mod = mod.substring(1+modchar.length());
                    break;
                case('-'):
                    modchar = getNextInt(mod.substring(1));
                    int subber = sum(vals) - Integer.parseInt(modchar);
                    for (int i = 0; i<vals.length;i++)
                    {
                        if(vals[i] != -255)
                        {
                            vals[i]=-255;
                        }
                    }
                    vals[vals.length-1] = subber;
                    mod = mod.substring(1+modchar.length());
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
