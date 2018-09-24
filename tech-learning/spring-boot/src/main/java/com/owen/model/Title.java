package com.owen.model;

import java.io.Serializable;
import java.util.Date;

public class Title extends TitleKey implements Serializable {
    private Date toDate;

    private static final long serialVersionUID = 1L;

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}