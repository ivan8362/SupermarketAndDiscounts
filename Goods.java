package com.lavrovivan;

public class Goods {
    private String name;
    private double price;
    private String unitOfMeasure;
    private String barCode;
    private DiscountType specialOfferType;
    private double discountedPrice = 0;
    int numberInCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (3 < name.length() && name.length() < 250) {
            this.name = name;
        } else System.out.println("Error. must be 250 > name.length() > 3");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.01) {
            this.price = price;
        } else System.out.println("error. price must be > 0.01");
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        if (unitOfMeasure.length() > 1 && unitOfMeasure.length() < 6) {
            this.unitOfMeasure = unitOfMeasure;
        } else System.out.println("error. unitOfmeasure must be > 1 and < 6");
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        if (barCode.length() == 13) {
            this.barCode = barCode;
        } else System.out.println("barCode.length() must be = 13. fill it with zeroes ");
    }

    public DiscountType getSpecialOfferType() {
        return specialOfferType;
    }

    public void setSpecialOfferType(DiscountType specialOfferType) {
        this.specialOfferType = specialOfferType;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
