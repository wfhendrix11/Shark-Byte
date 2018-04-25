package main;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MonthlyBudget {
    private int month;
    private int year;
    private Set<Transaction> transactions;
    private Map<String, Category> categories;
    private Set<String> labels;
    private Map<String, Integer> budgets;

    MonthlyBudget(int newMonth, int newYear) {
        transactions = new TreeSet<Transaction>();
        categories = new TreeMap<String, Category>();
        labels = new TreeSet<String>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        System.out.print("Transaction added.");
    }

    public void addCategory(String key, Category c) {
        categories.put(key, c);
        System.out.print("Category added.");
    }
}
