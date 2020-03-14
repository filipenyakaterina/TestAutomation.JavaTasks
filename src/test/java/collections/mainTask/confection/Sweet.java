package collections.mainTask.confection;

public class Sweet {
    String name;
    double amountOfSugar;
    double weight;

    public Sweet() {
    }

    public Sweet(String name, double amountOfSugar, double weight) {
        this.name = name;
        this.amountOfSugar = amountOfSugar;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(double amountOfSugar) {
        this.amountOfSugar = (amountOfSugar > 0) ? amountOfSugar : 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = (weight > 0) ? weight : 0;
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", amountOfSugar=" + amountOfSugar +
                ", weight=" + weight +
                '}' + '\n';
    }
}

