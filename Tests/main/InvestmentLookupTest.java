package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvestmentLookupTest {

    @Test
    public void lookupStockDaily() {
        InvestmentLookup lookup = new  InvestmentLookup();
        lookup.lookupStockDaily("TSLA");
        assert(true);
    }

    @Test
    public void lookupCryptoDaily() {
        InvestmentLookup lookup = new  InvestmentLookup();
        lookup.lookupCryptoDaily("ETH");
        assert(true);
    }

}