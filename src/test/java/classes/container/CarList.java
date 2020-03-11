package classes.container;

import classes.entity.Car;
import classes.enums.Colors;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarList extends Container<Car> {
    public CarList() {
        super();
        Add(new Car(0,"volvo","s20",new GregorianCalendar(1999, Calendar.FEBRUARY,1), Colors.BLACK,1200,"AA23000-5"));
        Add(new Car(1,"bmw","a10",new GregorianCalendar(2003, Calendar.APRIL,1), Colors.RED,7200,"AA23001-5"));
        Add(new Car(2,"volvo","s20",new GregorianCalendar(2010, Calendar.OCTOBER,1), Colors.BLUE,3400,"AA23002-5"));
        Add(new Car(3,"bmw","a20",new GregorianCalendar(2003, Calendar.FEBRUARY,1), Colors.BLACK,5900,"AA23003-5"));
        Add(new Car(4,"volvo","s20",new GregorianCalendar(1989, Calendar.JUNE,1), Colors.BLACK,1200,"AA23004-5"));
        Add(new Car(5,"bmw","a10",new GregorianCalendar(2014, Calendar.FEBRUARY,1), Colors.RED,7200,"AA230051-5"));
        Add(new Car(6,"volvo","s20",new GregorianCalendar(2012, Calendar.AUGUST,1), Colors.BLUE,3400,"AA23006-5"));
        Add(new Car(7,"bmw","a20",new GregorianCalendar(2003, Calendar.DECEMBER,1), Colors.BLACK,1900,"AA23007-5"));

    }

    public ArrayList<Car> getCarsWithCarMake(String carMake){
        return findWhere(x-> x.getCarMake().equals(carMake));
    }

     public ArrayList<Car> getCarsOfModelUsedMoreThan(String model, int yearsOfCarUsing){
        return findWhere(x-> x.getModel().equals(model), x-> new GregorianCalendar().get(Calendar.YEAR)-x.getReleaseDate().get(Calendar.YEAR) >yearsOfCarUsing);
     }

    public ArrayList<Car> getCarsWithYearAndPrice(GregorianCalendar year, double price){
        return findWhere(x->x.getReleaseDate().get(Calendar.YEAR) == year.get(Calendar.YEAR), x-> x.getCost()>price);
    }
}
