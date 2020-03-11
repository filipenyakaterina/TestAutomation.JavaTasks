package classes.entity;

public class Person{
    private long Id;
    private String name;
    private String patronymic;
    private String surname;
    private Address address;

    public Person() {}

    public Person(long Id, String name, String patronymic, String surname, Address address)
    {
        this.Id = Id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.address = address;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                ", Surname='" + surname + '\'' +
                ", Address=" + address.toString();
    }
}
