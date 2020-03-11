package classes.entity;

import classes.enums.BuildingType;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class House {
    private long Id;
    private Address address;
    private double apartmentArea;
    private int floor;
    private int roomsNumber;
    private BuildingType buildingType;
    private Calendar houseLifetime;

    public House(long id, Address address, double apartmentArea, int floor, int roomsNumber, BuildingType buildingType, Calendar houseLifetime) {
        Id = id;
        this.address = address;
        this.apartmentArea = apartmentArea;
        setFloor(floor);
        setRoomsNumber(roomsNumber);
        this.buildingType = buildingType;
        this.houseLifetime = houseLifetime;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(classes.entity.Address address) {
        this.address = address;
    }

    public double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = Math.max(floor, 0);
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber >0? roomsNumber :1;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Calendar getHouseLifetime() {
        return houseLifetime;
    }

    public void setHouseLifetime(Calendar houseLifetime) {
        this.houseLifetime = houseLifetime;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "{" +
                "Id=" + Id +
                ", Address=" + address.toString() +
                ", ApartmentArea=" + apartmentArea +
                ", Floor=" + floor +
                ", RoomsNum=" + roomsNumber +
                ", BuildingType=" + buildingType +
                ", Lifetime=" + dateFormat.format(houseLifetime.getTime()) +
                '}' + '\n';
    }
}
