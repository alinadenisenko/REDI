package lesson16;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankApplication application = new BankApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter what statistics you want to see: \n");
            System.out.println("1 - My biggest payment\n" +
                    "2 - My total income\n" +
                    "3 - How do I spend my money\n" +
                    "4 - Statistics for 1 year\n" +
                    "5 - The Biggest income \n"+
                    "6 - the Total spending\n"+
                    "0 - exit\n");

            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    application.printBiggestPayment();
                    break;
                case 2:
                    application.printTotalIncome();
                    break;
                case 3:
                    application.printCategoryStatistics();
                    break;

                case 4:
                    System.out.println("Enter a year:  \n");
                    int year = Integer.parseInt(scanner.nextLine());
                    application.printYearStatistics(year);

                    break;
                case 5:
                    application.printBiggestIncome();
                    break;
                case 6:
                    application.printTotalSpendings();
                    break;
                default:
                    System.out.println("Incorrect input. Please try again");
                    break;
            }

            if (input == 0) {
                break;
            }
        }

    }
}
