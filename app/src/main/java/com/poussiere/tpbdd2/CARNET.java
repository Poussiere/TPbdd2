package com.poussiere.tpbdd2;

import android.content.Context;

/**
 * Created by Nicolas on 08/04/2015.
 */
public class CARNET {

    private int id;
    private String prenom, nom, email;



    public void setId(int i)
    {this.id = i ;}

    public int getId()
    {return this.id;}



    public String getPrenom()
    {return this.prenom;}

    public String getNom()
    {return this.nom;}

    public String getEmail()
    {return this.email;}

    public void setPrenom(String n)
    {this.prenom=n;}

    public void setNom(String n)
    {this.nom=n;}

    public void setEmail (String n)
    {this.email=n;}


    // ne pas oublier pour l'affichage
    @Override
    public String toString() {
        return ""+this.getNom()+ this.getEmail()+this.getPrenom();    }

}
