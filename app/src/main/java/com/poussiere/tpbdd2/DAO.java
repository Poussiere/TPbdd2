package com.poussiere.tpbdd2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 08/04/2015.
 */
public class DAO {

    public static final int NUM_VERSION=1;
    public static final String NOM_FICHIER="carnet.db";


    private SQLiteDatabase maBase;
    private Bdd helper;
    private String [] toutesColonnes ={Bdd.COL1, Bdd.COL2, Bdd.COL3, Bdd.COL4};


    public DAO (Context context){

        helper=new Bdd (context, NOM_FICHIER, null, NUM_VERSION);}

    public void open()
    {maBase=helper.getWritableDatabase();}

    public void close()
    {helper.close();}

    public CARNET creerEntree(String prenom, String nom, String email) {
        ContentValues values = new ContentValues();
        values.put(helper.COL2, prenom);
        values.put(helper.COL3, nom);
        values.put(helper.COL4, email);

       long insertId = maBase.insert(helper.NOM_DE_LA_TABLE, null, values);

        Cursor cursor = maBase.query(helper.NOM_DE_LA_TABLE, toutesColonnes, helper.COL1 + " = " + insertId,
                null, null, null, null);
        cursor.moveToFirst();
        CARNET newCarnet = cursorToCarnet(cursor);
        cursor.close();
        return newCarnet;

    }

    public void deleteEntree(CARNET carnet){

    long id = carnet.getId();
        maBase.delete(helper.NOM_DE_LA_TABLE, helper.COL1+" = "+id, null);
    }

    public List<CARNET> getAllCarnets()
    {
      List <CARNET> carnets = new ArrayList<CARNET>();

        Cursor cursor = maBase.query(helper.NOM_DE_LA_TABLE, toutesColonnes, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            CARNET carnet=cursorToCarnet(cursor);
            carnets.add(carnet);
            cursor.moveToNext();
        }
        cursor.close();
        return carnets;

    }


    private CARNET cursorToCarnet(Cursor cursor) {
        CARNET carnet = new CARNET();
        carnet.setId(cursor.getInt(0));
        carnet.setPrenom(cursor.getString(1));
        carnet.setNom(cursor.getString(2));
        carnet.setNom(cursor.getString(3));
        return carnet ;
    }


    }





