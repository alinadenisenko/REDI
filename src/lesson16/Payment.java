package lesson16;

public class Payment {

    private int id;
    private double amount;
    private String category;
    private int month;
    private int year;

    public Payment(int id, double amount, String category, int month, int year) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String printPayment() {
        return id + ": [" + amount + ", " + category + ", " + month + ", " + year + "]";
    }

}
