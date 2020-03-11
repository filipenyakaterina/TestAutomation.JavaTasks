package classes.scenario;

import classes.container.CarList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarScenario extends Scenario {
    private final String carMake;
    private final String model;
    private final int yearsOfCarUsing;
    private final GregorianCalendar yearOfRelease;
    private final double price;
    private final CarList carList;

    public CarScenario(String carMake, String model, int yearsOfCarUsing, GregorianCalendar yearOfRelease, double price) {
        this.carMake = carMake;
        this.model = model;
        this.yearsOfCarUsing = yearsOfCarUsing;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
        carList = new CarList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок автомобилей марки " + carMake + ":");
        System.out.println(carList.getCarsWithCarMake(carMake));
        System.out.println("Cписок автомобилей модели " + model + ", которые эксплуатируются больше " + yearsOfCarUsing + " лет:");
        System.out.println(carList.getCarsOfModelUsedMoreThan(model,yearsOfCarUsing));
        System.out.println("Cписок автомобилей " + yearOfRelease.get(Calendar.YEAR) + " года выпуска, цена которых больше " + price + ":");
        System.out.println(carList.getCarsWithYearAndPrice(yearOfRelease,price));
    }
}
