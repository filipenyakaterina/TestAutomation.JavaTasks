package threads.auctionEntities;

import threads.auctionContainers.BidList;
import threads.auctionContainers.LotList;
import threads.services.Locking;
import threads.states.BidState;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Bidder extends Thread{
    private final long ID;
    private Locking locking;

    public Bidder(long ID) {
        this.ID = ID;
        this.locking = new Locking();
    }

    public long getID() {
        return ID;
    }

    public void lock(int lotsCount){
        this.locking.setLocked(true);
        this.locking.setLotsCount(lotsCount);
    }

    public void makeBid(Lot lot)
    {
        int amount = new Random().nextInt(1000);
        BidList.add(lot, amount,this);
        System.out.println("Bidder №" + ID + " made a bid on the lot " + lot.getName() + " in the amount of " + amount + " dollars");
    }

    public void changeBid(Lot lot)
    {
        if(BidList.isBidExist(this,lot)){
            Bid bid = BidList.get(this, lot);
            int amountIncrease = new Random().nextInt(500);
            int newPrice = Objects.requireNonNull(bid).getPrice() + amountIncrease;
            bid.setPrice(newPrice);
            System.out.println("Bidder №" + ID + " raised the bid on the lot " + lot.getName() + " to " + newPrice + " dollars");
        }

    }

    public void executePayment(Bid winnerBid) throws InterruptedException {
        Thread.sleep(3000);

        if(new Random().nextBoolean()){
            winnerBid.setState(BidState.PAID);
            System.out.println("Bidder №" + ID + " paid the lot " + winnerBid.getLot().getName() );
        }
        else{
            System.out.println("Bidder №" + ID + " did not pay the lot " + winnerBid.getLot().getName() );
        }
    }

    @Override
    public void run() {
        try {
            for (Lot lot : LotList.getLots()) {
                Thread.sleep(1500);
                if(!locking.isLocked()){
                    int randomNumberForMakeBid = new Random().nextInt(10);

                    Thread.sleep(randomNumberForMakeBid * 1000);
                    if(new Random().nextBoolean()){
                        makeBid(lot);
                    }
                    else{
                        System.out.println("Bidder №" + ID + " ignored the lot " + lot.getName() );
                    }

                    int randomNumberForChangeBid = new Random().nextInt(10);
                    for(int i=0; i < new Random().nextInt(5); i++){
                        Thread.sleep(randomNumberForChangeBid * 1000);
                        if(new Random().nextBoolean()){
                            changeBid(lot);
                        }
                        else{
                            System.out.println("Bidder №" + ID + " ignored bid increase per lot " + lot.getName() );
                        }
                    }
                }
                else {
                    System.out.println("Bidder №" + getID() + " is locked for " + locking.getLotsCount() + " lots.");
                    locking.reduceLotsCount();
                }
                lot.getBarrier().await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bidder)) return false;
        Bidder bidder = (Bidder) o;
        return ID == bidder.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
