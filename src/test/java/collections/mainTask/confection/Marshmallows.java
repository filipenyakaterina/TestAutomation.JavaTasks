package collections.mainTask.confection;

public class Marshmallows extends Sweet {
    private boolean isChocolate;

    public Marshmallows(String name, double amountOfSugar,
                        double weight, boolean isChocolate) {
        super(name, amountOfSugar, weight);
        this.isChocolate = isChocolate;
    }

    public boolean isChocolate() {
        return isChocolate;
    }

    public void setChocolate(boolean chocolate) {
        isChocolate = chocolate;
    }
}
