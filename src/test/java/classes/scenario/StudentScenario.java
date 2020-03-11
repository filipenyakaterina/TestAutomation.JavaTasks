package classes.scenario;

import classes.container.StudentsList;
import classes.entity.Student;
import classes.enums.Faculty;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentScenario extends Scenario {
    private final Faculty faculty;
    private final GregorianCalendar yearOfBirth;
    private final String groupName;
    private final StudentsList studentsList;

    public StudentScenario(Faculty faculty, GregorianCalendar yearOfBirth, String groupName) {
        this.faculty = faculty;
        this.yearOfBirth = yearOfBirth;
        this.groupName = groupName;
        studentsList = new StudentsList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок студентов факультета " + faculty +":");
        System.out.println(studentsList.groupByFaculty(faculty));
        System.out.println("Cписки студентов для каждого факультета и курса:");
        for (ArrayList<Student> students : studentsList.groupByFacultyAndYear()){
            System.out.println(students);
        }
        System.out.println("Cписки студентов, родившихся после " + yearOfBirth.get(Calendar.YEAR) + " года:");
        System.out.println(studentsList.bornAfterYear(yearOfBirth));
        System.out.println("Cписок учебной группы " + groupName + ":");
        System.out.println(studentsList.getGroupList(groupName));
    }
}
