package com.example.biggernumber;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int n;
    private int n1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setRandomNumbers();
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

    public void setRandomNumbers()
    {
        Random rand = new Random ();
        n = rand.nextInt(10);
        while (true)
        {
            n1 = rand.nextInt(10);
            if (n != n1)
            {
                break;
            }
        }

        Button b = this.findViewById(R.id.number);
        Button b1 = this.findViewById(R.id.number1);

        b.setText(Integer.toString(n));
        b1.setText(Integer.toString(n1));
    }

    public void onClicknumber(View view)
    {
        if (n > n1)
        {
            Toast.makeText(getApplicationContext(), "You're right!", Toast.LENGTH_SHORT).show();
            score ++;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT).show();
        }

        TextView scoreBoard = this.findViewById(R.id.score);
        scoreBoard.setText("Your Score:" + score);

        setRandomNumbers();
    }

    public void onClickNumber1(View view)
    {
        if (n1 > n)
        {
            Toast.makeText(getApplicationContext(), "You're right!", Toast.LENGTH_SHORT).show();
            score ++;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT).show();
        }

        TextView scoreBoard = this.findViewById(R.id.score);
        scoreBoard.setText("Your Score:" + score);

        setRandomNumbers();
    }
}
