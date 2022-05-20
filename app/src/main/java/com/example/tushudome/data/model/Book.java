package com.example.tushudome.data.model;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
            private Integer bkID           ;
            private Integer bkCode         ;
            private String bkName         ;
            private String bkAuthor       ;
            private String bkPress        ;

            @JSONField(format = "yyyy-MM-dd")
            private Date bkDatePress    ;

            private String bkISBN         ;
            private String bkCatalog      ;
            private Integer bkLanguage     ;
            private Integer bkPages        ;
            private Double bkPrice        ;
            @JSONField(format = "yyyy-MM-dd")
            private Date bkDateln       ;
            private String bkBrief        ;
            private Integer bkStatus       ;
            private String bkStatusStr    ;

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public Integer getBkCode() {
        return bkCode;
    }

    public void setBkCode(Integer bkCode) {
        this.bkCode = bkCode;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public Date getBkDatePress() {
        return bkDatePress;
    }

    public void setBkDatePress(Date bkDatePress) {
        this.bkDatePress = bkDatePress;
    }

    public String getBkISBN() {
        return bkISBN;
    }

    public void setBkISBN(String bkISBN) {
        this.bkISBN = bkISBN;
    }

    public String getBkCatalog() {
        return bkCatalog;
    }

    public void setBkCatalog(String bkCatalog) {
        this.bkCatalog = bkCatalog;
    }

    public Integer getBkLanguage() {
        return bkLanguage;
    }

    public void setBkLanguage(Integer bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public Integer getBkPages() {
        return bkPages;
    }

    public void setBkPages(Integer bkPages) {
        this.bkPages = bkPages;
    }

    public Double getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(Double bkPrice) {
        this.bkPrice = bkPrice;
    }

    public Date getBkDateln() {
        return bkDateln;
    }

    public void setBkDateln(Date bkDateln) {
        this.bkDateln = bkDateln;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public Integer getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(Integer bkStatus) {
        this.bkStatus = bkStatus;
        if(bkStatus == 0){
            this.bkStatusStr = "已借出";
        }
        if(bkStatus == 1){
            this.bkStatusStr = "在馆";
        }
    }

    public String getBkStatusStr() {
        return bkStatusStr;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bkID=" + bkID +
                ", bkCode=" + bkCode +
                ", bkName='" + bkName + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPress='" + bkPress + '\'' +
                ", bkDatePress=" + bkDatePress +
                ", bkISBN='" + bkISBN + '\'' +
                ", bkCatalog='" + bkCatalog + '\'' +
                ", bkLanguage=" + bkLanguage +
                ", bkPages=" + bkPages +
                ", bkPrice=" + bkPrice +
                ", bkDateln=" + bkDateln +
                ", bkBrief='" + bkBrief + '\'' +
                ", bkStatus=" + bkStatus +
                ", bkStatusStr='" + bkStatusStr + '\'' +
                '}';
    }
}
