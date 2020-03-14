package collections.optionalTask.service;

import java.util.Scanner;

public class ConsoleReader {
    public String readNumberToStringFromConsole(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
