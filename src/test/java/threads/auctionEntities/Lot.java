package threads.auctionEntities;

import threads.services.Auction;
import threads.services.WinnerDefiner;
import java.util.Objects;
import java.util.concurrent.CyclicBarrier;

public class Lot {
    private final long ID;
    private String name;
    private CyclicBarrier barrier;

    public Lot(long ID, String name) {
        this.ID = ID;
        this.name = name;
        barrier = new CyclicBarrier(Auction.BIDDERS_COUNT, () -> {
            try {
                WinnerDefiner.define(ID);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot)) return false;
        Lot lot = (Lot) o;
        return ID == lot.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
