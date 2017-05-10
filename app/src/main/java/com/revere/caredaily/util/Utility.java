package com.revere.caredaily.util;

import com.revere.caredaily.db.Dashijin;
import com.revere.caredaily.db.Rouzhijin;
import com.revere.caredaily.db.SBLalaku;
import com.revere.caredaily.db.SBZhiniaoku;
import com.revere.caredaily.db.SRLalaku;
import com.revere.caredaily.db.SRZhiniaoku;
import com.revere.caredaily.db.Xiaoshijin;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/9.
 */

public class Utility {
    public static ArrayList<Integer> getStoredQuantity() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Dashijin dashijin = DataSupport.find(Dashijin.class, 1);
        arrayList.add(Flags.FLAG_DSJ, dashijin.getQuantity());
        Xiaoshijin xiaoshijin = DataSupport.find(Xiaoshijin.class, 1);
        arrayList.add(Flags.FLAG_XSJ, xiaoshijin.getQuantity());
        Rouzhijin rouzhijin = DataSupport.find(Rouzhijin.class, 1);
        arrayList.add(Flags.FLAG_RZJ, rouzhijin.getQuantity());
        SRZhiniaoku srZhiniaoku = DataSupport.find(SRZhiniaoku.class, 1);
        arrayList.add(Flags.FLAG_SRZNK, srZhiniaoku.getQuantity());
        SRLalaku srLalaku = DataSupport.find(SRLalaku.class, 1);
        arrayList.add(Flags.FLAG_SRLLK, srLalaku.getQuantity());
        SBZhiniaoku sbZhiniaoku = DataSupport.find(SBZhiniaoku.class, 1);
        arrayList.add(Flags.FLAG_SBZNK, sbZhiniaoku.getQuantity());
        SBLalaku sbLalaku = DataSupport.find(SBLalaku.class, 1);
        arrayList.add(Flags.FLAG_SBLLK, sbLalaku.getQuantity());


        return arrayList;
    }
}
