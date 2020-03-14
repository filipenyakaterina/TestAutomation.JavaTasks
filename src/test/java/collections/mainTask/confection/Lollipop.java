package collections.mainTask.confection;

import collections.mainTask.tastes.Flavor;

public class Lollipop extends Sweet {
    private Flavor lollipopFlavor;

    public Lollipop(String name, double amountOfSugar,
                    double weight, Flavor lollipopFlavor) {
        super(name, amountOfSugar, weight);
        this.lollipopFlavor = lollipopFlavor;
    }

    public Flavor getLollipopFlavor() {
        return lollipopFlavor;
    }

    public void setLollipopFlavor(Flavor lollipopFlavor) {
        this.lollipopFlavor = lollipopFlavor;
    }
}
