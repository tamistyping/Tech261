package com.sparta.tp.singleton;

public class SingletonExample {

    private static final SingletonExample SINGLETON_EXAMPLE = new SingletonExample();

    private SingletonExample(){

    }

    public static SingletonExample getSingletonExample(){
        return SINGLETON_EXAMPLE;
    }
}
