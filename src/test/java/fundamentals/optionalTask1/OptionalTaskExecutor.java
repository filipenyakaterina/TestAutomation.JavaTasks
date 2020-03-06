package fundamentals.optionalTask1;

import java.util.Scanner;

public class OptionalTaskExecutor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = setNumbers();
        System.out.println("Введите номер программы, которую необходимо исполнить (1-2):");
        int programNumber = scanner.nextInt();
        switch (programNumber){
            case 1:
                getAverageNumberLength(num);
                break;
            case 2:
                getNumbersInAscendingOrderOfLength(num);
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }

    private static int[] setNumbers()
    {
        System.out.println("Введите количество чисел:");
        int count = scanner.nextInt();
        int [] numbers = new int[count];
        System.out.println("Введите числа:");
        for(int i=0; i<count; i++)
        {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    private static int getMinNumber(int[] numbers)
    {
        int minNumber = 0;
        int min= numbers[0];
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]<min)
            {
                min=numbers[i];
                minNumber=i;
            }
        }
        return minNumber;
    }

    private static int[] shiftArray(int[] numbers,int num)
    {
        int[] resultArray =new int [numbers.length-1];
        int s = 0;
        for(int i=0;i<numbers.length;i++)
        {
            if(i!=num)
            {
            resultArray[s] = numbers[i];
            s++;
            }
        }
        return resultArray;
    }

    private static void getNumbersInAscendingOrderOfLength(int[] numbers)
    {
        int[] ascendingNumbers = new int[numbers.length];
        for(int i=0;i<ascendingNumbers.length;i++)
        {
            int min = getMinNumber(numbers);
            ascendingNumbers[i] = numbers[min];
            numbers=shiftArray(numbers,min);
        }
        System.out.println("Числа в порядке возрастания значений их длины:");
        for(int n:ascendingNumbers)
        {
            System.out.println(n);
        }
    }

    private static void getAverageNumberLength(int[] numbers)
    {
        int [][] numbersLength = new int[numbers.length][2];
        double length = 0;
        for(int i=0;i<numbers.length;i++)
        {
            numbersLength[i][0]=numbers[i];
            int len = Integer.toString(numbers[i]).length();
            numbersLength[i][1]=len;
            length += len;
        }
        length = length/(double)numbers.length;
        System.out.println("Cредняя длина по всем числам сотставляет " + length);
        System.out.println("Числа, длина которых меньше средней:");
        for (int i=0;i<numbers.length;i++)
        {
            if(numbersLength[i][1]<length)
            {
                System.out.println(numbersLength[i][0]+" "+numbersLength[i][1]);
            }
        }
    }
}
