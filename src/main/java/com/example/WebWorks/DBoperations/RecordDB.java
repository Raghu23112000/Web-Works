package com.example.WebWorks.DBoperations;

public class RecordDB {
    private int RecordName;
    private String RecordDetails;
    private int Cusid;

    public int getRecordName(){
        return RecordName;
    }
    public void setRecordName(int recordName){
        RecordName=recordName;
    }
    public String getRecordDetails(){
        return RecordDetails;
    }
    public void setRecordDetails(String recordDetails){
        RecordDetails=recordDetails;
    }
    public int getCusid(){
        return Cusid;
    }
    public void setCusid(int cusid) {
        Cusid = cusid;
    }

    @Override
    public String toString() {
        return "RecordDB{" +
                "RecordName=" + RecordName +
                ", RecordDetails='" + RecordDetails + '\'' +
                ", Cusid=" + Cusid +
                '}';
    }
}
