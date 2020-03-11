package classes.scenario;

import classes.container.PatientList;

public class PatientScenario extends Scenario {
    private final String diagnosis;
    private final int minMedicalCardNumber;
    private final int maxMedicalCardNumber;
    private final PatientList patientList;

    public PatientScenario(String diagnosis, int minMedicalCardNumber, int maxMedicalCardNumber) {
        this.diagnosis = diagnosis;
        this.minMedicalCardNumber = minMedicalCardNumber;
        this.maxMedicalCardNumber = maxMedicalCardNumber;
        patientList = new PatientList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок пациентов, имеющих диагноз " + diagnosis + ":");
        System.out.println(patientList.groupByDiagnosis(diagnosis));
        System.out.println("список пациентов, номер медицинской карты которых находится в интервале "
                + minMedicalCardNumber + "-" + maxMedicalCardNumber + ":");
        System.out.println(patientList.groupByMedicalCardNumber(minMedicalCardNumber,maxMedicalCardNumber));
    }
}
