package com.owen.model;

import java.io.Serializable;
import java.util.Date;

public class Registry extends RegistryKey implements Serializable {
    private Date fromDate;

    private Date toDate;

    private static final long serialVersionUID = 1L;

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