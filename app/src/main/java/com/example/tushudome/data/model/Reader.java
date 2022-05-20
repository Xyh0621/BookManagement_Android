package com.example.tushudome.data.model;

import java.util.Date;

public class Reader {
    private String rdID;
    private String rdName;
    private String rdSex;
    private String rdSexStr;
    private Integer rdType;
    private String rdPhone;
    private String rdEmail;
    private Date rdDateReg;
    private Integer rdBorrowQty;
    private Integer rdStatus;
    private String rdStatusStr;
    private String rdPwd;
    private String rdTypeStr;

    public String getRdID() {
        return rdID;
    }

    public void setRdID(String rdID) {
        this.rdID = rdID;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdSex() {
        return rdSex;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
        if (rdSex.equals("m")){
            this.rdSexStr = "男";
        }
        else if(this.rdSex.equals("f")){
            this.rdSexStr = "女";
        }
    }

    public Integer getRdType() {
        return rdType;
    }

    public void setRdType(Integer rdType) {
        this.rdType = rdType;
    }

    public String getRdPhone() {
        return rdPhone;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public Date getRdDateReg() {
        return rdDateReg;
    }

    public void setRdDateReg(Date rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public Integer getRdBorrowQty() {
        return rdBorrowQty;
    }

    public void setRdBorrowQty(Integer rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public Integer getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(Integer rdStatus) {
        this.rdStatus = rdStatus;
        if(rdStatus == 0){
            rdStatusStr = "过期";
        }
        else if(rdStatus == 1){
            rdStatusStr = "有效";
        }
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }

    public String getRdSexStr() {
        return rdSexStr;
    }

    public String getRdStatusStr() {
        return rdStatusStr;
    }

    public String getRdTypeStr() {
        return rdTypeStr;
    }

    public void setRdTypeStr(String rdTypeStr) {
        this.rdTypeStr = rdTypeStr;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rdID='" + rdID + '\'' +
                ", rdName='" + rdName + '\'' +
                ", rdSex='" + rdSex + '\'' +
                ", rdSexStr='" + rdSexStr + '\'' +
                ", rdType=" + rdType +
                ", rdPhone='" + rdPhone + '\'' +
                ", rdEmail='" + rdEmail + '\'' +
                ", rdDateReg=" + rdDateReg +
                ", rdBorrowQty=" + rdBorrowQty +
                ", rdStatus=" + rdStatus +
                ", rdStatusStr='" + rdStatusStr + '\'' +
                ", rdPwd='" + rdPwd + '\'' +
                ", rdTypeStr='" + rdTypeStr + '\'' +
                '}';
    }
}
