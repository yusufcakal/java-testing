package dev.yusuf.testing.sellercenter.processor;

import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.processor.base.SellerLabelProcessor;
import org.springframework.stereotype.Service;

@Service
public class SellerLabelOneProcessor implements SellerLabelProcessor {

    @Override
    public SellerLabel getSellerLabel(int sellCount) {
        return sellCount >= 1 && sellCount < 5 ? SellerLabel.SELLER_1 : SellerLabel.NEW_SELLER;
    }
}
