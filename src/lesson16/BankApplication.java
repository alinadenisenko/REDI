package lesson16;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

    public static void main(String[] args) {
        Payment inCafe = new Payment(1, -10.0, "Cafe", 10, 2019);
        Payment inCafe2 = new Payment(2, -11.2, "Cafe", 9, 2019);
        Payment rentOctober = new Payment(3, -302.0, "House", 10, 2019);
        Payment rentNovember = new Payment(4, -302.0, "House", 11, 2019);
        Payment foodRewe = new Payment(5, -12.0, "Groceries", 10, 2019);
        Payment salaryOctober = new Payment(6, 1200, "Salary", 10, 2019);
        Payment salaryNovember = new Payment(7, 1200, "Salary", 11, 2019);

        Map<Integer, Payment> payments = new HashMap<>();
        payments.put(inCafe.getId(), inCafe);
        payments.put(inCafe2.getId(), inCafe2);
        payments.put(rentOctober.getId(), rentOctober);
        payments.put(rentNovember.getId(), rentNovember);
        payments.put(foodRewe.getId(), foodRewe);
        payments.put(salaryOctober.getId(), salaryOctober);
        payments.put(salaryNovember.getId(), salaryNovember);

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

        System.out.println("The biggest payment is " + theBiggestPayment.printPayment());


        int sum = 0;
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            if (entry.getValue().getAmount() >= 0) {
                sum += entry.getValue().getAmount();
            }
        }
        System.out.println("The total income is: " + sum);

        Map<String, Double> inCategories = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry: payments.entrySet()) {
            Payment payment = entry.getValue();
            String category = payment.getCategory();

            double categorySum = inCategories.getOrDefault(category, 0.0);
            categorySum += payment.getAmount();
            inCategories.put(category, categorySum);
        }

        System.out.println(inCategories);
    }

}
