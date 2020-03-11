package classes.container;

import classes.entity.Address;
import classes.entity.House;
import classes.enums.BuildingType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HouseList extends Container<House> {
    public HouseList(){
        super();
        Add(new House(0,new Address("Gikalo",15,33),80,2,3, BuildingType.APARTMENT,new GregorianCalendar(2045, Calendar.FEBRUARY,1)));
        Add(new House(1,new Address("Kolasa",5,32),20,1,3, BuildingType.PRIVATE_HOUSE,new GregorianCalendar(2055, Calendar.JUNE,1)));
        Add(new House(2,new Address("Gikalo",1,34),40,5,2, BuildingType.APARTMENT,new GregorianCalendar(2075, Calendar.NOVEMBER,1)));
        Add(new House(3,new Address("Beruta",75,13),50,7,2, BuildingType.APARTMENT,new GregorianCalendar(2025, Calendar.JUNE,1)));
        Add(new House(4,new Address("Odoevskogo",19,6),60,1,1, BuildingType.APARTMENT,new GregorianCalendar(2040, Calendar.SEPTEMBER,1)));

    }

    public ArrayList<House> getApartmentsWhereRoomNumber(int roomNumber){
        return findWhere(x->x.getRoomsNumber() == roomNumber);
    }

    public ArrayList<House> getApartmentsByRoomNumberAndFloor(int roomNumber, int minFloor, int maxFloor){
        return findWhere(x->x.getRoomsNumber()==roomNumber, x->x.getFloor()>=minFloor && x.getFloor()<=maxFloor);
    }

    public ArrayList<House> getApartmentsWithAreaMoreThan(double area){
        return findWhere(x->x.getApartmentArea()>area);
    }
}
