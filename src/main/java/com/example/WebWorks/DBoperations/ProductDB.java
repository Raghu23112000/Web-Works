package com.example.WebWorks.DBoperations;

public class ProductDB {
    private int PlatCode;
    private String Plat;
    private String Org;
    private String Key;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPlatCode() {
        return PlatCode;
    }
    public void setPlatCode(int platCode) {
        PlatCode = platCode;
    }
    public String getPlat() {
        return Plat;
    }
    public void setPlat(String plat) {
        Plat = plat;
    }
    public String getOrg() {
        return Org;
    }
    public void setOrg(String org) {
        Org = org;
    }
    public String getKey() {
        return Key;
    }
    public void setKey(String key) {
        Key = key;
    }
    @Override
    public String toString() {
        return "ProductDB{" +
                "PlatCode=" + PlatCode +
                ", Plat='" + Plat + '\'' +
                ", Org='" + Org + '\'' +
                ", Key='" + Key + '\'' +
                '}';
    }
}
