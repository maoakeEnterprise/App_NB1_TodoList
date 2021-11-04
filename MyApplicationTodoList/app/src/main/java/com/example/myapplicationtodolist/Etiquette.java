package com.example.myapplicationtodolist;

import org.w3c.dom.Text;

import java.sql.Date;
import java.util.ArrayList;

public class Etiquette {

    private String name;
    private String describe;
    private ArrayList<String> datesValidateTickets;

    //CONSTRUCTOR

    public Etiquette(String nom, String description){
        this.name = nom;
        this.describe = description;
        datesValidateTickets = new ArrayList<String>();
    }

    //FUNCTION CLASS

    public void aValidateTicket(String date){
        this.datesValidateTickets.add(date);
    }

    //GET

    public String getDescription() {
        return describe;
    }
    public String getNom() {
        return name;
    }
    public ArrayList<String> getDatesValidateTickets() {
        return datesValidateTickets;
    }

    //SET

    public void setDescription(String description) {
        this.describe = description;
    }
    public void setNom(String nom) {
        this.name = nom;
    }
    public void setDatesValidateTickets(ArrayList<String> dates) {
        this.datesValidateTickets = dates;
    }
}
