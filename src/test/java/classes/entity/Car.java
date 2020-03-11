package classes.entity;

import classes.enums.Colors;
import java.util.Calendar;

public class Car {
    private long Id;
    private String carMake;
    private String model;
    private Calendar releaseDate;
    private Colors color;
    private double cost;
    private String registrationNum;

    public Car(long id, String carMake, String model, Calendar releaseDate, Colors color, double cost, String registrationNum) {
        Id = id;
        this.carMake = carMake;
        this.model = model;
        this.releaseDate = releaseDate;
        this.color = color;
        setCost(cost);
        this.registrationNum = registrationNum;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost>0?cost:0;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", CarMake='" + carMake + '\'' +
                ", Model='" + model + '\'' +
                ", Year=" + releaseDate.get(Calendar.YEAR) +
                ", Color=" + color +
                ", Cost=" + cost +
                ", RegistrationNum='" + registrationNum + '\'' +
                '}'+'\n';
    }
}
