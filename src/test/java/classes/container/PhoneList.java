package classes.container;

import classes.entity.Address;
import classes.entity.Phone;
import java.util.ArrayList;

public class PhoneList extends Container<Phone> {
    public PhoneList() {
        super();
        Add(new Phone(0, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",1,2),13,145,12,13));
        Add(new Phone(1, "Petr","Petrovich","Petrov",new Address("Kolasa",2,12),173,45,152,53));
        Add(new Phone(2, "Oleg","Olegovich","Olegov",new Address("Gikalo",3,25),113,245,0,23));
        Add(new Phone(3, "Pavel","Pavlovich","Pavlov",new Address("Kolasa",31,22),133,13,122,173));
        Add(new Phone(4, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",13,12),153,19,0,183));
        Add(new Phone(5, "Maksim","Maksimovich","Maksimov",new Address("Marksa",14,2),139,15,102,103));
    }

    public ArrayList<Phone> getSubscriberWithTimeOfCityCallsMoreThan(int timeOfCityCalls){
        return findWhere(x->x.getCity()>timeOfCityCalls);
    }

    public ArrayList<Phone> getSubscribesWhoUseIntercityCalls(){
        return findWhere(x->x.getIntercity()>0);
    }

    public ArrayList<Phone> sortSubscribesWithAlphabetOrder(){
        return sortByAscending(Phone::getSurname);
    }
}
