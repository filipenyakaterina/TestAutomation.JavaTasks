package collections.optionalTask;

import collections.optionalTask.service.*;

import java.util.*;

public class Program {
    private final static String FILES_ROOT_PATH = "src/test/java/Collections/OptionalTask/resources/";
    private final static String POEM_FILE_NAME = "poem.txt";
    private final static String REVERSED_STRINGS_FILE_NAME = "reverseStrings.txt";
    private final static String STRINGS_FILE_NAME = "strings.txt";
    private final static String TEXT_FILE_NAME = "text.txt";

    private static final ConsolePrinter consolePrinter = new ConsolePrinter();
    private static final ConsoleReader consoleReader = new ConsoleReader();
    private static final Reader reader = new Reader();
    private static final Writer writer = new Writer();
    private static final Converter converter = new Converter();

    private static void reverseLinesFromFile(){
       List<String> lines = reader.readLinesFromFileToList(FILES_ROOT_PATH + STRINGS_FILE_NAME);
        List<String> reversedListOfLines = converter.reverseList(lines);
        writer.writeLinesToFile(reversedListOfLines,FILES_ROOT_PATH + REVERSED_STRINGS_FILE_NAME);
    }

    private static void printReversedNumbers(){
       String number = consoleReader.readNumberToStringFromConsole();
       Stack<Character> stackOfNumbers = converter.convertFromStringToStack(number);
       consolePrinter.printReversedNumberToConsole(stackOfNumbers);
    }

    private static void sortByLengthPoemLines(){
       List<String> poem = reader.readLinesFromFileToList(FILES_ROOT_PATH + POEM_FILE_NAME);
       List<String> sortedList = converter.sortByLineLength(poem);
       consolePrinter.print(sortedList);
    }

    private static void selectWords(){
        HashSet<String> words = reader.readWordsFromFile(FILES_ROOT_PATH + TEXT_FILE_NAME);
        consolePrinter.print(words);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер сценария, который необходимо исполнить (1-4)");
        int programNumber = scanner.nextInt();
        switch (programNumber){
            case 1:
                reverseLinesFromFile();
                System.out.println("Результат выполнения программы записан в файл " + FILES_ROOT_PATH + REVERSED_STRINGS_FILE_NAME);
                break;
            case 2:
                System.out.println("Вывод числа, у которого цифры идут в обратном порядке.");
                System.out.println("Введите исходное число:");
                printReversedNumbers();
                break;
            case 3:
                System.out.println("Строки стихотворения из файла " + POEM_FILE_NAME + ", отсортированные в порядке возрастания длин:");
                sortByLengthPoemLines();
                break;
            case 4:
                System.out.println("Различные слова исходного текста из файла " + TEXT_FILE_NAME);
                selectWords();
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }
}
