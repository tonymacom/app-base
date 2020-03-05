package com.tony.extend.supe;

import lombok.Data;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/5
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */

public class Plate<T> {

    private T fruit;

    public Plate(T t){
        this.fruit = t;
    }

    public void set(T t) {
        this.fruit = t;
    }

    public T get(){
        return fruit;
    }

    public static void main(String[] args) {
        Plate<? super Fruit> plate = new Plate<>(new Apple());
        plate.set(new Fruit());
        plate.set(new Apple());

        Apple food = (Apple)plate.get();
        System.out.println(food.getA());

    }

    @Data
    public static class Food{
        int a = 1;
    }

    public static class Fruit extends Food{}

    public static class Apple extends Fruit{}


}

