package collections.mainTask.confection;

import collections.mainTask.tastes.Ingredients;
import java.util.EnumSet;

public class ChocolateBar extends Sweet {
    private EnumSet<Ingredients> Filling;

    public ChocolateBar(String name, double amountOfSugar,
                        double weight, EnumSet<Ingredients> filling) {
        super(name, amountOfSugar, weight);
        Filling = filling;
    }

    public EnumSet<Ingredients> getFilling() {
        return Filling;
    }

    public void setFilling(EnumSet<Ingredients> filling) {
        Filling = filling;
    }
}
