package com.example.myapplicationtodolist;

import java.util.ArrayList;
import java.util.Date;

public class Taches {
    private ArrayList<Tache> tasks;
    private ArrayList<Date> dates;

    public void Taches(){
        tasks = null;
    }

    private void init(){

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

    public void aValidateTask(){

    }

    //GET
    public ArrayList<Tache> getTasks() {
        return tasks;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    //SET
    public void setTasks(ArrayList<Tache> tasks) {
        this.tasks = tasks;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }
}
