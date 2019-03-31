package com.lavrovivan;

import java.util.ArrayList;

public class Cart {
    ArrayList<Goods> myGoods = new ArrayList<Goods>();

    void insertIntoCart(Goods ... good){
        for (int i = 0; i < good.length; i++) {
            myGoods.add(good[i]);
            myGoods.get(i).numberInCard = i;
        }
    }

    double countTotal(){
        double sum = 0;

        for (Goods g : myGoods) {
            sum += g.getPrice();
        }
        return sum;
    }

    void printTotal(double sum){
        System.out.println("Your cart pre-discounted total is: " + sum);
    }

    /*void printCart(){
        for (Goods g : myGoods) {
            System.out.println(g.getBarCode());
        }
    }*/
}
