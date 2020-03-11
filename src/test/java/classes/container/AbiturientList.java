package classes.container;

import classes.entity.Abiturient;
import classes.entity.Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class AbiturientList extends Container<Abiturient> {
    public final int POOR_GRADE_TWO = 2;
    public final int POOR_GRADE_ONE = 1;

    public AbiturientList() {
        super();
        Add(new Abiturient(0, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),"+375-25-567-34-21",new int[]{10,9,8,10}));//37
        Add(new Abiturient(1, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),"+375-25-567-34-21",new int[]{9,9,8,1}));//27
        Add(new Abiturient(2, "Oleg","Olegovich","Olegov",new Address("Kolasa",24,24),"+375-25-567-34-21",new int[]{10,9,6,10}));//35
        Add(new Abiturient(3, "Marina","Ivanovna","Nikolaeva",new Address("Gikalo",5,43),"+375-25-567-34-21",new int[]{1,9,2,5}));//17
        Add(new Abiturient(4, "Fedor","Fedorovich","Fedorov",new Address("Gikalo",8,26),"+375-25-567-34-21",new int[]{10,1,8,10}));//29
        Add(new Abiturient(5, "Pavel","Pavlovich","Pavlova",new Address("Kolasa",13,63),"+375-25-567-34-21",new int[]{10,9,7,10}));//36
        Add(new Abiturient(6, "Galina","Pavlovna","Pavlovich",new Address("Gikalo",28,27),"+375-25-567-34-21",new int[]{2,9,8,2}));//21
        Add(new Abiturient(7, "Alina","Fedorovna","Maksimova",new Address("Kolasa",1,13),"+375-25-567-34-21",new int[]{10,9,1,9}));//29
        Add(new Abiturient(8, "Maksim","Maksimovich","Ivanov",new Address("Gikalo",2,27),"+375-25-567-34-21",new int[]{10,9,9,10}));//38
        Add(new Abiturient(9, "Larisa","Ivanovna","Nikolaeva",new Address("Kolasa",23,83),"+375-25-567-34-21",new int[]{2,9,8,10}));//29
        Add(new Abiturient(10, "Pavel","Pavlovich","Nikolaev",new Address("Gikalo",33,24),"+375-25-567-34-21",new int[]{10,1,7,8}));//26
        Add(new Abiturient(11, "Alexey","Olegovich","Pavlovich",new Address("Kolasa",63,93),"+375-25-567-34-21",new int[]{1,9,8,10}));//28
        Add(new Abiturient(12, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",26,23),"+375-25-567-34-21",new int[]{6,9,1,6}));//22
    }

    public ArrayList<Abiturient> getListOfQuartets(){
        return findWhere(x-> (Arrays.binarySearch(x.getSortedGrades(),POOR_GRADE_ONE) >= 0) || (Arrays.binarySearch(x.getSortedGrades(),POOR_GRADE_TWO) >= 0));
    }

    public ArrayList<Abiturient> getAbituriensWithSumOfGradesMoreThan(int sumOfGrades)
    {
        return findWhere(x->x.getSumOfGrades()>=sumOfGrades);
    }

    public List<Abiturient> getNAbiturientWithMaximalSumOfGrades(int n)
    {
        return sortByDescending(Abiturient::getSumOfGrades).subList(0,n);
    }



}
