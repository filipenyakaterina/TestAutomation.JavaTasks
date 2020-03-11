package classes;

import classes.enums.Faculty;
import classes.scenario.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ScenarioExecutor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите номер сценария, который необходимо исполнить " +
                "(1-Student, 2-Customer, 3-Patient, 4-Abiturient, 5-Book, 6-House, 7-Phone, 8-Car, 9-Product, 10-Train):");
        int programNumber = scanner.nextInt();
        switch (programNumber){
            case 1:
                new StudentScenario(Faculty.MATHEMATICAL,new GregorianCalendar(1998, Calendar.FEBRUARY,1),"2_121").execute();
                break;
            case 2:
                new CustomerScenario(1004,1009).execute();
                break;
            case 3:
                new PatientScenario("A/850",1008, 1011).execute();
                break;
            case 4:
                new AbiturientScenario(25,7).execute();
                break;
            case 5:
                new BookScenario("Tolstoy", "1808", new GregorianCalendar(1900, Calendar.FEBRUARY,1)).execute();
                break;
            case 6:
                new HouseScenario(3,2,5,50).execute();
                break;
            case 7:
                new PhoneScenario(100).execute();
                break;
            case 8:
                new CarScenario("bmw", "s20",10,new GregorianCalendar(2014, Calendar.FEBRUARY,1),5000).execute();
                break;
            case 9:
                new ProductScenario("milk",1.5, new GregorianCalendar(2019, Calendar.DECEMBER,3)).execute();
                break;
            case 10:
                new TrainScenario("Riga","Lvov", "Smolensk",new GregorianCalendar(2019, Calendar.NOVEMBER,27,12,30)).execute();
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }
}
