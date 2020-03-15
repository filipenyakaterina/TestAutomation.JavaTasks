package threads.auctionContainers;

import threads.auctionEntities.Lot;
import java.util.ArrayList;
import java.util.Optional;

public class LotList {
    private static ArrayList<Lot> lots;

    static {
        lots = new ArrayList<>() {
            {
                this.add(new Lot(0, "earrings"));
                this.add(new Lot(1, "necklace"));
                this.add(new Lot(2, "bracelet"));
                this.add(new Lot(3, "clock"));
                this.add(new Lot(4, "ring"));
            }
        };
    }

    public static ArrayList<Lot> getLots() {
        return lots;
    }

    public static Lot get(int index)
    {
        return lots.get(index);
    }

    public static Lot searchByID(long ID)
    {
        Optional<Lot> optionalLot = lots.stream().filter(lot -> lot.getID() == ID).findFirst();
        return optionalLot.orElse(null);
    }
}
