package classes.scenario;

import classes.container.HouseList;

public class HouseScenario extends Scenario {
    private final int roomNumber;
    private final int minFloor;
    private final int maxFloor;
    private final int area;
    private final HouseList houseList;

    public HouseScenario(int roomNumber, int minFloor, int maxFloor, int area) {
        this.roomNumber = roomNumber;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.area = area;
        houseList = new HouseList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок квартир, имеющих число комнат, равное " + roomNumber + ":");
        System.out.println(houseList.getApartmentsWhereRoomNumber(roomNumber));
        System.out.println("Список квартир, имеющих число комнат, равное " + roomNumber +
                ", и расположенных на этаже, который находится в промежутке от " + minFloor + " до " + maxFloor + ":");
        System.out.println(houseList.getApartmentsByRoomNumberAndFloor(roomNumber,minFloor,maxFloor));
        System.out.println("Список квартир, имеющих площадь, превосходящую " + area + ":");
        System.out.println(houseList.getApartmentsWithAreaMoreThan(area));
    }
}
