package com.example.hack.Domini;

public class Barri {

    private int id;
    private String nomBarri;
    private float currentKg;
    private int habitants;

    public Barri(int id, String nomBarri, int habitants, float currentKg) {
        this.id = id;
        this.nomBarri = nomBarri;
        this.currentKg = currentKg;
        this.habitants = habitants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomBarri() {
        return nomBarri;
    }

    public void setNomBarri(String nomBarri) {
        this.nomBarri = nomBarri;
    }

    public float getCurrentKg() {
        return currentKg;
    }

    public void setCurrentKg(float currentKg) {
        this.currentKg = currentKg;
    }

    public int getHabitants() {
        return habitants;
    }

    public void setHabitants(int habitants) {
        this.habitants = habitants;
    }
}
