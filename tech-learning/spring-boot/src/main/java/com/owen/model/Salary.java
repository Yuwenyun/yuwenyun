package com.owen.model;

import java.io.Serializable;
import java.util.Date;

public class Salary extends SalaryKey implements Serializable {
    private Integer salary;

    private Date toDate;

    private static final long serialVersionUID = 1L;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}