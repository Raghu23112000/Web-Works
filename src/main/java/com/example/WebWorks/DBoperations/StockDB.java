package com.example.WebWorks.DBoperations;

public class StockDB {
    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    private int cusid;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    @Override
    public String toString() {
        return "StockDB{" +
                "cusid=" + cusid +
                ", swg=" + swg +
                ", weight=" + weight +
                '}';
    }
}
