package com.poussiere.tpbdd2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {


    public Button bouton1, bouton2;
    public final static String ACT_NAME="Activite 1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

public void versAct2(View v) {
    Intent act2= new Intent (MainActivity.this, MainActivity2Activity.class);
    startActivity(act2);
}

    public void versAct3(View v) {
        Intent act3= new Intent (MainActivity.this, MainActivity3Activity.class);
        startActivity(act3);
    }

protected void onPause(){
    Log.i(ACT_NAME, "Act1 pausee");
    super.onPause();
}
}


