package com.revere.caredaily;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ImageFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.revere.caredaily.db.Dashijin;
import com.revere.caredaily.db.Rouzhijin;
import com.revere.caredaily.db.SBLalaku;
import com.revere.caredaily.db.SBZhiniaoku;
import com.revere.caredaily.db.SRLalaku;
import com.revere.caredaily.db.SRZhiniaoku;
import com.revere.caredaily.db.Xiaoshijin;
import com.revere.caredaily.util.Flags;
import com.revere.caredaily.util.Utility;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;

public class StockActivity extends AppCompatActivity  {
    private EditText dsjET;
    private EditText xsjET;
    private EditText srznkET;
    private EditText srllkET;
    private EditText sbznkET;
    private EditText sbllkET;
    private EditText rzjET;

    private RadioButton rbDsjX;
    private RadioButton rbDsjB;
    private RadioButton rbRzjX;
    private RadioButton rbRzjB;
    private RadioButton rbSBllkX;
    private RadioButton rbSBllkB;
    private RadioButton rbSRllkX;
    private RadioButton rbSRllkB;
    private RadioButton rbSBznkX;
    private RadioButton rbSBznkB;
    private RadioButton rbSRznkX;
    private RadioButton rbSRznkB;
    private RadioButton rbXsjB;
    private RadioButton rbXsjX;

    private Dashijin dashijin ;
    private Rouzhijin roushijin;
    private SBLalaku sbLalaku;
    private SBZhiniaoku sbZhiniaoku;
    private SRZhiniaoku srZhiniaoku;
    private SRLalaku srLalaku;
    private Xiaoshijin xiaoshijin;

    private boolean isFirstRun ;

    private ArrayList<Integer> savedQuantities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        LitePal.getDatabase();

        dsjET = (EditText) findViewById(R.id.editText8);
        xsjET = (EditText) findViewById(R.id.editText9);
        srznkET = (EditText) findViewById(R.id.editText2);
        srllkET = (EditText) findViewById(R.id.editText5);
        sbznkET = (EditText) findViewById(R.id.editText6);
        sbllkET = (EditText) findViewById(R.id.editText7);
        rzjET = (EditText) findViewById(R.id.editText10);

        rbDsjB = (RadioButton) findViewById(R.id.rb_dsjbao);
        rbDsjX = (RadioButton) findViewById(R.id.rb_dsjxiang);
        rbRzjB = (RadioButton) findViewById(R.id.rb_rzjbao);
        rbRzjX = (RadioButton) findViewById(R.id.rb_rzjxiang);
        rbSBllkX = (RadioButton) findViewById(R.id.rb_sbllkxiang);
        rbSBllkB = (RadioButton) findViewById(R.id.rb_sbllkbao);
        rbSRllkX = (RadioButton) findViewById(R.id.rb_srllkxiang);
        rbSRllkB = (RadioButton) findViewById(R.id.rb_srllkbao);
        rbSBznkX = (RadioButton) findViewById(R.id.rb_sbznkxiang);
        rbSBznkB = (RadioButton) findViewById(R.id.rb_sbznkbao);
        rbSRznkX = (RadioButton) findViewById(R.id.rb_srznkxiang);
        rbSRznkB = (RadioButton) findViewById(R.id.rb_srznkbao);
        rbXsjX = (RadioButton) findViewById(R.id.rb_xsjxiang);
        rbXsjB = (RadioButton) findViewById(R.id.rb_xsjbao);

        dashijin = new Dashijin();
        dashijin.setName("大湿巾");
        roushijin = new Rouzhijin();
        roushijin.setName("柔纸巾");
        sbLalaku = new SBLalaku();
        sbLalaku.setName("丝薄拉拉裤");
        sbZhiniaoku = new SBZhiniaoku();
        sbZhiniaoku.setName("丝薄纸尿裤");
        srLalaku = new SRLalaku();
        srLalaku.setName("丝柔拉拉裤");
        srZhiniaoku = new SRZhiniaoku();
        srZhiniaoku.setName("丝柔纸尿裤");
        xiaoshijin = new Xiaoshijin();
        xiaoshijin.setName("小湿巾");

        SharedPreferences pref = getSharedPreferences("flag",MODE_PRIVATE);
        isFirstRun = pref.getBoolean("isFirstRun",true);

        if (isFirstRun){
            dashijin.save();
            roushijin.save();
            sbLalaku.save();
            sbZhiniaoku.save();
            srZhiniaoku.save();
            srLalaku.save();
            xiaoshijin.save();
            SharedPreferences.Editor editor = getSharedPreferences("flag",MODE_PRIVATE).edit();
            editor.putBoolean("isFirstRun",false);
            editor.apply();
        }
        savedQuantities = Utility.getStoredQuantity();

        findViewById(R.id.btn_commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dsjET.getText()!=null){
                    int quantity = Integer.parseInt(dsjET.getText().toString());
                    if (rbDsjX.isChecked()){
                        dashijin.setQuantity(quantity*6+savedQuantities.get(Flags.FLAG_DSJ));
                        dashijin.update(1);
                    }else if (rbDsjB.isChecked()){
                        dashijin.setQuantity(quantity+savedQuantities.get(Flags.FLAG_DSJ));
                        dashijin.update(1);
                    }
                }
                if (xsjET.getText()!=null){
                    int quantity = Integer.parseInt(xsjET.getText().toString());
                    if (rbXsjX.isChecked()){
                        xiaoshijin.setQuantity(quantity*24+savedQuantities.get(Flags.FLAG_XSJ));
                        xiaoshijin.update(1);
                    }else if (rbXsjB.isChecked()){
                        xiaoshijin.setQuantity(quantity+savedQuantities.get(Flags.FLAG_XSJ));
                        xiaoshijin.update(1);
                    }
                }
                if (srznkET.getText()!=null){
                    int quantity = Integer.parseInt(srznkET.getText().toString());
                    if (rbSRznkB.isChecked()){
                        srZhiniaoku.setQuantity(quantity+savedQuantities.get(Flags.FLAG_SRZNK));
                        srZhiniaoku.update(1);
                    }else if (rbSRznkX.isChecked()){
                        srZhiniaoku.setQuantity(quantity*3+savedQuantities.get(Flags.FLAG_SRZNK));
                        srZhiniaoku.update(1);
                    }
                }
                if (srllkET.getText()!=null){
                    int quantity = Integer.parseInt(srllkET.getText().toString());
                    if (rbSRllkB.isChecked()){
                        srLalaku.setQuantity(quantity+savedQuantities.get(Flags.FLAG_SRLLK));
                        srLalaku.update(1);
                    }else if (rbSRllkX.isChecked()){
                        srLalaku.setQuantity(quantity*4+savedQuantities.get(Flags.FLAG_SRLLK));
                        srLalaku.update(1);
                    }
                }
                if (sbznkET.getText()!=null){
                    int quantity = Integer.parseInt(sbznkET.getText().toString());
                    if (rbSBznkB.isChecked()){
                        sbZhiniaoku.setQuantity(quantity+savedQuantities.get(Flags.FLAG_SBZNK));
                        sbZhiniaoku.update(1);
                    }else if (rbSBznkX.isChecked()){
                        sbZhiniaoku.setQuantity(quantity*3+savedQuantities.get(Flags.FLAG_SBZNK));
                        sbZhiniaoku.update(1);
                    }
                }
                if (sbllkET.getText()!=null){
                    int quantity = Integer.parseInt(sbllkET.getText().toString());
                    if (rbSBllkB.isChecked()){
                        sbLalaku.setQuantity(quantity+savedQuantities.get(Flags.FLAG_SBLLK));
                        sbLalaku.update(1);
                    }else if (rbSBllkX.isChecked()){
                        sbLalaku.setQuantity(quantity*4+savedQuantities.get(Flags.FLAG_SBLLK));
                        sbLalaku.update(1);
                    }
                }
                if (rzjET.getText()!=null){
                    int quantity = Integer.parseInt(rzjET.getText().toString());
                    if (rbRzjB.isChecked()){
                        roushijin.setQuantity(quantity+savedQuantities.get(Flags.FLAG_RZJ));
                        roushijin.update(1);
                    }else if (rbRzjX.isChecked()){
                        roushijin.setQuantity(quantity*5*12+savedQuantities.get(Flags.FLAG_RZJ));
                        roushijin.update(1);
                    }
                }
                Toast.makeText(StockActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StockActivity.this,QueryActivity.class);
                startActivity(i);

            }
        });



    }




    }



