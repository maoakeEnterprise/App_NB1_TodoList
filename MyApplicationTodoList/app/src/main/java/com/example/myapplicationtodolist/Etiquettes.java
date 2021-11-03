package com.example.myapplicationtodolist;

import java.util.ArrayList;

public class Etiquettes {
    private ArrayList<Etiquette> listeTickets;

    public Etiquettes(){
        this.listeTickets = new ArrayList<>();

    }

    public void init(){
        Etiquette etiquette;
        this.listeTickets = new ArrayList<>();

        for(int i=0; i<5; i++) {
            etiquette = new Etiquette("Etiquette " + i, "Description " + i);
            addEtiquette(etiquette);
        }
    }

    public void addEtiquette(Etiquette etiquette){
        listeTickets.add(etiquette);
    }

    public void modifyEtiquette(int index, Etiquette etiquette){
        listeTickets.set(index, etiquette);
    }

    public void deleteEtiquette(int index){
        listeTickets.remove(index);
    }


    //GET
    public ArrayList<Etiquette> getListeTickets(){
        return listeTickets;
    }


    //SET
    public void setListeTickets(ArrayList<Etiquette> listeTickets) {
        this.listeTickets = listeTickets;
    }
}
