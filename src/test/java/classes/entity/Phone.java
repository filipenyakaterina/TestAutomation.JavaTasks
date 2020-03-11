package classes.entity;

public class Phone {
    private long Id;
    private String name;
    private String patronymic;
    private String surname;
    private Address address;
    private double debit;
    private double credit;
    private int intercity;
    private int city;

    public Phone(long id, String name, String patronymic, String surname, Address address, double debit, double credit, int intercity, int city) {
        Id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.address = address;
        this.debit = debit;
        this.credit = credit;
        this.intercity = intercity;
        this.city = city;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getIntercity() {
        return intercity;
    }

    public void setIntercity(int intercity) {
        this.intercity = intercity;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                ", Surname='" + surname + '\'' +
                ", Address=" + address +
                ", Debit='" + debit + '\'' +
                ", Credit='" + credit + '\'' +
                ", Intercity=" + intercity +
                ", City=" + city +
                '}' + '\n';
    }
}
