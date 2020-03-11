package classes.entity;

import classes.enums.Faculty;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student extends Person {
    private Calendar birthDate;
    private String phoneNumber;
    private Faculty faculty;
    private int yearOfStudy;
    private String group;

    public Student(long Id, String name, String patronymic, String surname, Address address, Calendar birthDate, String phoneNumber, Faculty faculty, int yearOfStudy, String group) {
        super(Id, name, patronymic, surname, address);
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        setYearOfStudy(yearOfStudy);
        this.group = group;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        if(yearOfStudy > 0 && yearOfStudy < 6)
        {
            this.yearOfStudy = yearOfStudy;
        }
        else
            {
                this.yearOfStudy = 1;
            }
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "{" + super.toString() +
                ", BirthDate=" + dateFormat.format(birthDate.getTime()) +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", Faculty=" + faculty +
                ", YearOfStudy=" + yearOfStudy +
                ", Group='" + group + '\'' +
                "}\n";
    }
}
