package classes.container;

import classes.entity.Book;
import classes.enums.BooksCover;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookList extends Container<Book> {
    public BookList() {
        super();
        Add(new Book(1, "My-my","Tyrgenev","Astra",new GregorianCalendar(1909, Calendar.MAY,1),70,23.00, BooksCover.HARD));
        Add(new Book(2, "Voina i mir","Tolstoy","1808",new GregorianCalendar(1881, Calendar.FEBRUARY,13),380,783.00, BooksCover.HARD));
        Add(new Book(3, "Anna Karenina","Tolstoy","Astra",new GregorianCalendar(1878, Calendar.APRIL,1),180,83.00, BooksCover.SOFT));
        Add(new Book(4, "Idiot","Dostoevskii","1808",new GregorianCalendar(1929, Calendar.FEBRUARY,10),230,26.00, BooksCover.HARD));
        Add(new Book(5, "Master i Margarita","Bulgakov","Astra",new GregorianCalendar(1901, Calendar.AUGUST,1),270,123.00, BooksCover.SOFT));
    }

    public ArrayList<Book> getBooksByAuthor(String author){
        return findWhere(x-> x.getAuthor().equals(author));
    }

    public ArrayList<Book> getBooksByPublishingHouse(String publishingHouse){
        return findWhere(x-> x.getPublishingHouse().equals(publishingHouse));
    }

    public ArrayList<Book> getBooksPublishedAfter(GregorianCalendar year) {
        return findWhere(x->x.getPublicationDate().get(Calendar.YEAR) > year.get(Calendar.YEAR));
    }
}
