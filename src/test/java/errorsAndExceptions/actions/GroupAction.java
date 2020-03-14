package errorsAndExceptions.actions;

import errorsAndExceptions.universityEntities.AcademicSubject;
import errorsAndExceptions.universityEntities.Group;
import errorsAndExceptions.universityEntities.Student;
import errorsAndExceptions.universityExceptions.GroupWithoutStudentsException;
import errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.Optional;

public class GroupAction extends AverageCalculator{

    public static boolean hasStudent(Group group, long studentIDNUmber) throws GroupWithoutStudentsException {
        return  group.getStudents().stream().anyMatch(student -> student.getStudentIDNumber() == studentIDNUmber);
    }

    public static Student searchStudent(Group group, long studentIDNUmber) throws GroupWithoutStudentsException {
        Optional<Student> optionalStudent = group.getStudents().stream().
                filter(student -> student.getStudentIDNumber() == studentIDNUmber)
                .findFirst();
        return optionalStudent.orElse(null);
    }

    public static Double getAverageGradeBySubject(Group group, AcademicSubject subject)
           throws GroupWithoutStudentsException, StudentWithoutAcademicSubjectsException {
        return calculateAverageGrade(group.getStudents(),subject);
    }
}
