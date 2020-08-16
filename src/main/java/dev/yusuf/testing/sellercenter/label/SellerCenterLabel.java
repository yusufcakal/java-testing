package dev.yusuf.testing.sellercenter.label;

import dev.yusuf.testing.sellercenter.exception.SellerCenterLabelNotFoundException;

import java.util.Arrays;

public enum SellerCenterLabel {

    WORST_SELLER(SellerLabel.SELLER_1),
    AVERAGE_SELLER(SellerLabel.SELLER_5),
    BEST_SELLER(SellerLabel.SELLER_20);

    private final SellerLabel sellerLabel;

    SellerCenterLabel(SellerLabel sellerLabel) {
        this.sellerLabel = sellerLabel;
    }

    public static SellerCenterLabel getSellerCenterLabel(SellerLabel sellerLabel) {
        return Arrays.stream(values())
                .filter(sellerCenterLabel -> sellerCenterLabel.getSellerLabel().equals(sellerLabel))
                .findFirst()
                .orElseThrow(SellerCenterLabelNotFoundException::new);
    }

    public boolean isSellerCenterLabelWorstSeller(){
        return SellerCenterLabel.WORST_SELLER.equals(this);
    }

    public boolean isSellerCenterLabelAverageSeller(){
        return SellerCenterLabel.AVERAGE_SELLER.equals(this);
    }

    public boolean isSellerCenterLabelBestSeller(){
        return SellerCenterLabel.BEST_SELLER.equals(this);
    }

    public SellerLabel getSellerLabel() {
        return sellerLabel;
    }

}
