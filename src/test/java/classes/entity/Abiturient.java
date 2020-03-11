package classes.entity;

import java.util.Arrays;

public class Abiturient extends Person {
    private String phoneNumber;
    private int[] grades;

    public Abiturient(long Id, String name, String patronymic, String surname, Address address, String phoneNumber, int[] grades) {
        super(Id, name, patronymic, surname, address);
        this.phoneNumber = phoneNumber;
        this.grades = grades;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getGrades() {
        return grades;
    }

    public int[] getSortedGrades(){
        Arrays.sort(grades);
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double getSumOfGrades()
    {
        int sumOfGrades = 0;
        for (int i: grades) {
            sumOfGrades += i;
        }
        return sumOfGrades;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Grades=" + Arrays.toString(getGrades()) +
                '}' + '\n';
    }
}
