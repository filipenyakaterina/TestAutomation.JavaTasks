package classes.container;

import classes.entity.Address;
import classes.entity.Student;
import classes.enums.Faculty;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentsList extends Container<Student> {
    public StudentsList() {
        super();
        Add(new Student(0, "Alexey","Ivanovich","Nikolaev",new Address("Gikalo",23,34), new GregorianCalendar(1999, Calendar.DECEMBER,18),"+375-25-777-59-49",Faculty.BIOLOGICAL,2,"2_123"));
        Add(new Student(1, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2), new GregorianCalendar(1998, Calendar.MAY,24),"+375-25-777-59-49",Faculty.ECONOMICAL,1,"1_123"));
        Add(new Student(2, "Oleg","Olegovich","Olegov",new Address("Kolasa",24,24), new GregorianCalendar(1999, Calendar.JUNE,28),"+375-25-777-59-49",Faculty.BIOLOGICAL,2,"4_123"));
        Add(new Student(3, "Marina","Ivanovna","Nikolaeva",new Address("Gikalo",5,43), new GregorianCalendar(1997, Calendar.JULY,2),"+375-25-777-59-49",Faculty.CHEMICAL,3,"3_123"));
        Add(new Student(4, "Fedor","Fedorovich","Fedorov",new Address("Gikalo",8,26), new GregorianCalendar(1998, Calendar.FEBRUARY,1),"+375-25-777-59-49",Faculty.LINGUISTIC,3,"3_122"));
        Add(new Student(5, "Pavel","Pavlovich","Pavlova",new Address("Kolasa",13,63), new GregorianCalendar(2000, Calendar.APRIL,4),"+375-25-777-59-49", Faculty.MATHEMATICAL,3,"3_122"));
        Add(new Student(6, "Galina","Pavlovna","Pavlovich",new Address("Gikalo",28,27), new GregorianCalendar(1997, Calendar.JULY,3),"+375-25-777-59-49",Faculty.MATHEMATICAL,3,"3_123"));
        Add(new Student(7, "Alina","Fedorovna","Maksimova",new Address("Kolasa",1,13), new GregorianCalendar(1996, Calendar.NOVEMBER,9),"+375-25-777-59-49",Faculty.BIOLOGICAL,3,"3_123"));
        Add(new Student(8, "Maksim","Maksimovich","Ivanov",new Address("Gikalo",2,27), new GregorianCalendar(1996, Calendar.AUGUST,27),"+375-25-777-59-49",Faculty.LINGUISTIC,2,"2_123"));
        Add(new Student(9, "Larisa","Ivanovna","Nikolaeva",new Address("Kolasa",23,83), new GregorianCalendar(2000, Calendar.SEPTEMBER,16),"+375-25-777-59-49",Faculty.ECONOMICAL,2,"2_121"));
        Add(new Student(10, "Pavel","Pavlovich","Nikolaev",new Address("Gikalo",33,24), new GregorianCalendar(2000, Calendar.SEPTEMBER,31),"+375-25-777-59-49",Faculty.BIOLOGICAL,2,"2_121"));
        Add(new Student(11, "Alexey","Olegovich","Pavlovich",new Address("Kolasa",63,93), new GregorianCalendar(1997, Calendar.MAY,28),"+375-25-777-59-49",Faculty.MATHEMATICAL,4,"4_123"));
        Add(new Student(12, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",26,23), new GregorianCalendar(1998, Calendar.APRIL,3),"+375-25-777-59-49",Faculty.LINGUISTIC,2,"1_124"));
    }

    public ArrayList<Student> groupByFaculty(Faculty faculty)
    {
        return findWhere(x->x.getFaculty() == faculty);
    }

    public ArrayList<ArrayList<Student>> groupByFacultyAndYear()
    {
        ArrayList<ArrayList<Student>> studentArrayLists = new ArrayList<ArrayList<Student>>();
        for (Faculty f:getListOf(Student::getFaculty)) {
            for (int y:getListOf(Student::getYearOfStudy)) {
                ArrayList<Student> students;
                students = findWhere(x -> x.getFaculty() == f,x -> x.getYearOfStudy() == y);
                if(!students.isEmpty()){
                    studentArrayLists.add(students);
                }
            }
        }
        return studentArrayLists;
    }

    public ArrayList<Student> bornAfterYear(GregorianCalendar year)
    {
        return findWhere(x->x.getBirthDate().get(Calendar.YEAR) > year.get(Calendar.YEAR));
    }

    public ArrayList<Student> getGroupList(String group)
    {
        return  findWhere(x-> x.getGroup().equals(group));
    }
}
