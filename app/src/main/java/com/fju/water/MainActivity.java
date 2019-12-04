package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView edmonth;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.month);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            });
                Button button = findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        enter();
                }
        });

            Switch sw = findViewById(R.id.sw);
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    isNext = isChecked;
                    TextView text = findViewById(R.id.type);
                    text.setText(isNext?getString(R.string.every_other_month):getString(R.string.monthly));
                }
            });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
//public class MainActivity extends AppCompatActivity { 的MainActivity加control+o
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }


    public void enter () {
        String monthString = edmonth.getText().toString();
        if (!TextUtils.isEmpty(monthString)) {
            float degree = Float.parseFloat(monthString);
            float money = 0;
            if (degree < 31) {
                money = 7.35f * degree;
            } else if (degree < 31) {
                money = 9.45f * degree - 21;
            } else if (degree < 51) {
                money = 11.55f * degree - 84;
            } else if (degree > 51) {
                money = 12.075f * degree - 110.25f;
            }

            ///new AlertDialog.Builder(this)
            //      .setTitle("每月抄表費用")
            //     .setMessage("費用:"+money)
            //    .setPositiveButton("OK",null)
            //   .show();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.extra_money), money);
            startActivity(intent);

        }


        /*else {
            String nextString = ednext.getText().toString();
            if (!TextUtils.isEmpty(nextString)) {
                float degree = Float.parseFloat(nextString);
                float money = 0;
                if (degree < 21) {
                    money = 7.35f * degree;
                } else if (degree < 61) {
                    money = 9.45f * degree - 42;
                } else if (degree < 101) {
                    money = 11.55f * degree - 168;
                } else if (degree > 101) {
                    money = 12.075f * degree - 220.5f;
                }
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
                intent.putExtra("FEE", money);
                //new AlertDialog.Builder(this)
                //      .setTitle("隔月抄表費用")
                //    .setMessage("費用:"+money)
                //  .setPositiveButton("OK",null)
                //.show();
            }
        }*/
    }



    public void reset(View view){
        edmonth.setText("");
        //ednext.setText("");
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
