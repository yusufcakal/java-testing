package dev.yusuf.testing.sellercenter.model;

import dev.yusuf.testing.sellercenter.label.SellerLabel;

public class Seller {

    private final int sellCount;
    private final SellerLabel previousSellerLabel;

    private Seller(int sellCount, SellerLabel previousSellerLabel) {
        this.sellCount = sellCount;
        this.previousSellerLabel = previousSellerLabel;
    }

    public static Seller create(int sellCount, SellerLabel previousSellerLabel) {
        return new Seller(sellCount, previousSellerLabel);
    }

    public int getSellCount() {
        return sellCount;
    }

    public SellerLabel getPreviousSellerLabel() {
        return previousSellerLabel;
    }

}
