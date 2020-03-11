package classes.scenario;

import classes.container.TrainList;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TrainScenario extends Scenario {
    private final String destination;
    private final String destinationOfTrainsWithGeneralPlaces;
    private final String destinationOfTrainsWithDepartTimeAfter;
    private final GregorianCalendar departTime;
    private final TrainList trainList;

    public TrainScenario(String destination, String destinationOfTrainsWithGeneralPlaces,
                         String destinationOfTrainsWithDepartTimeAfter, GregorianCalendar departTime) {
        this.destination = destination;
        this.destinationOfTrainsWithGeneralPlaces = destinationOfTrainsWithGeneralPlaces;
        this.destinationOfTrainsWithDepartTimeAfter = destinationOfTrainsWithDepartTimeAfter;
        this.departTime = departTime;
        trainList = new TrainList();
    }

    @Override
    public void execute() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println("Cписок поездов, следующих до пункта назначения " + destination + ":");
        System.out.println(trainList.getTrainsByDestination(destination));
        System.out.println("Cписок поездов, отправляющихся до пункта назначения "
                + destinationOfTrainsWithGeneralPlaces + " и имеющих общие места:");
        System.out.println(trainList.getTrainByDestinationWithGeneralPlaces(destinationOfTrainsWithGeneralPlaces));
        System.out.println("Cписок поездов, следующих до " + destinationOfTrainsWithDepartTimeAfter +
                " и отправляющихся после " + dateFormat.format(departTime.getTime()) + ":");
        System.out.println(trainList.getTrainsByDestinationWithDepartTimeAfter(destinationOfTrainsWithDepartTimeAfter, departTime));
    }
}
