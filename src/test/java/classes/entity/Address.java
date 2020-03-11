package classes.entity;

public class Address {
    private String Street;
    private int HouseNumber;
    private int ApartmentNumber;

    public Address(String Street, int HouseNumber, int ApartmentNumber)
    {
        this.Street = Street;
        this.HouseNumber = HouseNumber;
        this.ApartmentNumber = ApartmentNumber;
    }

    public String getStreet() {
        return Street;
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public int getApartmentNumber() {
        return ApartmentNumber;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setHouseNumber(int houseNumber) {
        HouseNumber = houseNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        ApartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "Street='" + Street + '\'' +
                ", HouseNum=" + HouseNumber +
                ", ApartmentNum=" + ApartmentNumber +
                '}';
    }
}
