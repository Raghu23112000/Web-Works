package com.example.WebWorks.DBoperations;

public class CustomerDB {
    private int PlatCode;
    private String Name;
    private String Org;
    private String DOB;
    private String uname;
    private String pass;
    private String Key;
    private String ActiDate;
    private int AdminStatus;

    public int getAdminStatus() {
        return AdminStatus;
    }

    public void setAdminStatus(int adminStatus) {
        AdminStatus = adminStatus;
    }

    public String getActiDate() {
        return ActiDate;
    }

    public void setActiDate(String actiDate) {
        ActiDate = actiDate;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getOrg() {
        return Org;
    }

    public void setOrg(String org) {
        Org = org;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPlatCode() {
        return PlatCode;
    }

    public void setPlatCode(int platCode) {
        PlatCode = platCode;
    }

    @Override
    public String toString() {
        return "CustomerDB{" +
                "PlatCode=" + PlatCode +
                ", Name='" + Name + '\'' +
                ", Org='" + Org + '\'' +
                ", DOB='" + DOB + '\'' +
                ", uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                ", Key='" + Key + '\'' +
                ", ActiDate='" + ActiDate + '\'' +
                ", AdminStatus=" + AdminStatus +
                '}';
    }
}
