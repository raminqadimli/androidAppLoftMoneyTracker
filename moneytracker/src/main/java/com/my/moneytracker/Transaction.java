package com.my.moneytracker;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Andrew on 24.04.2015.
 */
@Table(name = "Transactions")
public class Transaction extends Model {
    @Column(name = "title")
    public String title;

    @Column(name = "sum")
    public String sum;

    @Column(name = "date")
    public Date date;

    /**
     * This is required by active android
     */
    public Transaction() {
    }

    public Transaction(String title, String sum) {
        this.title = title;
        this.sum = sum;
        date = new Date();
    }

}
