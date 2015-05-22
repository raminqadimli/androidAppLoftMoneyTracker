package com.my.moneytracker;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Andrew on 18.05.2015.
 */
@EActivity(R.layout.activity_add_transaction)
public class AddTransactionActivity extends ActionBarActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    EditText sum, title;

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.add_transactions));
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Click
    void addTransaction() {
        new Transaction(title.getText().toString(), sum.getText().toString()).save();
        finish();
    }

    @OptionsItem
    void homeSelected() {
        onBackPressed();
    }
}
