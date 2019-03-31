package com.lavrovivan;

import java.util.ArrayList;

public class Bill {
    private Cart cart;
    private ArrayList<Goods> myGoods;

    Bill(Cart cart){
        this.cart = cart;
        this.myGoods = cart.myGoods;
    }

    private void markAsDicounted3rdFree(){
        // third for free discount
        // count how many
        int i = 0;
        for (Goods aGoods : myGoods) {
            if (aGoods.getSpecialOfferType() == DiscountType.THIRDFORFREE) {
                i++;
                if (i == 3) {
                    i = 0;
                    // for the third item set price = 0.01
                    aGoods.setDiscountedPrice(0.01);
                }
            }
        }
    }

    private void markAsDiscountedSecondForHalf() {
        int i = -1;
        Goods[] secondForHalf = new Goods[3];
        for (int k = 0; k < myGoods.size(); k++) {
            Goods aGoods = myGoods.get(k);
            if (aGoods.getSpecialOfferType() == DiscountType.HALFFOR2ND3RDFREE) {
                i++;
                secondForHalf[i] = aGoods;

                if (i == 2) {
                    // find the cheapest item from triplet
                    Goods cheapest = secondForHalf[0];
                    for (int j = 1; j < 3; j++) {
                        if (secondForHalf[j].getPrice() < cheapest.getPrice()) {
                            cheapest = secondForHalf[j];
                        }
                    }
                    // for the third item set price = 0.01
                    cheapest.setDiscountedPrice(0.01);

                    // for another item set price = 50% from the original price
                    if (secondForHalf[0].getDiscountedPrice() == 0) {
                        secondForHalf[0].setDiscountedPrice(secondForHalf[0].getPrice() / 2);
                    } else if (secondForHalf[1].getDiscountedPrice() == 0) {
                        secondForHalf[1].setDiscountedPrice(secondForHalf[1].getPrice() / 2);
                    } else secondForHalf[2].setDiscountedPrice(secondForHalf[2].getPrice() / 2);
                    // empty temporary array
                    for (Goods g : secondForHalf) { g = null; }
                    i = -1;
                }
            }
        }
    }

    private void markAsDiscountedPercentage(){
        for (Goods aGoods : myGoods) {
            if (aGoods.getSpecialOfferType() == DiscountType.PERCENTAGE) {
                aGoods.setDiscountedPrice(
                        aGoods.getPrice() * (100 - DiscountType.PERCENTAGE.getDiscountPercentage()) / 100);
            }
        }
    }

    double getDiscountedTotal(){
        markAsDicounted3rdFree();
        markAsDiscountedSecondForHalf();
        markAsDiscountedPercentage();
        double sum = 0;

        for (Goods g : cart.myGoods) {
            if (g.getDiscountedPrice() != 0) {
                sum += g.getDiscountedPrice();
            } else {
                sum += g.getPrice();
            }
        }
        return sum;
    }

    void printDiscountedTotal(double sum){
        System.out.println("Your cart discounted total is: " + sum);
    }
}
