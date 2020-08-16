package dev.yusuf.testing.sellercenter.processor;

import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.processor.base.SellerLabelProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class SellerLabelFiveProcessor implements SellerLabelProcessor {

    @Override
    public SellerLabel getSellerLabel(int sellCount) {
        return sellCount >= 5 && sellCount < 20 ? SellerLabel.SELLER_5 : SellerLabel.NEW_SELLER;
    }

}