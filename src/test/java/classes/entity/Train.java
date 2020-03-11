package classes.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Train {
    private String destination;
    private int trainNumber;
    private Calendar departure;
    private Places places;

    public Train(String destination, int trainNumber, Calendar departure, Train.Places places) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departure = departure;
        this.places = places;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Calendar getDeparture() {
        return departure;
    }

    public void setDeparture(Calendar departure) {
        this.departure = departure;
    }

    public Train.Places getPlaces() {
        return places;
    }

    public void setPlaces(Train.Places places) {
        this.places = places;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return "Entities.Train{" +
                "Destination='" + destination + '\'' +
                ", TrainNumber=" + trainNumber +
                ", Departure=" + dateFormat.format(departure.getTime()) +
                ", Places=" + places.toString() +
                '}'+"\n";
    }

    public static class Places
    {
        private final int General;
        private final int Coupe;
        private final int ReservedSeat;
        private final int Luxury;

        public int getGeneral() {
            return General;
        }

        public int getCoupe() {
            return Coupe;
        }

        public int getReservedSeat() {
            return ReservedSeat;
        }

        public int getLuxury() {
            return Luxury;
        }

        public Places(int general, int coupe, int reservedSeat, int luxury) {
            General = Math.max(general, 0);
            Coupe = Math.max(coupe, 0);
            ReservedSeat = Math.max(reservedSeat, 0);
            Luxury = Math.max(luxury, 0);
        }

        @Override
        public String toString() {
            return "{" +
                    "General=" + General +
                    ", Coupe=" + Coupe +
                    ", ReservedSeat=" + ReservedSeat +
                    ", Luxury=" + Luxury +
                    "}";
        }
    }
}
