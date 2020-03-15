package threads.auctionEntities;

import threads.states.BidState;

public class Bid {
    private final long ID;
    private int price;
    private Lot lot;
    private Bidder bidder;
    private BidState state;

    public Bid(long ID, int price, Lot lot, Bidder bidder, BidState state) {
        this.ID = ID;
        this.price = price;
        this.lot = lot;
        this.bidder = bidder;
        this.state = state;
    }

    public BidState getState() {
        return state;
    }

    public void setState(BidState state) {
        this.state = state;
    }

    public long getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public Lot getLot() {
        return lot;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
