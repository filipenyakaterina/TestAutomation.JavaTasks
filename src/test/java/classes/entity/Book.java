package classes.entity;

import classes.enums.BooksCover;
import java.util.Calendar;

public class Book {
    private long Id;
    private String Name;
    private String Author;
    private String PublishingHouse;
    private Calendar PublicationDate;
    private int NumOfPages;
    private double Cost;
    private BooksCover Cover;

    public Book(long id, String name, String author, String publishingHouse, Calendar publicationDate, int numOfPages, double cost, BooksCover cover) {
        Id = id;
        Name = name;
        Author = author;
        PublishingHouse = publishingHouse;
        PublicationDate = publicationDate;
        NumOfPages = numOfPages;
        Cost = cost;
        Cover = cover;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishingHouse() {
        return PublishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        PublishingHouse = publishingHouse;
    }

    public Calendar getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        PublicationDate = publicationDate;
    }

    public int getNumOfPages() {
        return NumOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        NumOfPages = numOfPages;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public BooksCover getCover() {
        return Cover;
    }

    public void setCover(BooksCover cover) {
        Cover = cover;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Author=" + Author +
                ", PublishingHouse='" + PublishingHouse + '\'' +
                ", Year=" + PublicationDate.get(Calendar.YEAR) +
                ", NumOfPages=" + NumOfPages +
                ", Cost=" + Cost +
                ", Cover=" + Cover +
                '}'+'\n';
    }
}
