package com.example.hack.Domini;

public class Historial {
    private Barri barri;
    private int any;
    private float kilograms;

    public Historial(Barri barri, int any, float kilograms) {
        this.barri = barri;
        this.any = any;
        this.kilograms = kilograms;
    }

    public Barri getBarri() {
        return barri;
    }

    public void setBarri(Barri barri) {
        this.barri = barri;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public float getKilograms() {
        return kilograms;
    }

    public void setKilograms(float kilograms) {
        this.kilograms = kilograms;
    }
}
