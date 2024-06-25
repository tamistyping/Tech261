package com.sparta.tp.decorator.sides;
import com.sparta.tp.decorator.Pizza;
public abstract class Sides extends Pizza{
    protected Pizza pizza;

    public Sides(Pizza pizza){
        this.pizza = pizza;
    }

    public abstract String getDescription();
}
