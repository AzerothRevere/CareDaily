package com.revere.caredaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        findViewById(R.id.btn_stock).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_stock:
                Intent i = new Intent(this,StockActivity.class);
                startActivity(i);
                break;
            case R.id.btn_query:
                System.out.print("dddddddddddddddddddddddd");
                Intent ii = new Intent(this,QueryActivity.class);
                startActivity(ii);
                break;

        }
    }
}
