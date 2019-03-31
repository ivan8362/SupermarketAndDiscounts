package com.lavrovivan;

public class Main {

    public static void main(String[] args) {
        // test discount 3rd for free
        if (false) {
            Goods g = new Goods();
            g.setBarCode("1234567890123");
            g.setName("iphone");
            g.setPrice(100.0);
            g.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Goods g1 = new Goods();
            g1.setBarCode("1234567890124");
            g1.setName("iphone1");
            g1.setPrice(100.0);
            g1.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Goods g2 = new Goods();
            g2.setBarCode("1234567890125");
            g2.setName("iphone2");
            g2.setPrice(100.0);
            g2.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Goods g3 = new Goods();
            g3.setBarCode("1234567890126");
            g3.setName("iphone2");
            g3.setPrice(1000.0);
            g3.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Goods g4 = new Goods();
            g4.setBarCode("1234567890126");
            g4.setName("iphone2");
            g4.setPrice(100.0);
            g4.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Goods g5 = new Goods();
            g5.setBarCode("1234567890126");
            g5.setName("iphone2");
            g5.setPrice(100.0);
            g5.setSpecialOfferType(DiscountType.THIRDFORFREE);

            Cart cart = new Cart();
            cart.insertIntoCart(g, g1, g2, g3, g4, g5);

            double sum = cart.countTotal();
            cart.printTotal(sum);

            Bill b = new Bill(cart);
            double toPay = b.getDiscountedTotal();
            b.printDiscountedTotal(toPay);
        }
        if (false) {
            //test 2nd for half 3rd for free discount
            Goods g = new Goods();
            g.setBarCode("1234567890123");
            g.setName("iphone");
            g.setPrice(10.0);
            g.setSpecialOfferType(DiscountType.HALFFOR2ND3RDFREE);

            Goods g1 = new Goods();
            g1.setBarCode("1234567890124");
            g1.setName("iphone1");
            g1.setPrice(100.0);
            g1.setSpecialOfferType(DiscountType.HALFFOR2ND3RDFREE);

            Goods g2 = new Goods();
            g2.setBarCode("1234567890125");
            g2.setName("iphone2");
            g2.setPrice(100.0);
            g2.setSpecialOfferType(DiscountType.HALFFOR2ND3RDFREE);

            Cart cart = new Cart();
            cart.insertIntoCart(g, g1, g2);

            double sum = cart.countTotal();
            cart.printTotal(sum);

            Bill b = new Bill(cart);
            double toPay = b.getDiscountedTotal();
            b.printDiscountedTotal(toPay);
        }
        if (true) {
            //test percentage discount
            Goods g = new Goods();
            g.setBarCode("1234567890123");
            g.setName("iphone");
            g.setPrice(10.0);
            g.setSpecialOfferType(DiscountType.PERCENTAGE);

            Goods g1 = new Goods();
            g1.setBarCode("1234567890124");
            g1.setName("iphone1");
            g1.setPrice(100.0);
            g1.setSpecialOfferType(DiscountType.PERCENTAGE);

            Goods g2 = new Goods();
            g2.setBarCode("1234567890125");
            g2.setName("iphone2");
            g2.setPrice(1000.0);
            g2.setSpecialOfferType(DiscountType.HALFFOR2ND3RDFREE);

            Cart cart = new Cart();
            cart.insertIntoCart(g, g1, g2);

            double sum = cart.countTotal();
            cart.printTotal(sum);

            Bill b = new Bill(cart);
            double toPay = b.getDiscountedTotal();
            b.printDiscountedTotal(toPay);
        }
    }
}

