package dev.yusuf.testing.sellercenter.service;

import dev.yusuf.testing.builder.SellerBuilder;
import dev.yusuf.testing.sellercenter.label.SellerCenterLabel;
import dev.yusuf.testing.sellercenter.label.SellerLabel;
import dev.yusuf.testing.sellercenter.model.Seller;
import dev.yusuf.testing.sellercenter.processor.SellerLabelFiveProcessor;
import dev.yusuf.testing.sellercenter.processor.SellerLabelOneProcessor;
import dev.yusuf.testing.sellercenter.processor.SellerLabelTwentyProcessor;
import dev.yusuf.testing.sellercenter.processor.base.SellerLabelProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SellerCenterServiceTest {

    @Mock
    private SellerLabelOneProcessor sellerLabelOneProcessor;

    @Mock
    private SellerLabelFiveProcessor sellerLabelFiveProcessor;

    @Mock
    private SellerLabelTwentyProcessor sellerLabelTwentyProcessor;

    private SellerCenterService sellerCenterService;

    @Before
    public void setUp() {
        List<SellerLabelProcessor> sellerLabelProcessors = Arrays.asList(sellerLabelTwentyProcessor, sellerLabelFiveProcessor, sellerLabelOneProcessor);
        sellerCenterService = new SellerCenterService(sellerLabelProcessors);
    }

    @Test
    public void shouldGetWorstSellerCenterLabelWhenSellerLabelOne() {
        int sellCount = 3;
        Seller seller = SellerBuilder.aSellerBuilder()
                .sellCount(sellCount)
                .previousSellerLabel(SellerLabel.SELLER_5)
                .build();

        when(sellerLabelTwentyProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.NEW_SELLER);
        when(sellerLabelFiveProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.NEW_SELLER);
        when(sellerLabelOneProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.SELLER_1);

        SellerCenterLabel sellerCenterLabel = sellerCenterService.getSellerCenterLabel(seller);

        verify(sellerLabelTwentyProcessor).getSellerLabel(sellCount);
        verify(sellerLabelFiveProcessor).getSellerLabel(sellCount);
        verify(sellerLabelOneProcessor).getSellerLabel(sellCount);

        assertTrue(sellerCenterLabel.isSellerCenterLabelWorstSeller());
    }

    @Test
    public void shouldGetAverageSellerCenterLabelWhenSellerLabelFive() {
        int sellCount = 6;
        Seller seller = SellerBuilder.aSellerBuilder()
                .sellCount(sellCount)
                .previousSellerLabel(SellerLabel.SELLER_1)
                .build();

        when(sellerLabelTwentyProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.NEW_SELLER);
        when(sellerLabelFiveProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.SELLER_5);

        SellerCenterLabel sellerCenterLabel = sellerCenterService.getSellerCenterLabel(seller);

        verify(sellerLabelTwentyProcessor).getSellerLabel(sellCount);
        verify(sellerLabelFiveProcessor).getSellerLabel(sellCount);

        assertTrue(sellerCenterLabel.isSellerCenterLabelAverageSeller());
    }

    @Test
    public void shouldGetAverageSellerCenterLabelWhenSellerLabelOneButSellerPreviousLabelTwenty() {
        int sellCount = 3;
        Seller seller = SellerBuilder.aSellerBuilder()
                .sellCount(sellCount)
                .previousSellerLabel(SellerLabel.SELLER_20)
                .build();

        when(sellerLabelTwentyProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.NEW_SELLER);
        when(sellerLabelFiveProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.NEW_SELLER);
        when(sellerLabelOneProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.SELLER_1);

        SellerCenterLabel sellerCenterLabel = sellerCenterService.getSellerCenterLabel(seller);

        verify(sellerLabelTwentyProcessor).getSellerLabel(sellCount);
        verify(sellerLabelFiveProcessor).getSellerLabel(sellCount);
        verify(sellerLabelOneProcessor).getSellerLabel(sellCount);

        assertTrue(sellerCenterLabel.isSellerCenterLabelAverageSeller());
    }

    @Test
    public void shouldGetBestSellerCenterLabelWhenSellerLabelTwenty() {
        int sellCount = 25;
        Seller seller = SellerBuilder.aSellerBuilder()
                .sellCount(sellCount)
                .previousSellerLabel(SellerLabel.SELLER_5)
                .build();

        when(sellerLabelTwentyProcessor.getSellerLabel(sellCount)).thenReturn(SellerLabel.SELLER_20);

        SellerCenterLabel sellerCenterLabel = sellerCenterService.getSellerCenterLabel(seller);

        verify(sellerLabelTwentyProcessor).getSellerLabel(sellCount);

        assertTrue(sellerCenterLabel.isSellerCenterLabelBestSeller());
    }

}
