package classes.container;

import classes.entity.Product;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProductList extends Container<Product> {
    public ProductList() {
        super();
        Add(new Product(0, "milk","11-aa-78","Savushkin",1.22,new GregorianCalendar(2019, Calendar.DECEMBER,20),10));
        Add(new Product(1, "milk","11-aa-79","Molochny mir",1.72,new GregorianCalendar(2019, Calendar.DECEMBER,19),10));
        Add(new Product(2, "cheese","11-aa-76","Savushkin",2.22,new GregorianCalendar(2019, Calendar.DECEMBER,1),12));
        Add(new Product(3, "yogurt","11-aa-68","Molochny mir",1.12,new GregorianCalendar(2019, Calendar.NOVEMBER,2),14));
        Add(new Product(4, "kefir","11-aa-58","Savushkin",1.28,new GregorianCalendar(2019, Calendar.NOVEMBER,9),30));
        Add(new Product(5, "milk","11-aa-75","Prostocvashino",4.22,new GregorianCalendar(2019, Calendar.DECEMBER,21),15));
    }

    public ArrayList<Product> getProductsWithName(String name){
        return findWhere(x-> x.getName().equals(name));
    }

    public ArrayList<Product> getProductsWithNameAndPrice(String name, double price){
        return findWhere(x-> x.getName().equals(name), x-> x.getCost()<=price);
    }

    public ArrayList<Product> getProductsWithDateBestBefore(GregorianCalendar bestBefore){
        return findWhere(x->x.getBestBefore().after(bestBefore));
    }
}
