package com.company;

import java.util.Date;

public abstract class Insurance {
    private int id;
    private String name;
    private Double price;
    private Date startingDate;
    private Date endDate;

    public abstract void Calculate();
}
