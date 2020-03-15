package threads.auctionContainers;

import threads.auctionEntities.Bidder;
import java.util.ArrayList;

public class BidderList {
    private ArrayList<Bidder> bidders;

    public BidderList(int count){
        bidders = new ArrayList<>(count);

        for (int i=0 ; i< count ; i++){
            bidders.add(new Bidder(i));
        }
    }

    public ArrayList<Bidder> getBidders() {
        return bidders;
    }
}
