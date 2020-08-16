package dev.yusuf.testing.builder;

import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.model.Seller;

public class SellerBuilder {

    private int sellCount;
    private SellerLabel previousSellerLabel;

    private SellerBuilder() {
    }

    public static SellerBuilder aSellerBuilder() {
        return new SellerBuilder();
    }

    public SellerBuilder sellCount(int sellCount) {
        this.sellCount = sellCount;
        return this;
    }

    public SellerBuilder previousSellerLabel(SellerLabel previousSellerLabel) {
        this.previousSellerLabel = previousSellerLabel;
        return this;
    }

    public Seller build() {
        return Seller.create(sellCount, previousSellerLabel);
    }

}
