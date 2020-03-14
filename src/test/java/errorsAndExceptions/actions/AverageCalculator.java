package errorsAndExceptions.actions;

import errorsAndExceptions.universityEntities.AcademicSubject;
import errorsAndExceptions.universityEntities.Student;
import errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.List;

public class AverageCalculator {

    public static Double calculateAverageGrade(List<Student> students, AcademicSubject subject)
            throws StudentWithoutAcademicSubjectsException {
        Double averageGrade = 0.0;
        int gradesCount = 0;

        for (Student student : students) {
            if(student.getAcademicSubjects().contains(subject)){
                List<Integer> grades = StudentAction.getGradesBySubject(student, subject);

                for (Integer grade : grades) {
                    averageGrade += grade;
                    gradesCount++;
                }
            }
        }
        averageGrade = (gradesCount != 0) ? averageGrade / gradesCount : averageGrade;
        return averageGrade;
    }
}
