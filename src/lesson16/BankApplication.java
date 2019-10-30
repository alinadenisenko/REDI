package lesson16;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

    private Map<Integer, Payment> payments = new HashMap<>();

    public BankApplication() {
        Payment inCafe = new Payment(1, -10.0, "Cafe", 10, 2019);
        Payment inCafe2 = new Payment(2, -11.2, "Cafe", 9, 2019);
        Payment rentOctober = new Payment(3, -302.0, "House", 10, 2019);
        Payment rentNovember = new Payment(4, -302.0, "House", 11, 2019);
        Payment foodRewe = new Payment(5, -12.0, "Groceries", 10, 2019);
        Payment salaryOctober = new Payment(6, 1200, "Salary", 10, 2019);
        Payment salaryNovember = new Payment(7, 1200, "Salary", 11, 2019);

        payments.put(inCafe.getId(), inCafe);
        payments.put(inCafe2.getId(), inCafe2);
        payments.put(rentOctober.getId(), rentOctober);
        payments.put(rentNovember.getId(), rentNovember);
        payments.put(foodRewe.getId(), foodRewe);
        payments.put(salaryOctober.getId(), salaryOctober);
        payments.put(salaryNovember.getId(), salaryNovember);
    }

    public void printBiggestPayment() {
        Payment theBiggestPayment = null;
        for(Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            if (entry.getValue().getAmount() >= 0) {
                continue;
            }

            if (theBiggestPayment == null) {
                theBiggestPayment = entry.getValue();
            }

            if (theBiggestPayment.getAmount() > entry.getValue().getAmount()) {
                theBiggestPayment = entry.getValue();
            }
        }

        if (theBiggestPayment != null) {
            System.out.println("The biggest payment is " + theBiggestPayment.printPayment());
        } else {
            System.out.println("There is no payments!");
        }
    }

    public void printTotalIncome() {
        int sum = 0;
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            if (entry.getValue().getAmount() >= 0) {
                sum += entry.getValue().getAmount();
            }
        }
        System.out.println("The total income is: " + sum);
    }

    public void printCategoryStatistics() {
        Map<String, Double> inCategories = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            Payment payment = entry.getValue();
            String category = payment.getCategory();

            double categorySum = inCategories.getOrDefault(category, 0.0);
            categorySum += payment.getAmount();
            inCategories.put(category, categorySum);
        }

        System.out.println("Payments categories: ");
        System.out.println(inCategories);
    }

    public void printYearStatistics(int year) {
        System.out.println("Statistics of the payments for the year: " + year);
        Map<Integer, Double> incomeInMonths = new HashMap<>();
        Map<Integer, Double> spendingsInMonths = new HashMap<>();
        for (int i = 1; i<=12; i++) {
            incomeInMonths.put(i, 0.0);
            spendingsInMonths.put(i, 0.0);
        }
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            Payment payment = entry.getValue();
            if (payment.getYear() != year) {
                continue;
            }
            Integer month = payment.getMonth();
            if (payment.getAmount() > 0) {
                double sum = incomeInMonths.get(month);
                sum += payment.getAmount();
                incomeInMonths.put(month, sum);
            } else {
                double sum = spendingsInMonths.get(month);
                sum += payment.getAmount();
                spendingsInMonths.put(month, sum);
            }
        }
        for (int i = 1; i<=12; i++) {
            System.out.println("In the " + MonthUtils.getMonthName(i) + " you earned: " +  incomeInMonths.get(i)
                    + ", and spent: " + spendingsInMonths.get(i));
        }
    }

    public void printBiggestIncome() {
        Payment theBiggestIncome = null;

        for(Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            if (entry.getValue().getAmount() <= 0) {
                continue;
            }

            if (theBiggestIncome == null) {
                theBiggestIncome = entry.getValue();
            }

            if (theBiggestIncome.getAmount() < entry.getValue().getAmount()) {
                theBiggestIncome = entry.getValue();
            }
        }

        if (theBiggestIncome != null) {
            System.out.println("The biggest income is: " + theBiggestIncome.printPayment());
        } else {
            System.out.println("There is no income!");
        }
    }

    public void printTotalSpendings() {
        int sum = 0;
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            if (entry.getValue().getAmount() <= 0) {
                sum += entry.getValue().getAmount();
            }
        }
        System.out.println("The total spendings is: " + sum);
    }
}
