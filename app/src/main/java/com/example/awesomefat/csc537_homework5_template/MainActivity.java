package com.example.awesomefat.csc537_homework5_template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private TextView numElementsTV;
    private BinaryTree bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get our widgets from our layout
        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.numElementsTV = (TextView)this.findViewById(R.id.numElementsTV);

        //create our binaryTree
        this.bt = new BinaryTree();

        this.updateTreeCount();
    }

    private void updateTreeCount()
    {
        this.numElementsTV.setText("" + this.bt.getCount());
    }

    public void addToTreeButtonPressed(View v)
    {
        if(this.inputET.getText().length() > 0)
        {
            int payload = Integer.parseInt(this.inputET.getText().toString());
            this.bt.add(payload);
            this.updateTreeCount();
        }
    }
}
