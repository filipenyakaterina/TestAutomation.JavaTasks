package errorsAndExceptions.actions;

import errorsAndExceptions.universityEntities.AcademicSubject;
import errorsAndExceptions.universityEntities.Faculty;
import errorsAndExceptions.universityEntities.Group;
import errorsAndExceptions.universityEntities.Student;
import errorsAndExceptions.universityExceptions.FacultyWithoutGroupsException;
import errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;
import errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.ArrayList;
import java.util.List;

public class FacultyAction extends AverageCalculator {

    public static boolean hasGroup(Faculty faculty, String groupName) throws FacultyWithoutGroupsException {
        return faculty.getGroups().stream().anyMatch(group -> group.getGroupName().equals(groupName));
    }

    private static Group groupWithStudent(Faculty faculty, long studentIDNUmber)
            throws FacultyWithoutGroupsException, GroupWithoutStudentsException {
        for (Group group : faculty.getGroups()) {
            if(GroupAction.hasStudent(group, studentIDNUmber)){
                return group;
            }
        }

        return null;
    }

    public static Student searchStudent(Faculty faculty, long studentIDNUmber)
            throws FacultyWithoutGroupsException, GroupWithoutStudentsException {
        Group groupWithStudent = groupWithStudent(faculty, studentIDNUmber);
        if (groupWithStudent != null) {
            return GroupAction.searchStudent(groupWithStudent, studentIDNUmber);
        }
        else return null;
    }

    public static List<Student> getStudentsOfFaculty(Faculty faculty) throws FacultyWithoutGroupsException, GroupWithoutStudentsException {
        ArrayList<Student> students = new ArrayList<>();
        for (Group group : faculty.getGroups()) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    public static Double getAverageGradeBySubject(Faculty faculty, AcademicSubject subject) throws GroupWithoutStudentsException,
            FacultyWithoutGroupsException, StudentWithoutAcademicSubjectsException {
        return calculateAverageGrade(getStudentsOfFaculty(faculty),subject);
    }
}
