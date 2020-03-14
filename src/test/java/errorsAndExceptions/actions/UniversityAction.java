package errorsAndExceptions.actions;

import errorsAndExceptions.universityEntities.*;
import errorsAndExceptions.universityExceptions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class UniversityAction extends AverageCalculator{
    private static Student searchStudentByStudentIDNumber(University university, long studentIdNumber)
            throws UniversityWithoutFacultiesException, GroupWithoutStudentsException, FacultyWithoutGroupsException, NoStudentWithIdException {
        Student student;
        for (Faculty faculty : university.getFaculties()) {
            if((student = FacultyAction.searchStudent(faculty, studentIdNumber)) != null){
                return student;
            }
        }
        throw new NoStudentWithIdException("В университете отсутсвует студент с id = " + studentIdNumber);
    }

    public static EnumMap<AcademicSubject, Double> getAverageGradesByStudent (University university, long studentIDNumber)
            throws FacultyWithoutGroupsException, UniversityWithoutFacultiesException, GroupWithoutStudentsException,
            StudentWithoutAcademicSubjectsException, NoStudentWithIdException {
        return StudentAction.getAverageGrades(searchStudentByStudentIDNumber(university, studentIDNumber));
    }

    public static Double getAverageGradeOfFaculty(University university, String facultyName, AcademicSubject subject)
            throws FacultyWithoutGroupsException, StudentWithoutAcademicSubjectsException, GroupWithoutStudentsException, UniversityWithoutFacultiesException, NoFacultyWithNameException {
        Faculty facultyByName;
        Optional<Faculty> optionalFaculty = university.getFaculties().stream().
                filter(faculty -> faculty.getFacultyName().equals(facultyName)).findFirst();
        if(optionalFaculty.isPresent()) {
            facultyByName = optionalFaculty.get();
        } else {
            throw new NoFacultyWithNameException("В университете отсутствует факультет с именем " + facultyName);
        }
        return FacultyAction.getAverageGradeBySubject(facultyByName, subject);
    }

    private static Group searchGroupByName(University university, String groupName) throws UniversityWithoutFacultiesException, FacultyWithoutGroupsException {
        for (Faculty faculty : university.getFaculties()) {
            if(FacultyAction.hasGroup(faculty, groupName)){
                return faculty.getGroup(groupName);
            }
        }
        return null;
    }

    public static Double getAverageGradeOfGroup(University university, String groupName, AcademicSubject subject)
            throws GroupWithoutStudentsException, StudentWithoutAcademicSubjectsException,
            UniversityWithoutFacultiesException, FacultyWithoutGroupsException {
        Group group;
        Double averageGrade = 0.0;

        if((group = searchGroupByName(university,groupName)) != null){
            averageGrade = GroupAction.getAverageGradeBySubject(group, subject);
        }
        return averageGrade;
    }

    public static List<Student> getStudentsOfUniversity(University university) throws FacultyWithoutGroupsException,
            GroupWithoutStudentsException, UniversityWithoutFacultiesException {
        ArrayList<Student> students = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            students.addAll(FacultyAction.getStudentsOfFaculty(faculty));
        }
        return students;
    }

    public static Double getAverageGradeOfUniversity(University university, AcademicSubject subject)
           throws GroupWithoutStudentsException, StudentWithoutAcademicSubjectsException,
          FacultyWithoutGroupsException, UniversityWithoutFacultiesException {
        return calculateAverageGrade(getStudentsOfUniversity(university),subject);
    }
}
