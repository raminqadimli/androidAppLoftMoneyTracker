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


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView left_drawer;
    //    private String[] navigationData = new String[]{"first", "second", "third"};
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] navigationData = getResources().getStringArray(R.array.screen_array);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer = (ListView) findViewById(R.id.left_drawer);

        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, navigationData);
        left_drawer.setAdapter(navigationDrawerAdapter);
        left_drawer.setOnItemClickListener(new DrawerItemClickListener());

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);

        // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//        selectItem(0);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
//    }


//    private void selectItem(int position) {
//        switch (position) {
//            case 0:
////                choose_section(new TransactionsFragment());
//                break;
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//
//            default:
//                selectItem(0);
//                break;
//        }
//
//        left_drawer.setItemChecked(position, true);
//        drawerLayout.closeDrawer(left_drawer);
//    }

//    private void choose_section(Fragment fragment) {
//        getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
//    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
        super.setTitle(title);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            selectItem(position);
            if (position == 0) {
                left_drawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(left_drawer);
                setTitle(getString(R.string.transactions));
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
            }
        }


    }


}
