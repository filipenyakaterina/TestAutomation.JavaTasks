package classes.container;

import classes.entity.Address;
import classes.entity.Patient;

import java.util.ArrayList;

public class PatientList extends Container<Patient> {
    public PatientList() {
        super();
        Add(new Patient(0, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),"+375-25-567-34-21",1000,"A/850"));
        Add(new Patient(1, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),"+375-25-567-34-21",1001,"A/852"));
        Add(new Patient(2, "Oleg","Olegovich","Olegov",new Address("Kolasa",24,24),"+375-25-567-34-21",1002,"A/850"));
        Add(new Patient(3, "Marina","Ivanovna","Nikolaeva",new Address("Gikalo",5,43),"+375-25-567-34-21",1003,"A/851"));
        Add(new Patient(4, "Fedor","Fedorovich","Fedorov",new Address("Gikalo",8,26),"+375-25-567-34-21",1004,"A/850"));
        Add(new Patient(5, "Pavel","Pavlovich","Pavlova",new Address("Kolasa",13,63),"+375-25-567-34-21",1005,"A/848"));
        Add(new Patient(6, "Galina","Pavlovna","Pavlovich",new Address("Gikalo",28,27),"+375-25-567-34-21",1006,"A/850"));
        Add(new Patient(7, "Alina","Fedorovna","Maksimova",new Address("Kolasa",1,13),"+375-25-567-34-21",1007,"A/851"));
        Add(new Patient(8, "Maksim","Maksimovich","Ivanov",new Address("Gikalo",2,27),"+375-25-567-34-21",1008,"A/848"));
        Add(new Patient(9, "Larisa","Ivanovna","Nikolaeva",new Address("Kolasa",23,83),"+375-25-567-34-21",1009,"A/850"));
        Add(new Patient(10, "Pavel","Pavlovich","Nikolaev",new Address("Gikalo",33,24),"+375-25-567-34-21",1010,"A/950"));
        Add(new Patient(11, "Alexey","Olegovich","Pavlovich",new Address("Kolasa",63,93),"+375-25-567-34-21",1011,"A/850"));
        Add(new Patient(12, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",26,23),"+375-25-567-34-21",1012,"A/950"));

    }

    public ArrayList<Patient> groupByDiagnosis(String Diagnosis)
    {
        return findWhere(x-> x.getDiagnosis().equals(Diagnosis));
    }

    public ArrayList<Patient> groupByMedicalCardNumber(int num1, int num2)
    {
        return findWhere(x->(num1 <= x.getMedicalCardNumber())&&(x.getMedicalCardNumber()<= num2));
    }
}
