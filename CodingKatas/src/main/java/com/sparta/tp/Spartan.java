package com.sparta.tp;

import java.time.LocalDate;

public class Spartan {
    public int getId(){
        return 0;
    }

    public void setName(String name){

    }

    public int getName(){
        return 0;
    }

    public LocalDate getStartDate(){
        return null;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "id=" + getId() +
                ", name='" + getName() + "\'" +
                ", startDate" + getStartDate() +
                "}";
    }
}
