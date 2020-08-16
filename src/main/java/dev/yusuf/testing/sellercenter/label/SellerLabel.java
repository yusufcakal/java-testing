package dev.yusuf.testing.sellercenter.label;

public enum SellerLabel {

    NEW_SELLER,
    SELLER_1,
    SELLER_5,
    SELLER_20;

    public boolean isSellerLabelNotNewSeller(){
        return SellerLabel.NEW_SELLER != this;
    }

    public boolean isSellerLabelOne(){
        return SellerLabel.SELLER_1 == this;
    }

    public boolean isSellerLabelTwenty(){
        return SellerLabel.SELLER_20 == this;
    }

}
