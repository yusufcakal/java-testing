package dev.yusuf.testing.sellercenter.processor;

import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.processor.base.SellerLabelProcessor;
import org.springframework.stereotype.Service;

@Service
public class SellerLabelTwentyProcessor implements SellerLabelProcessor {

    @Override
    public SellerLabel getSellerLabel(int sellCount) {
        return sellCount >= 20 ? SellerLabel.SELLER_5 : SellerLabel.NEW_SELLER;
    }
}
