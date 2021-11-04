package com.example.myapplicationtodolist;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Taches {
    private ArrayList<Tache> tasks;
    private ArrayList<String> dates;

    public void Taches(){
        this.tasks = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    public void init(){
        this.tasks = new ArrayList<>();
        Tache tache;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(int i=0; i < 5 ; i++) {
            tache = new Tache("tache "+i, "description "+i, sdf.format(new Date()));
            this.tasks.add(tache);
        }

    }

    public void addTask(Tache task){
        this.tasks.add(task);
    }

    public void deleteTask(int index){
        this.tasks.remove(index);
    }

    public void modifyTask(int index, Tache task){
        this.tasks.set(index, task);
    }

    public void aValidateTask(int index){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dates.add(sdf.format(date));
        this.deleteTask(index);
    }

    //GET
    public ArrayList<Tache> getTasks() {
        return tasks;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    //SET
    public void setTasks(ArrayList<Tache> tasks) {
        this.tasks = tasks;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
}
