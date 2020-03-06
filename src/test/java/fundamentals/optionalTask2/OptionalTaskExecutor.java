package fundamentals.optionalTask2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OptionalTaskExecutor {
    public static void main(String[] args)
    {
        int[][] array = createArray();
        printArray(array);
        System.out.println("Наибольшее число возрастающих элементов матрицы, идущих подряд равно " + getMaxCountOfAscendingNumbers(array));
    }

    private static int[][] createArray()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите N (размерность матрицы a [n] [n]):");
        int n = scanner.nextInt();
        System.out.println("Введите M (для определения интервала значений элементов матрицы):");
        int m = scanner.nextInt();
        int [][] numbers = new int[n][n];
        Random random  = new Random();

        for(int i=0; i<n; i++)
        {
            for(int j=0;j<n;j++)
            {
                numbers[i][j] = random.nextBoolean()?random.nextInt(m):(-1)*random.nextInt(m);
            }
        }
        return numbers;
    }

    private static void printArray(int[][] array)
    {
        System.out.println(Arrays.deepToString(array));
    }

    private static int getMaxCountOfAscendingNumbers(int[][] array)
    {
        int maxAscendingNum = 0;
        int ascendingNum = 1;
        int preNum = array[0][0];
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (ints[j] > preNum) {
                    ascendingNum++;
                } else {
                    if (maxAscendingNum < ascendingNum) {
                        maxAscendingNum = ascendingNum;
                    }
                    ascendingNum = 1;
                }
                preNum = ints[j];
            }
        }
        if(maxAscendingNum<ascendingNum)
        {
            maxAscendingNum=ascendingNum;
        }
        return maxAscendingNum;
    }
}

