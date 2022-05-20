package com.example.tushudome.data.model;

import java.util.Date;

public class Borrow {
    private Integer BorrowID          ;
    private Integer rdID              ;
    private Integer bkID              ;
    private Integer IdContinueTimes   ;
    private Date IdDateOut         ;
    private Date IdDateRetPlan     ;
    private Date IdDateRetAct      ;
    private Integer IdOverDay         ;
    private Double IdOverMoney       ;
    private Double IdPunishMoney     ;
    private Integer IsHasReturn       ;
    private String OperatorLend      ;
    private String OperatorRet       ;

    public Integer getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(Integer borrowID) {
        BorrowID = borrowID;
    }

    public Integer getRdID() {
        return rdID;
    }

    public void setRdID(Integer rdID) {
        this.rdID = rdID;
    }

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public Integer getIdContinueTimes() {
        return IdContinueTimes;
    }

    public void setIdContinueTimes(Integer idContinueTimes) {
        IdContinueTimes = idContinueTimes;
    }

    public Date getIdDateOut() {
        return IdDateOut;
    }

    public void setIdDateOut(Date idDateOut) {
        IdDateOut = idDateOut;
    }

    public Date getIdDateRetPlan() {
        return IdDateRetPlan;
    }

    public void setIdDateRetPlan(Date idDateRetPlan) {
        IdDateRetPlan = idDateRetPlan;
    }

    public Date getIdDateRetAct() {
        return IdDateRetAct;
    }

    public void setIdDateRetAct(Date idDateRetAct) {
        IdDateRetAct = idDateRetAct;
    }

    public Integer getIdOverDay() {
        return IdOverDay;
    }

    public void setIdOverDay(Integer idOverDay) {
        IdOverDay = idOverDay;
    }

    public Double getIdOverMoney() {
        return IdOverMoney;
    }

    public void setIdOverMoney(Double idOverMoney) {
        IdOverMoney = idOverMoney;
    }

    public Double getIdPunishMoney() {
        return IdPunishMoney;
    }

    public void setIdPunishMoney(Double idPunishMoney) {
        IdPunishMoney = idPunishMoney;
    }

    public Integer getIsHasReturn() {
        return IsHasReturn;
    }

    public void setIsHasReturn(Integer isHasReturn) {
        IsHasReturn = isHasReturn;
    }

    public String getOperatorLend() {
        return OperatorLend;
    }

    public void setOperatorLend(String operatorLend) {
        OperatorLend = operatorLend;
    }

    public String getOperatorRet() {
        return OperatorRet;
    }

    public void setOperatorRet(String operatorRet) {
        OperatorRet = operatorRet;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "BorrowID=" + BorrowID +
                ", rdID=" + rdID +
                ", bkID=" + bkID +
                ", IdContinueTimes=" + IdContinueTimes +
                ", IdDateOut=" + IdDateOut +
                ", IdDateRetPlan=" + IdDateRetPlan +
                ", IdDateRetAct=" + IdDateRetAct +
                ", IdOverDay=" + IdOverDay +
                ", IdOverMoney=" + IdOverMoney +
                ", IdPunishMoney=" + IdPunishMoney +
                ", IsHasReturn=" + IsHasReturn +
                ", OperatorLend='" + OperatorLend + '\'' +
                ", OperatorRet='" + OperatorRet + '\'' +
                '}';
    }
}
