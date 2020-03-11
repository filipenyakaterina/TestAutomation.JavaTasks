package classes.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Product {
    private long Id;
    private String name;
    private String UPC;
    private String producer;
    private double cost;
    private Calendar bestBefore;
    private int count;

    public Product(long id, String name, String UPC, String producer, double cost, Calendar bestBefore, int count) {
        Id = id;
        this.name = name;
        this.UPC = UPC;
        this.producer = producer;
        setCost(cost);
        this.bestBefore = bestBefore;
        setCount(count);
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost>0?cost:0;
    }

    public Calendar getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(Calendar bestBefore) {
        this.bestBefore = bestBefore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = Math.max(count, 0);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", UPC='" + UPC + '\'' +
                ", Producer='" + producer + '\'' +
                ", Cost=" + cost +
                ", BestBefore=" + dateFormat.format(bestBefore.getTime()) +
                ", Count=" + count +
                '}'+'\n';
    }
}
