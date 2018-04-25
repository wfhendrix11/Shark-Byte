package main;

public class CustomAsset extends Investment {
    private double interestRate;
    private double currentValue;
    private int quantity;

    public CustomAsset(String nameIn, int quantityIn, double interestRateIn, double currentValueIn){
        super(nameIn);
        interestRate = interestRateIn;
        currentValue = currentValueIn;
        quantity = quantityIn;
    }

    public void setInterestRate(double interestRateIn){
        interestRate = interestRateIn;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void updateCurrentValue(double newValue){
        currentValue = newValue;
    }

    public double getCurrentValue(){
        return currentValue;
    }

    public void updateQuantity(int quantityIn){
        quantity = quantityIn;
    }

    public int getQuantity(){
        return quantity;
    }

    public String toString(){
        return (getName() + "\nPrice: " + getCurrentValue() + "\nInterest Rate: " + getInterestRate());
    }
}
