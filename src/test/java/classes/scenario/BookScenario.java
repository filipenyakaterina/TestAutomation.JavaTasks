package classes.scenario;

import classes.container.BookList;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookScenario extends Scenario {
    private final String author;
    private final String publishingHouse;
    private final GregorianCalendar year;
    private final BookList bookList;

    public BookScenario(String author, String publishingHouse, GregorianCalendar year) {
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.year = year;
        bookList = new BookList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок книг автора " + author + ":");
        System.out.println(bookList.getBooksByAuthor(author));
        System.out.println("Список книг, выпущенных издательством " + publishingHouse + ":");
        System.out.println(bookList.getBooksByPublishingHouse(publishingHouse));
        System.out.println("Cписок книг, выпущенных после " + year.get(Calendar.YEAR) + " года:");
        System.out.println(bookList.getBooksPublishedAfter(year));
    }
}
