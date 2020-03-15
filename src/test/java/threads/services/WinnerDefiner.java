package threads.services;

import threads.auctionContainers.BidList;
import threads.auctionContainers.LotList;
import threads.auctionContainers.WinnersList;
import threads.auctionEntities.Bid;
import threads.auctionEntities.Lot;
import threads.states.BidState;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WinnerDefiner {

    public static void define(long lotID) throws InterruptedException {
        Lot lot = LotList.searchByID(lotID);
        List<Bid> bidsWithLot = BidList.getBidsByLot(lot);
        if (!bidsWithLot.isEmpty()){
            Bid winnerBid = Collections.max(BidList.getBidsByLot(lot), Comparator.comparingInt(Bid::getPrice));
            winnerBid.setState(BidState.AWAITING_PAYMENT);
            WinnersList.add(winnerBid);
            System.out.println("Lot " + Objects.requireNonNull(lot).getName() + " goes to the bidder №" + winnerBid.getBidder().getID());
            winnerBid.getBidder().executePayment(winnerBid);

        }
        else {
            System.out.println("Lot " + Objects.requireNonNull(lot).getName() + " is not passed to any of the bidders");
        }
    }
}
