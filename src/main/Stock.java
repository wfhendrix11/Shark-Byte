package main;

public class Stock extends Investment {

    private int numberOfShares;

    public Stock(String nameIn, int numberOfSharesIn){
        super(nameIn);
        numberOfShares = numberOfSharesIn;
    }

    public void setNumberOfShares(int numberOfSharesIn){
        numberOfShares = numberOfSharesIn;
    }

    public int getNumberOfShares(){
        return numberOfShares;
    }
}
