package com.example.WebWorks.RewindNotes;

public class Alternate {
    public float getSwg() {
        return swg;
    }

    public void setSwg(float swg) {
        this.swg = swg;
    }

    private float swg;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    private float weight;

    @Override
    public String toString() {
        return "Alternate{" +
                "swg=" + swg +
                ", weight=" + weight +
                '}';
    }

    Alternate(float sw, float we)
    {
        swg=sw;
        weight=we;
    }
}
