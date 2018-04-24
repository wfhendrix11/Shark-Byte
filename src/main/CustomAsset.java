package main;

public class CustomAsset extends Investment {
    private double interestRate;
    private double currentValue;

    public CustomAsset(String nameIn, double interestRateIn, double currentValueIn){
        super(nameIn);
        interestRate = interestRateIn;
        currentValue = currentValueIn;
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

    public String toString(){
        return (getName() + "\nPrice: " + getCurrentValue() + "\nInterest Rate: " + getInterestRate());
    }
}
