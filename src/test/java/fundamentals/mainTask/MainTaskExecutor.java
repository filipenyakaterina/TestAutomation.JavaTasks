package fundamentals.mainTask;

import java.util.*;

public class MainTaskExecutor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите номер программы, которую необходимо исполнить (1-5):");
        int programNumber = scanner.nextInt();
        switch (programNumber){
            case 1:
                SayHello();
                break;
            case 2:
                GetArgs(args);
                break;
            case 3:
                GetRandoms();
                break;
            case 4:
                GetSum(args);
                break;
            case 5:
                GetMonth();
                break;
            default:
                System.out.println("Введено неверное число!");
                break;
        }
    }

    private static void SayHello()
    {
        System.out.println("Введите ваше имя ");
        String name = scanner.next();
        System.out.println("Привет "+name+"!");
    }

    private static void GetArgs(String[] args)
    {
        String[] args2 = new String[args.length];
        for(int i=0; i < args.length; i++)
        {
            args2[args.length - 1 -i]=args[i];
        }
        for (String arg:args2) {
            System.out.println(arg);
        }
    }

    private static void GetRandoms()
    {
        System.out.println("Введите количество случайных чисел ");
        int numb = scanner.nextInt();
        Random random = new Random();
        for(int i=0;i<numb; i++)
        {
            System.out.println(random.nextInt());
        }
        for(int i=0;i<numb; i++)
        {
            System.out.print(random.nextInt()+" ");
        }
    }

    private static void GetSum(String[] args)
    {
        int sum, multiplication, argI;
        sum = 0;
        multiplication = 1;

        for(String arg:args)
        {
            argI = Integer.parseInt(arg);
            System.out.println(argI);
            sum += argI;
            multiplication *= argI;

        }
        System.out.println("Сумма аргументов командной строки " + sum);
        System.out.println("Произведение аргументов командной строки " + multiplication);
    }

    private static void GetMonth()
    {
        System.out.println("Введите число от 1 до 12 ");
        int number = scanner.nextInt();
        if (number <= 0 || number > 12)
        {
            System.out.println("Неверное число!");
        }
        else
        {
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.MONTH,number - 1);
            System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
        }
    }
}

