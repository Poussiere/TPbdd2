package com.poussiere.tpbdd2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class Bdd extends SQLiteOpenHelper {


    public static final String NOM_DE_LA_TABLE="repertoire";


    public static final String COL1="_id";
    public static final String COL2="prenom";
    public static final String COL3="nom";
    public static final String COL4="email";
    public static final String TEXTE_DE_CREATION = "CREATE TABLE "+ NOM_DE_LA_TABLE+
            " ( "+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" TEXT, "+COL3+
            " TEXT, "+COL4+" TEXT);";
    public static final String CHECK_VERSION="DROP TABLE IF EXISTS "+NOM_DE_LA_TABLE;

    public Bdd(Context context, String name, CursorFactory factory, int version)
    {super(context,name,factory,version);}


    @Override
    public void onCreate(SQLiteDatabase db)

    {
        db.execSQL(TEXTE_DE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(CHECK_VERSION);
        onCreate (db);
    }
}
