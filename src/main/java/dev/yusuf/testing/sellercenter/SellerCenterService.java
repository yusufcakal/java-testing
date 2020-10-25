package dev.yusuf.testing.sellercenter;

import dev.yusuf.testing.sellercenter.label.SellerCenterLabel;
import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.model.Seller;
import dev.yusuf.testing.sellercenter.processor.base.SellerLabelProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerCenterService {

    private final List<SellerLabelProcessor> sellerLabelProcessors;

    public SellerCenterService(List<SellerLabelProcessor> sellerLabelProcessors) {
        this.sellerLabelProcessors = sellerLabelProcessors;
    }

    public SellerCenterLabel getSellerCenterLabel(Seller seller) {
        final SellerLabel sellerLabel = sellerLabelProcessors.stream()
                .map(sellerLabelProcessor -> sellerLabelProcessor.getSellerLabel(seller.getSellCount()))
                .filter(SellerLabel::isSellerLabelNotNewSeller)
                .findFirst()
                .orElse(SellerLabel.NEW_SELLER);

        if (sellerLabel.isSellerLabelOne() && seller.getPreviousSellerLabel().isSellerLabelTwenty()) {
            return SellerCenterLabel.getSellerCenterLabel(SellerLabel.SELLER_5);
        }

        return SellerCenterLabel.getSellerCenterLabel(sellerLabel);
    }

}
