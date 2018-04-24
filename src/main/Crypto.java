package main;

public class Crypto extends Investment {
    private double numberOwned;

    public Crypto(String nameIn, double numberOwnedIn){
        super(nameIn);
        numberOwned = numberOwnedIn;
    }

    public void setNumberOwned(double numberOwnedIn){
        numberOwned = numberOwnedIn;
    }

    public double getNumberOwned(){
        return numberOwned;
    }
}
