package com.poussiere.tpbdd2;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.List;


public class MainActivity3Activity extends ListActivity {

    private DAO maBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        maBase=new DAO(this);
        maBase.open();
        List<CARNET> values = maBase.getAllCarnets();
        ArrayAdapter<CARNET> adapter = new ArrayAdapter<CARNET> (this,android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }
    @Override
    public void onPause()
    {maBase.close();
        super.onPause();}

    @Override
    public void onResume()
    {maBase.open();
        super.onResume();}
}
