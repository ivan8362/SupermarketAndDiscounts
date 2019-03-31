package com.lavrovivan;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillTest {

    @Test
    public void markAsDicounted3rdFree() {
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

        Cart cart = new Cart();
        cart.insertIntoCart(g, g1, g2);
        Bill bill = new Bill(cart);
        assertEquals(200.01, bill.getDiscountedTotal(), 0);
    }

    @Test
    public void markAsDiscountedSecondForHalf() {
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

        Bill b = new Bill(cart);
        assertEquals(150.01, b.getDiscountedTotal(), 0);
    }

    @Test
    public void markAsDiscountedPercentage() {
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

        Bill b = new Bill(cart);
        double toPay = b.getDiscountedTotal();
        assertEquals(1082.5, b.getDiscountedTotal(), 0);
    }

    /*@Test
    public void getDiscountedTotal() {

    }*/
}