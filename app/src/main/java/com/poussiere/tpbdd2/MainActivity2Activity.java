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
import android.widget.EditText;


public class MainActivity2Activity extends Activity {

    EditText prenomEt, nomEt, emailEt;
    String prenom, nom, email;
    private DAO maBase;
    public final static String ACT_NAME="Activite 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Log.i(ACT_NAME, "act2 createe");
        maBase = new DAO(this);
        Log.i(ACT_NAME, "MaBase instanciee");
        maBase.open();
        Log.i(ACT_NAME, "MaBase ouverte");
    }


    public void valider(View v) {

        Intent t = new Intent(MainActivity2Activity.this,MainActivity.class);
        prenomEt = (EditText) findViewById(R.id.EtPrenom);
        nomEt = (EditText) findViewById(R.id.EtNom);
        emailEt = (EditText) findViewById(R.id.EtEmail);

        prenom = prenomEt.getText().toString();
        nom = nomEt.getText().toString();
        email = emailEt.getText().toString();


        CARNET carnet = null;
        carnet = maBase.creerEntree(this.prenom, this.nom, this.email);
        Log.i(ACT_NAME,"Entree cree");
        startActivity(t);

    }

    @Override
    public void onPause()
    {maBase.close();
        Log.i(ACT_NAME, "MaBase fermee");
        super.onPause();
        Log.i(ACT_NAME, "act pausee");}

    @Override
    public void onResume()
    {maBase.open();
        Log.i(ACT_NAME, "MaBase ouverte depuis resume");
        super.onResume();
        Log.i(ACT_NAME, "Act Resumee");   }



}

