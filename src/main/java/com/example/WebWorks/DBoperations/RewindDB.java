package com.example.WebWorks.DBoperations;

public class RewindDB {
    private int cusid;
    private float hp;
    private float swg;
    private float weight;
    private String det;

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getDet() {
        return det;
    }

    public void setDet(String det) {
        this.det = det;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSwg() {
        return swg;
    }

    public void setSwg(float swg) {
        this.swg = swg;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "RewindDB{" +
                "hp=" + hp +
                ", swg=" + swg +
                ", weight=" + weight +
                ", det='" + det + '\'' +
                '}';
    }
}
