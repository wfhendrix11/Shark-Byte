package main;

import java.time.LocalDate;

public class RecurringTransaction extends Transaction {
    private int intervalInDays;
    private int numberOfExecutions;
    private boolean isPerpetual;

    RecurringTransaction() {
        super();
    }

    RecurringTransaction(LocalDate newDate, int newAmount, String newLabel, int newId,
            int newInterval, int newExecutions, boolean newIsPerpetual) {
        super(newDate, newAmount, newLabel, newId);

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
