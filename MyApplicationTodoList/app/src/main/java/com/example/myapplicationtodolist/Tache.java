package com.example.myapplicationtodolist;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Tache {

    private String name;
    private String describe;
    private Etiquette etiquette;
    private String date;

    //CONSTRUCTOR

    public Tache(String nom, String description, String date){
        this.name = nom;
        this.describe = description;
        this.date= date;
        etiquette = null;
    }

    public Tache(String nom, String description, String date, Etiquette etiquette){
        this.name = nom;
        this.describe = description;
        this.date= date;
        this.etiquette = etiquette;
    }

    //FUNCTION CLASS

    //GET

    public String getNom() {
        return name;
    }
    public String getDescription() {
        return describe;
    }
    public String getDate() {
        return date;
    }
    public Etiquette getEtiquette() {
        return etiquette;
    }

    //SET

    public void setNom(String nom) {
        this.name = nom;
    }
    public void setDescription(String description) {
        this.describe = description;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setEtiquette(Etiquette etiquette) {
        this.etiquette = etiquette;
    }
}
