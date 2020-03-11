package classes.container;

import classes.entity.Train;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrainList extends Container<Train> {
    public TrainList() {
        super();
        Add(new Train("Riga",110,new GregorianCalendar(2019, Calendar.NOVEMBER,23,12,6),new Train.Places(12,13,9,7)));
        Add(new Train("Lvov",112,new GregorianCalendar(2019, Calendar.NOVEMBER,24,2,56),new Train.Places(16,23,29,7)));
        Add(new Train("Smolensk",111,new GregorianCalendar(2019, Calendar.NOVEMBER,28,21,36),new Train.Places(11,43,19,17)));
        Add(new Train("Vilnus",109,new GregorianCalendar(2019, Calendar.NOVEMBER,26,11,16),new Train.Places(13,18,39,57)));
        Add(new Train("Brest",114,new GregorianCalendar(2019, Calendar.NOVEMBER,26,18,26),new Train.Places(12,13,29,0)));
        Add(new Train("Riga",210,new GregorianCalendar(2019, Calendar.NOVEMBER,23,2,1),new Train.Places(12,13,9,7)));
        Add(new Train("Lvov",212,new GregorianCalendar(2019, Calendar.NOVEMBER,21,19,22),new Train.Places(16,23,29,7)));
        Add(new Train("Smolensk",211,new GregorianCalendar(2019, Calendar.NOVEMBER,26,9,0),new Train.Places(0,43,19,17)));
        Add(new Train("Vilnus",209,new GregorianCalendar(2019, Calendar.NOVEMBER,26,8,5),new Train.Places(13,18,39,57)));
        Add(new Train("Brest",214,new GregorianCalendar(2019, Calendar.NOVEMBER,26,7,15),new Train.Places(12,13,29,0)));
        Add(new Train("Riga",310,new GregorianCalendar(2019, Calendar.NOVEMBER,23,12,13),new Train.Places(12,13,9,7)));
        Add(new Train("Lvov",312,new GregorianCalendar(2019, Calendar.NOVEMBER,27,14,6),new Train.Places(16,23,29,7)));
        Add(new Train("Smolensk",311,new GregorianCalendar(2019, Calendar.NOVEMBER,28,12,16),new Train.Places(0,43,19,17)));
        Add(new Train("Vilnus",309,new GregorianCalendar(2019, Calendar.NOVEMBER,26,13,2),new Train.Places(13,18,39,57)));
        Add(new Train("Brest",314,new GregorianCalendar(2019, Calendar.NOVEMBER,26,12,6),new Train.Places(12,13,29,0)));
    }

    public ArrayList<Train> getTrainsByDestination(String destination){
        return findWhere(x-> x.getDestination().equals(destination));
    }

    public ArrayList<Train> getTrainsByDestinationWithDepartTimeAfter(String destination, GregorianCalendar departTime){
        return findWhere(x-> x.getDestination().equals(destination), x->x.getDeparture().after(departTime));
    }

    public ArrayList<Train> getTrainByDestinationWithGeneralPlaces(String destination){
        return findWhere(x-> x.getDestination().equals(destination), x->x.getPlaces().getGeneral()>0);
    }




}
