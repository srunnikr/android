package com.example.sreejith.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mealPrice;
    private EditText tipPercent;
    private TextView tip;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mealPrice = (EditText)findViewById(R.id.mealPrice);
        tipPercent = (EditText)findViewById(R.id.tipPercent);
        tip = (TextView)findViewById(R.id.tipTotal);
        total = (TextView)findViewById(R.id.totalPrice);

    }

    public void calculateTip(View v) {

        // Validate the inputs
        String mealPriceEntry = mealPrice.getText().toString();
        String tipPercentEntry = tipPercent.getText().toString();

        if (mealPriceEntry.equals("") || tipPercentEntry.equals("")) {
            Toast.makeText(this, "Did you enter the inputs?...", Toast.LENGTH_LONG).show();
            clearAllFields();
            return;
        }

        int mealPriceVal = Integer.valueOf(mealPriceEntry);
        int tipPercentVal = Integer.valueOf(tipPercentEntry);
        System.out.println("mealPrice : "+mealPriceVal+" tipPercent : "+tipPercentVal);

        float tipVal = mealPriceVal * ((float)tipPercentVal / 100);
        System.out.println("Tip : "+tipVal);
        float totalVal = tipVal + mealPriceVal;
        System.out.println("Total : "+totalVal);

        tip.setText("Tip : "+String.valueOf(tipVal));
        total.setText("Total : "+String.valueOf(totalVal));

    }

    public void clearAllFields() {
        tip.setText("");
        total.setText("");
        mealPrice.setText("");
        tipPercent.setText("");
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
}
