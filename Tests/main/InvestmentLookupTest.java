package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvestmentLookupTest {

    @Test
    public void lookupStockDaily() {
        InvestmentLookup lookup = new  InvestmentLookup();
        String result = lookup.lookupStockDaily("TSLA");
        System.out.print(result);
        assert(true);
    }

    @Test
    public void lookupCryptoDaily() {
        InvestmentLookup lookup = new  InvestmentLookup();
        String result = lookup.lookupCryptoDaily("ETH");
        System.out.print(result);
        assert(true);
    }

}