package com.lavrovivan;

public enum DiscountType {
    THIRDFORFREE(0), HALFFOR2ND3RDFREE(0), PERCENTAGE(25);
    private int discountPercentage;

    DiscountType(int p) {
        this.discountPercentage = p;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
