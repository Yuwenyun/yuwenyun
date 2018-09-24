package com.owen.model;

import java.io.Serializable;
import java.util.Date;

public class LatestDate implements Serializable {
    private Integer empNo;

    private Date fromDate;

    private Date toDate;

    private static final long serialVersionUID = 1L;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}