package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MonthlyBudget {
    private int month;
    private int year;
    //private double spendingAmount;
    //private double budgetAmount;
    //private Set<Transaction> transactions;
    private Set<Category> categories;
    //private Set<String> labels;
   // private Map<String, Integer> budgets;

    MonthlyBudget(int newMonth, int newYear) {
        month = newMonth;
        year = newYear;
        //spendingAmount = 0;
       // budgetAmount = newBudgetAmount;
        //transactions = new TreeSet<Transaction>();
        categories = new TreeSet<Category>();
        //labels = new TreeSet<String>();
    }

    /*public void addTransaction(Transaction t) {
        transactions.add(t);
        System.out.print("Transaction added.");
    }*/

    public void addCategory(Category c) {
        categories.add(c);
        System.out.print("Category added.");
    }

    public ObservableList<Category> getCategories(){
        ObservableList<Category> result = FXCollections.observableArrayList();
        result.addAll(categories);
        return result;
    }
}
