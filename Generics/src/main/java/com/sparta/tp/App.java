package com.sparta.tp;

public class App {
    public static void main(String[] args) {
        IntegerRectangle integerRectangle = new IntegerRectangle(2, 4);
        DoubleRectangle doubleRectangle = new DoubleRectangle(2.0, 4.0);
        ObjectRectangle objectRectangle1 = new ObjectRectangle(2, 4);
        System.out.printf("Integer Rectangle Area: %d\n",integerRectangle.getWidth() * integerRectangle.getHeight());
        System.out.printf("Double Rectangle Area: %f\n",doubleRectangle.getWidth() * doubleRectangle.getHeight());
        System.out.printf("Object Integer Rectangle Area: %d\n", (Integer)objectRectangle1.getWidth() * (Integer)objectRectangle1.getLength());

        GenericRectangle<? extends Integer> integerGenericRectangle = new GenericRectangle<>(2, 4);
        GenericRectangle<Double> doubleGenericRectangle = new GenericRectangle<>(2.0, 4.0);

        System.out.printf("integer Generic Rectangle: %d\n", integerGenericRectangle.getHeight()*integerGenericRectangle.getWidth());
        System.out.printf("double Generic Rectangle: %f\n", doubleGenericRectangle.getHeight()*doubleGenericRectangle.getWidth());

    }
}
