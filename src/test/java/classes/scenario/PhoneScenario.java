package classes.scenario;

import classes.container.PhoneList;

public class PhoneScenario extends Scenario {
    private final int timeOfCityCalls;
    private final PhoneList phoneList;

    public PhoneScenario(int timeOfCityCalls) {
        this.timeOfCityCalls = timeOfCityCalls;
        phoneList = new PhoneList();
    }

    @Override
    public void execute() {
        System.out.println("Сведения об абонентах, у которых время внутригородских разговоров превышает " + timeOfCityCalls + ":");
        System.out.println(phoneList.getSubscriberWithTimeOfCityCallsMoreThan(timeOfCityCalls));
        System.out.println("Cведения об абонентах, которые пользовались междугородной связью:");
        System.out.println(phoneList.getSubscribesWhoUseIntercityCalls());
        System.out.println("Cведения об абонентах в алфавитном порядке (по фамилии):");
        System.out.println(phoneList.sortSubscribesWithAlphabetOrder());
    }
}
