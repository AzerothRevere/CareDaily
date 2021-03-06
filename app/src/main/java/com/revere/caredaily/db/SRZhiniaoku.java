package com.revere.caredaily.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/9.
 */

public class SRZhiniaoku extends DataSupport {
    private int id;
    private String name;
    private int quantity;


    public static double STOCK_PRICE = 204;
    public static double SELL_PRICE = 324;
    public static double FENXIAO_PRICE = 264;
    public static double ZONGDAI_PRICE = 219;
    public static double YIJI_PRICE = 234;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
