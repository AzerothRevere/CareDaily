package com.revere.caredaily.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/9.
 */

public class Xiaoshijin extends DataSupport{
    private int id;
    private String name;
    private int quantity;


    public static double STOCK_PRICE = 50;

    public static double SELL_PRICE = 120;
    public static double FENXIAO_PRICE = 54;
    public static double ZONGDAI_PRICE = 51;

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

    public static double YIJI_PRICE = 52;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
