package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float money = getIntent().getFloatExtra("FEE",-1);
        Log.d("ResultActivity",money+"");
        TextView feeText = findViewById(R.id.money);
        int n = (int)(money + 0.5f);//四捨五入
        feeText.setText(n+ "");
    }
}
