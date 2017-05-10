package com.revere.caredaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.revere.caredaily.db.Dashijin;
import com.revere.caredaily.db.Rouzhijin;
import com.revere.caredaily.db.SBLalaku;
import com.revere.caredaily.db.SBZhiniaoku;
import com.revere.caredaily.db.SRLalaku;
import com.revere.caredaily.db.SRZhiniaoku;
import com.revere.caredaily.db.Xiaoshijin;

import org.litepal.crud.DataSupport;

public class QueryActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        textView = (TextView) findViewById(R.id.textView_q);
        textView.setText(queryStorage());
        findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private String queryStorage(){
        StringBuilder sb = new StringBuilder();
        SRZhiniaoku srZhiniaoku = DataSupport.find(SRZhiniaoku.class,1);
        sb.append("丝柔纸尿裤的库存是："+srZhiniaoku.getQuantity()/3+"箱\t"  +srZhiniaoku.getQuantity()%3+"包\n");
        SRLalaku srLalaku = DataSupport.find(SRLalaku.class,1);
        sb.append("丝柔拉拉裤的库存是："+srLalaku.getQuantity()/4+"箱\t"+srLalaku.getQuantity()%4+"包\n");
        SBZhiniaoku sbZhiniaoku = DataSupport.find(SBZhiniaoku.class,1);
        sb.append("丝薄纸尿裤的库存是："+sbZhiniaoku.getQuantity()/3+"箱\t"+sbZhiniaoku.getQuantity()%3+"包\n");
        SBLalaku sbLalaku = DataSupport.find(SBLalaku.class,1);
        sb.append("丝薄拉拉裤的库存是："+sbLalaku.getQuantity()/4+"箱\t"+sbLalaku.getQuantity()%4+"包\n");
        Dashijin dashijin = DataSupport.find(Dashijin.class,1);
        sb.append("大湿巾的库存是："+dashijin.getQuantity()/6+"箱\t"+dashijin.getQuantity()%4+"包\n");
        Xiaoshijin xiaoshijin = DataSupport.find(Xiaoshijin.class,1);
        sb.append("小湿巾的库存是："+xiaoshijin.getQuantity()/24+"箱\t"+xiaoshijin.getQuantity()%24+"包\n");
        Rouzhijin rouzhijin = DataSupport.find(Rouzhijin.class,1);
        sb.append("柔纸巾的库存是："+rouzhijin.getQuantity()/60+"箱\t"+rouzhijin.getQuantity()%60+"包");
        return sb.toString();
    }
}
