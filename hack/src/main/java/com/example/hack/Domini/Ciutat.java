package com.example.hack.Domini;

public class Ciutat {
    private int id;
    private String nomCiutat;
    private int numeroHabitants;

    public Ciutat(int id, String nomCiutat, int numeroHabitants) {
        this.id = id;
        this.nomCiutat = nomCiutat;
        this.numeroHabitants = numeroHabitants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCiutat() {
        return nomCiutat;
    }

    public void setNomCiutat(String nomCiutat) {
        this.nomCiutat = nomCiutat;
    }

    public int getNumeroHabitants() {
        return numeroHabitants;
    }

    public void setNumeroHabitants(int numeroHabitants) {
        this.numeroHabitants = numeroHabitants;
    }
}
