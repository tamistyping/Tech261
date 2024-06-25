package com.sparta.tp.decorator;

import com.sparta.tp.decorator.sides.Chips;
import com.sparta.tp.decorator.sides.Salad;

public class App {
    public static void main(String[] args) {
        Italian italian = new Italian();
        System.out.println(italian.getDescription() + " Cost: " + italian.getCost());

        Salad salad = new Salad(italian);
        System.out.println(salad.getDescription() + " cost: " + salad.getCost());

        Chips chips = new Chips(salad);
        System.out.println(chips.getDescription() + " cost: " + chips.getCost());
    }
}
