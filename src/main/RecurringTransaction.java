package main;

import java.time.LocalDate;

public class RecurringTransaction extends Transaction {
    private int intervalInDays;
    private int numberOfExecutions;
    private boolean isPerpetual;

    RecurringTransaction() {
        super();
    }

    RecurringTransaction(LocalDate newDate, double newAmount, String newLabel, int newId,
            String newMerchant, String newAccount, int newInterval, int newExecutions, boolean newIsPerpetual) {
        super(newDate, newAmount, newLabel, newId, newMerchant, newAccount);

        intervalInDays = newInterval;
        numberOfExecutions = newExecutions;
        isPerpetual = newIsPerpetual;
    }


    int getIntervalInDays() {
        return intervalInDays;
    }

    int getNumberOfExecutions() {
        return numberOfExecutions;
    }

    boolean isPerpetual() {
        return isPerpetual;
    }
}
