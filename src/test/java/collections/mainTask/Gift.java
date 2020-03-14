package collections.mainTask;

import collections.mainTask.confection.Sweet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Gift {
    private final ArrayList<Sweet> sweets;
    private final double MAX_WEIGHT = 1000;
    private double totalWeight;

    public Gift() {
        sweets = new ArrayList<>();
        totalWeight = 0;
    }

    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public double getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void addSweet(Sweet sweet) {
        if((totalWeight + sweet.getWeight()) <= MAX_WEIGHT){
            sweets.add(sweet);
            totalWeight += sweet.getWeight();
        }
    }

    public void sortSweetsInAlphabetOrder() {
        sweets.sort(Comparator.comparing(Sweet::getName));
    }

    public List<Sweet> getSweetsWithAmountOfSugarInRange(double of, double to){
        return sweets.stream().filter(x -> (x.getAmountOfSugar() >= of) && (x.getAmountOfSugar() <= to)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Gift{" +
                "sweets=" + sweets +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
