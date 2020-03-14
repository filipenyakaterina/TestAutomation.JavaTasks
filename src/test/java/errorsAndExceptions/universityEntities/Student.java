package errorsAndExceptions.universityEntities;

import errorsAndExceptions.universityExceptions.GradeOutOfRangeException;
import errorsAndExceptions.universityExceptions.StudentWithoutAcademicSubjectsException;

import java.util.*;

public class Student {
    private static long studentsCount = 0;

    private String name;
    private String surname;
    private long studentIDNumber;
    private EnumSet<AcademicSubject> academicSubjects;
    private Grades grades;

    public Student(String name, String surname, EnumSet<AcademicSubject> academicSubjects){
        this.name = name;
        this.surname = surname;
        this.academicSubjects = academicSubjects;
        grades = new Grades();
        studentIDNumber = studentsCount;
        studentsCount++;
    }

    public class Grades {
        private EnumMap<AcademicSubject, List<Integer>> subjectGrades = new EnumMap<>(AcademicSubject.class);

        public Grades() {
            for( AcademicSubject academicSubject : academicSubjects){
                subjectGrades.put(academicSubject, new ArrayList<>());
            }
        }

        public EnumMap<AcademicSubject, List<Integer>> getSubjectGrades() {
            return subjectGrades;
        }

        private void setSubject(AcademicSubject academicSubject) {
            if(academicSubjects.contains(academicSubject)){
                subjectGrades.put(academicSubject, new ArrayList<>());
            }
        }

        private void setGrade(AcademicSubject academicSubject, int grade)
                throws GradeOutOfRangeException {
            if((grade >= 0) && (grade <= 10)){
                List<Integer> grades = subjectGrades.get(academicSubject);
                grades.add(grade);
                subjectGrades.put(academicSubject,grades);
            }
            else{
                throw new GradeOutOfRangeException("Оценка " + grade + " является недопустимой!");
            }
        }

        @Override
        public String toString() {
            return subjectGrades.toString();
        }
    }

    public long getStudentIDNumber() {
        return studentIDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EnumSet<AcademicSubject> getAcademicSubjects()
            throws StudentWithoutAcademicSubjectsException {
        if (academicSubjects.isEmpty()){
            throw new StudentWithoutAcademicSubjectsException("У студента " +
                    getName() + " " + getSurname() + " с номером студенческого билета "
                    + getStudentIDNumber() + " отсутствуют академические предметы!");
        }
        return academicSubjects;
    }

    public void setAcademicSubject(AcademicSubject subject) {
        academicSubjects.add(subject);
        grades.setSubject(subject);
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrade(AcademicSubject subject, int grade)
            throws GradeOutOfRangeException,StudentWithoutAcademicSubjectsException {
        if(!getAcademicSubjects().contains(subject)){
            setAcademicSubject(subject);
        }
        grades.setGrade(subject,grade);
    }

    @Override
    public String toString() {
        return "Student " + studentIDNumber + ' ' + name + ' ' +
                surname + ' ' + grades + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentIDNumber == student.studentIDNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentIDNumber);
    }
}
