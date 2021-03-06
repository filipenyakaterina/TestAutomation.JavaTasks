package threads.services;

import threads.auctionContainers.BidderList;
import threads.auctionEntities.Bidder;

public class Auction {
    private BidderList bidders;

    public static final int BIDDERS_COUNT = 5;

    public Auction() {
            bidders = new BidderList(BIDDERS_COUNT);
    }

    public void start(){
        PaymentController paymentController = new PaymentController();
        paymentController.setDaemon(true);
        paymentController.start();
        for (Bidder bidder : bidders.getBidders()) {
            bidder.start();
        }
    }

}
