package classes.container;

import classes.entity.Address;
import classes.entity.Customer;
import classes.entity.Person;

import java.util.ArrayList;

public class CustomerList extends Container<Customer> {
    public CustomerList() {
        super();
        Add(new Customer(0, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),1000,"BA000"));
        Add(new Customer(1, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),1001,"BA001"));
        Add(new Customer(2, "Oleg","Olegovich","Olegov",new Address("Kolasa",24,24),1002,"BA002"));
        Add(new Customer(3, "Marina","Ivanovna","Nikolaeva",new Address("Gikalo",5,43),1003,"BA003"));
        Add(new Customer(4, "Fedor","Fedorovich","Fedorov",new Address("Gikalo",8,26),1004,"BA004"));
        Add(new Customer(5, "Pavel","Pavlovich","Pavlova",new Address("Kolasa",13,63),1005,"BA005"));
        Add(new Customer(6, "Galina","Pavlovna","Pavlovich",new Address("Gikalo",28,27),1006,"BA006"));
        Add(new Customer(7, "Alina","Fedorovna","Maksimova",new Address("Kolasa",1,13),1007,"BA007"));
        Add(new Customer(8, "Maksim","Maksimovich","Ivanov",new Address("Gikalo",2,27),1008,"BA008"));
        Add(new Customer(9, "Larisa","Ivanovna","Nikolaeva",new Address("Kolasa",23,83),1009,"BA009"));
        Add(new Customer(10, "Pavel","Pavlovich","Nikolaev",new Address("Gikalo",33,24),10010,"BA0010"));
        Add(new Customer(11, "Alexey","Olegovich","Pavlovich",new Address("Kolasa",63,93),10011,"BA0011"));
        Add(new Customer(12, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",26,23),10012,"BA0012"));
    }

    public ArrayList<Customer> sortedBySurname()
    {
        return sortByAscending(Person::getSurname);
    }

    public ArrayList<Customer> groupByCardNum (long CardNum1, long CardNum2)
    {
        return findWhere(x->(CardNum1 <= x.getCreditCardNum())&&(x.getCreditCardNum()<= CardNum2));
    }
}
