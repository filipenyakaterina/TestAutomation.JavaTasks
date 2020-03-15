package threads.services;

import threads.auctionContainers.WinnersList;
import threads.auctionEntities.Bid;
import threads.auctionEntities.Bidder;
import threads.states.BidState;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentController extends Thread {
    public final int TIME_TO_PAY = 3000;
    public final int LOTS_COUNT_FOR_LOCK = 2;

    @Override
    public void run() {
        try {
            if(this.isDaemon()){
                while(true){
                    Thread.sleep(1000);
                    Calendar calendar = new GregorianCalendar();
                    calendar.add(Calendar.MILLISECOND, - TIME_TO_PAY);
                    Date timeLimit = calendar.getTime();
                    for (Bid bid : WinnersList.getAwaitingPaymentBidsOlderThan(timeLimit)) {
                        Bidder bidder = bid.getBidder();
                        bidder.lock(LOTS_COUNT_FOR_LOCK);
                        System.out.println("Bidder №" + bidder.getID() + " is locked.");
                        bid.setState(BidState.NEW);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
