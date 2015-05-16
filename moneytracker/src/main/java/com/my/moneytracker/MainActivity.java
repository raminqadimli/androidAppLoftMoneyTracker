package com.my.moneytracker;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    DrawerLayout drawerLayout;

    @ViewById
    ListView leftDrawer;

    private ActionBarDrawerToggle drawerToggle;

    @AfterViews
    void ready() {
        String[] navigationData = getResources().getStringArray(R.array.navigation_data);
        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, navigationData);
        leftDrawer.setAdapter(navigationDrawerAdapter);
        leftDrawer.setOnItemClickListener(new DrawerItemClickListener());


        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                leftDrawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(leftDrawer);
                setTitle(getString(R.string.transactions));
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
            }
        }
    }
}
