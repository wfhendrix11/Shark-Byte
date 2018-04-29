package main;

public class Category {
    private int month;
    private int year;
    private double priceLimit;
    private String label;

    public Category(String newLabel, double newPriceLimit, int newMonth, int newYear) {
        label = newLabel;
        month = newMonth;
        year = newYear;
        priceLimit = newPriceLimit;
    }

    public double getAmountSpent(){
        DatabaseConnector db = new DatabaseConnector();
        double amountSpent = db.getCategorySpending(label, month, year);
        return amountSpent;
    }

    public String getLabel(){
        return label;
    }

    public double getPriceLimit(){
        return priceLimit;
    }

    public int getMonth() { return month;}

    public int getYear() { return year;}
}
