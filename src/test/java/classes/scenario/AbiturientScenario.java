package classes.scenario;

import classes.container.AbiturientList;

public class AbiturientScenario extends Scenario {
    private final int sumOfGrades;
    private final int abiturientsCount;
    private final AbiturientList abiturientList;

    public AbiturientScenario(int sumOfGrades, int abiturientsCount) {
        this.sumOfGrades = sumOfGrades;
        this.abiturientsCount = abiturientsCount;
        abiturientList = new AbiturientList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок абитуриентов, имеющих неудовлетворительные оценки:");
        System.out.println(abiturientList.getListOfQuartets());
        System.out.println("Cписок абитуриентов, у которых сумма баллов выше " + sumOfGrades + ":");
        System.out.println(abiturientList.getAbituriensWithSumOfGradesMoreThan(sumOfGrades));
        System.out.println("Выбрать " + abiturientsCount + " абитуриентов, имеющих самую высокую сумму баллов:");
        System.out.println(abiturientList.getNAbiturientWithMaximalSumOfGrades(abiturientsCount));
    }
}
