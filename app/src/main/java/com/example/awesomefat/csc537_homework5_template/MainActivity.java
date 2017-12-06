package com.example.awesomefat.csc537_homework5_template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private TextView numElementsTV;
    private BinaryTree bt;
    private ViewGroup outputViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Core.context = this;

        //get our widgets from our layout
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.numElementsTV = (TextView)this.findViewById(R.id.numElementsTV);
        this.outputViewGroup = (ViewGroup)this.findViewById(R.id.outputViewGroup);

        //create our binaryTree
        this.bt = new BinaryTree();

        this.updateTreeCount();
    }

    public void inOrderButtonPressed(View v)
    {
        this.bt.traverseInOrder(this.outputViewGroup);
    }

    public void preOrderButtonPressed(View v)
    {
        this.bt.traversePreOrder(this.outputViewGroup);
    }

    public void postOrderButtonPressed(View v)
    {
        this.bt.traversePostOrder(this.outputViewGroup);
    }

    private void updateTreeCount()
    {
        this.numElementsTV.setText("" + this.bt.getCount());
    }

    private void addToTree(String value)
    {
        int payload = Integer.parseInt(value);
        this.bt.add(payload);
        this.updateTreeCount();
    }

    String trimString2(String s)
    {
        return s.trim();
    }

    //write a function that takes a string as a parameter and returns that string with all
    //leading and ending spaces removed: "   9 7   " -> "9"
    String trimString(String s)
    {
        String answer = "";

        //burn past leading spaces;
        int pos = 0;
        while(pos < s.length())
        {
            if(s.charAt(pos) != ' ')
            {
                break;
            }
            pos++;
        }

        int pos2 = s.length()-1;

        while(pos2 >= 0)
        {
            if(s.charAt(pos2) != ' ')
            {
                break;
            }
            pos2--;
        }

        //we know that our real value lives between pos and pos2
        for(int i = pos; i <= pos2; i++)
        {
            answer = answer + s.charAt(i);
        }
        return answer;
    }

    public void addToTreeButtonPressed(View v)
    {
        if(this.inputET.getText().length() > 0)
        {
            String value = this.inputET.getText().toString();
            if(value.indexOf(",") == -1)
            {
                //flat number
                this.addToTree(value);
            }
            else
            {
                //we have a comma delimited list, so parse it and add each value.
                //"10, 9, 13, 6, 6, 8,7"

                StringTokenizer st = new StringTokenizer(value, ",");
                while(st.hasMoreTokens())
                {
                    this.addToTree(st.nextToken().trim());
                }
            }

        }
    }
}
