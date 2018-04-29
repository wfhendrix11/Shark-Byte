package main;
/**
 * Sample Skeleton for 'shark_byte_gui.fxml' Controller Class
 */

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.time.LocalDate;
import java.util.*;

public class FXController {

    @FXML // fx:id="quitButton"
    private Button quitButton; //Value injected by FXMLLoader

    @FXML // fx:id="selectBudgetChoiceBox"
    private ChoiceBox<MonthlyBudget> selectBudgetChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="selectBankAccountChoiceBox"
    private ChoiceBox<BankAccount> selectBankAccountChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionsTable"
    private TableView<Transaction> accountTransactionsTable; // Value injected by FXMLLoader

    @FXML // fx:id="favoritesPriceColumn"
    private TableColumn<?, ?> favoritesPriceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="recurringRadio"
    private RadioButton recurringRadio; // Value injected by FXMLLoader

    @FXML // fx:id="transactionDatePicker"
    private DatePicker transactionDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="addBankAccountButton"
    private Button addBankAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="filterMerchantChoiceBox"
    private ChoiceBox<?> filterMerchantChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="budgetsTab"
    private Tab budgetsTab; // Value injected by FXMLLoader

    @FXML // fx:id="favoritesTable"
    private TableView<?> favoritesTable; // Value injected by FXMLLoader

    @FXML // fx:id="home_recentTransactions"
    private TableView<Transaction> home_recentTransactions; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentSymbolField"
    private TextField newInvestmentSymbolField; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentTypeChoiceBox"
    private ChoiceBox<?> newInvestmentTypeChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="investmentsTab"
    private Tab investmentsTab; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionAmountColumn"
    private TableColumn<Transaction, String> accountTransactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="homeTab"
    private Tab homeTab; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionAmountColumn"
    private TableColumn<Transaction, String> TransactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transactionLabelChoiceBox"
    private ChoiceBox<?> transactionLabelChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="thisMonthSpendingChart"
    private PieChart thisMonthSpendingChart; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioAmountColumn"
    private TableColumn<Investment, String> portfolioAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionPerpetualColumn"
    private TableColumn<Transaction, String> TransactionPerpetualColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetSpendingColumn"
    private TableColumn<Transaction, String> budgetSpendingColumn; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioValueColumn"
    private TableColumn<Investment, String> portfolioValueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="filterAmountChoiceBox"
    private ChoiceBox<?> filterAmountChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentQtyField"
    private TextField newInvestmentQtyField; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentInterestRateField"
    private TextField newInvestmentInterestRateField; //Value injected by FXMLLoader

    @FXML // fx:id="transactionAmountField"
    private TextField transactionAmountField; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionLabelColumn"
    private TableColumn<Transaction, String> TransactionLabelColumn; // Value injected by FXMLLoader

    @FXML // fx:id="filterBankAccountChoiceBox"
    private ChoiceBox<?> filterBankAccountChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="searchAssetButton"
    private Button searchAssetButton; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioValueChart"
    private LineChart<?, ?> portfolioValueChart; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentPriceField"
    private TextField newInvestmentPriceField; // Value injected by FXMLLoader

    @FXML // fx:id="filterLabelChoiceBox"
    private ChoiceBox<?> filterLabelChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioAssetColumn"
    private TableColumn<Investment, String> portfolioAssetColumn; // Value injected by FXMLLoader

    @FXML // fx:id="symbolField"
    private TextField symbolField; // Value injected by FXMLLoader

    @FXML // fx:id="transactionMerchantField"
    private TextField transactionMerchantField; // Value injected by FXMLLoader

    @FXML // fx:id="home_transactionMerchantColumn"
    private TableColumn<Transaction, String> home_transactionMerchantColumn; // Value injected by FXMLLoader

    @FXML // fx:id="thisMonthBudgetChart"
    private PieChart thisMonthBudgetChart; // Value injected by FXMLLoader

    @FXML // fx:id="newLabelButton"
    private Button newLabelButton; // Value injected by FXMLLoader

    @FXML // fx:id="newBudgetButton"
    private Button newBudgetButton; // Value injected by FXMLLoader

    @FXML // fx:id="home_thisMonthSpendingChart"
    private PieChart home_thisMonthSpendingChart; // Value injected by FXMLLoader

    @FXML // fx:id="accountName"
    private Text accountName; // Value injected by FXMLLoader

    @FXML // fx:id="ManageAccountButton"
    private Button ManageAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="filterDateChoiceBox"
    private ChoiceBox<?> filterDateChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="transactionBankAccountChoiceBox"
    private ChoiceBox<?> transactionBankAccountChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioTable"
    private TableView<Investment> portfolioTable; // Value injected by FXMLLoader

    @FXML // fx:id="home_transactionAmountColumn"
    private TableColumn<Transaction, String> home_transactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetCategoriesTable"
    private TableView<Category> budgetCategoriesTable; // Value injected by FXMLLoader

    @FXML // fx:id="accountValueChart"
    private LineChart<?, ?> accountValueChart; // Value injected by FXMLLoader


    @FXML // fx:id="enterTransactionButton"
    private Button enterTransactionButton; // Value injected by FXMLLoader

    @FXML // fx:id="favoritesSymbolColumn"
    private TableColumn<?, ?> favoritesSymbolColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetAmountColumn"
    private TableColumn<Category, String> budgetAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="recordInvestmentButton"
    private Button recordInvestmentButton; // Value injected by FXMLLoader

    @FXML // fx:id="home_investmentValueChart"
    private LineChart<?, ?> home_investmentValueChart; // Value injected by FXMLLoader

    @FXML // fx:id="home_transactionDateColumn"
    private TableColumn<Transaction, String> home_transactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionBankAccountColumn"
    private TableColumn<Transaction, String> TransactionBankAccountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionDateColumn"
    private TableColumn<Transaction, String> accountTransactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetCategoryColumn"
    private TableColumn<Category, String> budgetCategoryColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionsTable"
    private TableView<Transaction> TransactionsTable; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioPriceColumn"
    private TableColumn<Investment, String> portfolioPriceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="home_thisMonthBudgetChart"
    private PieChart home_thisMonthBudgetChart; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionMerchantColumn"
    private TableColumn<Transaction, String> TransactionMerchantColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionDateColumn"
    private TableColumn<Transaction, String> TransactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transactionTab"
    private Tab transactionTab; // Value injected by FXMLLoader

    @FXML // fx:id="bankAccountTab"
    private Tab bankAccountTab; // Value injected by FXMLLoader

    @FXML // fx:id="assetTypeChoiceBox"
    private ComboBox<?> assetTypeChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionLabelColumn"
    private TableColumn<Transaction, String> accountTransactionLabelColumn; // Value injected by FXMLLoader

    @FXML // fx:id="accountBalance"
    private Text accountBalance; // Value injected by FXMLLoader


    @FXML
    void quitProgram(ActionEvent event){

    }

    @FXML
    void homeTabChanged(Event event) {
        if(homeTab.isSelected()){
            fillHomeScreenTransactionsTable();
            //populateSelectBudgetChoiceBox();
            //drawHomeScreenPieCharts();
        }
    }

    @FXML
    void manageAccount(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        dialog.setTitle("Change Password");
        VBox dialogVbox = new VBox(20);

        Text oldPasswordText = new Text("Enter OLD password: ");

        TextField oldPasswordField = new TextField();
        oldPasswordField.setPromptText("OLD Password");

        Text newPasswordText = new Text("Enter NEW password: ");

        TextField newPasswordField = new TextField();
        newPasswordField.setPromptText("NEW Password");

        Button submitButton = new Button();
        submitButton.setText("Submit");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConnector db = new DatabaseConnector();
                String text = newPasswordField.getCharacters().toString();

                // ADD USERNAME TO DATABASE
                if (db.verifyPassword(text)) {
                    db.replacePassword(text);
                    db.close();
                    dialog.close();
                }
                else {
                    // TODO notify incorrect password
                }

                //TODO remove this line once the above is implemented
                dialog.close();
            }
        };

        submitButton.setOnAction(handler);

        dialogVbox.getChildren().add(oldPasswordText);
        dialogVbox.getChildren().add(oldPasswordField);
        dialogVbox.getChildren().add(newPasswordText);
        dialogVbox.getChildren().add(newPasswordField);
        dialogVbox.getChildren().add(submitButton);
        Scene dialogScene = new Scene(dialogVbox, 400, 250);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void transactionTabChanged(Event event) {
        updateTransactionLabels();
        updateTransactionBankAccounts();
        fillTransactionsTable();
    }

    @FXML
    void enterTransaction(ActionEvent event) {
        // transactionLabelChoiceBox
        // transactionBankAccountChoiceBox
        // transactionMerchantField
        // transactionAmountField
        // transactionDatePicker
        DatabaseConnector db = new DatabaseConnector();

        LocalDate date = transactionDatePicker.getValue();
        String merchant = transactionMerchantField.getText();
        double amount = Double.parseDouble(transactionAmountField.getText());
        int id = db.getNextTransactionId();
        String label = transactionLabelChoiceBox.getValue().toString();
        String account = transactionBankAccountChoiceBox.getValue().toString();
        boolean recurring = recurringRadio.isSelected();

        Transaction transaction = new Transaction(date, amount, label, id, merchant, account, recurring);
        db.insertTransaction(transaction);
        db.close();
        fillTransactionsTable();
    }

    @FXML
    void newBudgetCategory(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        dialog.setTitle("New Budget Category");
        VBox dialogVBox = new VBox(20);

        DatabaseConnector db = new DatabaseConnector();
        ObservableList<String> labels =  db.selectLabels();
        db.close();
        ChoiceBox<String> labelPicker = new ChoiceBox<String>();
        labelPicker.setItems(labels);
        labelPicker.getSelectionModel().selectFirst();

        TextField amount = new TextField();
        amount.setPromptText("Price Limit");

        Button addNewCategoryButton = new Button();
        addNewCategoryButton.setText("Add new category");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConnector db = new DatabaseConnector();
                String label = labelPicker.getValue();
                double priceLimit = Double.parseDouble(amount.getText());
                int month = selectBudgetChoiceBox.getValue().getMonth();
                int year = selectBudgetChoiceBox.getValue().getYear();
                Category newCategory = new Category(label, priceLimit, month, year);
                db.insertCategory(newCategory);
                db.close();
                dialog.close();
;            }
        };

        addNewCategoryButton.setOnAction(handler);

        dialogVBox.getChildren().add(labelPicker);
        dialogVBox.getChildren().add(amount);
        dialogVBox.getChildren().add(addNewCategoryButton);
        Scene dialogScene = new Scene(dialogVBox, 300, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void addNewLabel(ActionEvent event) {
        // TODO Lawrence working on this
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        dialog.setTitle("Add Label");
        VBox dialogVbox = new VBox(20);

        TextField labelField = new TextField();
        labelField.setPromptText("Label");

        Button submitButton = new Button();
        submitButton.setText("Submit");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConnector db = new DatabaseConnector();
                String text = labelField.getCharacters().toString();

                // TODO DATABASE
                db.insertLabel(text);
                db.close();

                // TODO FINISH THIS
                updateTransactionLabels();
                dialog.close();
            }
        };

        submitButton.setOnAction(handler);

        dialogVbox.getChildren().add(labelField);
        dialogVbox.getChildren().add(submitButton);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void bankAccountTabChanged(Event event) {
        populateSelectBankAccountChoiceBox();
        fillBankAccountTransactionsTable();
        setBankAccountBalanceText();
    }

    @FXML
    void addBankAccount(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        dialog.setTitle("Create New Bank Account");
        VBox dialogVbox = new VBox(20);

        TextField field = new TextField();
        field.setPromptText("Executions");

        TextField labelField = new TextField();
        labelField.setPromptText("Name");

        Button submitButton = new Button();
        submitButton.setText("Submit");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConnector db = new DatabaseConnector();
                String text = labelField.getCharacters().toString();

                // ADD USERNAME TO DATABASE
                //db.replacePassword(text);
                dialog.close();
            }
        };

        submitButton.setOnAction(handler);

        dialogVbox.getChildren().add(labelField);
        dialogVbox.getChildren().add(submitButton);
        Scene dialogScene = new Scene(dialogVbox, 400, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void budgetsTabChanged(Event event) {
        populateSelectBudgetChoiceBox();
        fillBudgetTransactionsTable();
    }

    @FXML
    void addNewBudget(ActionEvent event) {

        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        dialog.setTitle("Create New Budget");
        VBox dialogVbox = new VBox(20);

        Text chooseBudgetText = new Text("Choose budget type: ");

        Button monthlyBudgetButton = new Button();
        monthlyBudgetButton.setText("Monthly Budget");

        Button yearlyBudgetButton = new Button();
        yearlyBudgetButton.setText("Yearly Budget");

        Button submitButton = new Button();
        submitButton.setText("Submit");

        EventHandler<ActionEvent> handler3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //populateSelectBudgetChoiceBox();
                dialog.close();
            }
        };

        submitButton.setOnAction(handler3);

        // MONTHLY BUDGET FORM
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //dialog.close();
                Node source = (Node) event.getSource();
                Window theStage = source.getScene().getWindow();
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(theStage);
                dialog.setTitle("Create New MONTHLY Budget");
                VBox dialogVbox = new VBox(20);

                Text monthText = new Text("Enter Month: ");

                TextField monthField = new TextField();
                monthField.setPromptText("Month");

                Text yearText = new Text("Enter Year: ");

                TextField yearField = new TextField();
                yearField.setPromptText("Year");


                // ADD TO DATABASE
                //MonthlyBudget newMonthlyBudget = new MonthlyBudget(Integer.parseInt(budgetMonth), Integer.parseInt(budgetYear));

                dialogVbox.getChildren().add(monthText);
                dialogVbox.getChildren().add(monthField);
                dialogVbox.getChildren().add(yearText);
                dialogVbox.getChildren().add(yearField);
                dialogVbox.getChildren().add(submitButton);
                Scene dialogScene = new Scene(dialogVbox, 300, 250);
                dialog.setScene(dialogScene);
                dialog.show();
                }
        };

        monthlyBudgetButton.setOnAction(handler);

        // YEARLY BUDGET FORM
        EventHandler<ActionEvent> handler2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //dialog.close();
                Node source = (Node) event.getSource();
                Window theStage = source.getScene().getWindow();
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(theStage);
                dialog.setTitle("Create New YEARLY Budget");
                VBox dialogVbox = new VBox(20);

                Text yearText = new Text("Enter Year: ");

                TextField yearField = new TextField();
                yearField.setPromptText("Year");

                // ADD TO DATABASE
                //MonthlyBudget newMonthlyBudget = new MonthlyBudget(Integer.parseInt(budgetMonth), Integer.parseInt(budgetYear));

                dialogVbox.getChildren().add(yearText);
                dialogVbox.getChildren().add(yearField);
                dialogVbox.getChildren().add(submitButton);
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        };

        yearlyBudgetButton.setOnAction(handler2);

        dialogVbox.getChildren().add(chooseBudgetText);
        dialogVbox.getChildren().add(monthlyBudgetButton);
        dialogVbox.getChildren().add(yearlyBudgetButton);
        Scene dialogScene = new Scene(dialogVbox, 200, 150);
        dialog.setScene(dialogScene);
        dialog.show();

    }

    @FXML
    void investmentsTabChanged(Event event) {
        if(investmentsTab.isSelected()) {
            populateAssetTypeChoiceBox();
            populateNewInvestmentTypeChoiceBox();
            fillPortfolio();
        }
    }


    @FXML
    void searchAsset(ActionEvent event) {
        String symbol = symbolField.getText();

        String assetType = assetTypeChoiceBox.getValue().toString();

        String searchResult = "Invalid Search";

        if(assetType.equals("Stock")) {
            searchResult = InvestmentLookup.lookupStockDaily(symbol);
            int indexOfMostRecentClose = searchResult.indexOf("4. close") + 12;
            String mostRecentClose = searchResult.substring(indexOfMostRecentClose, indexOfMostRecentClose + 7);
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(theStage);
            VBox dialogVbox = new VBox(20);
            Text resultText = new Text("Most recent closing price: " + mostRecentClose);
            dialogVbox.getChildren().add(new Text(symbol));
            dialogVbox.getChildren().add(resultText);
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
        }
        else if(assetType.equals("Crypto")){
            searchResult = InvestmentLookup.lookupCryptoDaily(symbol);
            int indexOfMostRecentClose = searchResult.indexOf("close") + 15;
            int indexOfEndOfClose = searchResult.indexOf("\"", indexOfMostRecentClose);
            String mostRecentClose = searchResult.substring(indexOfMostRecentClose, indexOfEndOfClose);//indexOfMostRecentClose + 12);

            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(theStage);
            VBox dialogVbox = new VBox(20);

            Text resultText = new Text("Most recent closing price: " + mostRecentClose);
            dialogVbox.getChildren().add(new Text(symbol));
            dialogVbox.getChildren().add(resultText);

            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
        }
    }

    @FXML
    void recordInvestment(ActionEvent event) {
        switch(newInvestmentTypeChoiceBox.getValue().toString()){
            case "Stock":
                String stockName = newInvestmentSymbolField.getText();
                int sharesOwned = Integer.parseInt(newInvestmentQtyField.getText());
                Stock stockToRecord = new Stock(stockName, sharesOwned);
                //System.out.print(stockToRecord);
                DatabaseConnector db = new DatabaseConnector();
                db.insertInvestment(stockToRecord);
                db.close();
                fillPortfolio();
                break;
            case "Crypto":
                String cryptoName = newInvestmentSymbolField.getText();
                double numberOwned = Double.parseDouble(newInvestmentQtyField.getText());
                Crypto cryptoToRecord = new Crypto(cryptoName, numberOwned);
                //System.out.print(cryptoToRecord);
                DatabaseConnector db2 = new DatabaseConnector();
                db2.insertInvestment(cryptoToRecord);
                db2.close();
                fillPortfolio();
                break;
            case "Custom":
                String assetName = newInvestmentSymbolField.getText();
                double price = Double.parseDouble(newInvestmentPriceField.getText());
                double interestRate = Double.parseDouble(newInvestmentInterestRateField.getText());
                int quantity = Integer.parseInt(newInvestmentQtyField.getText());
                CustomAsset assetToRecord = new CustomAsset(assetName, quantity, interestRate, price);
                //System.out.print(assetToRecord);
                DatabaseConnector db3 = new DatabaseConnector();
                db3.insertInvestment(assetToRecord);
                db3.close();
                fillPortfolio();
                break;
        }
    }

    void updateTransactionLabels() {
        DatabaseConnector db = new DatabaseConnector();
        ObservableList<String> labels = db.selectLabels();
        db.close();

        ObservableList labelItems = FXCollections.observableArrayList();

        for (String s : labels) {
            labelItems.add(s);
        }

        transactionLabelChoiceBox.setItems(labelItems);
        transactionLabelChoiceBox.getSelectionModel().selectFirst();
    }

    //Fills contents of choice box for searching investments
    void populateAssetTypeChoiceBox(){
        ObservableList assetTypes = FXCollections.observableArrayList();
        assetTypes.add("Stock");
        assetTypes.add("Crypto");
        assetTypeChoiceBox.setItems(assetTypes);
        assetTypeChoiceBox.getSelectionModel().selectFirst();
    }
    void updateTransactionBankAccounts() {
        DatabaseConnector db = new DatabaseConnector();
        ArrayList<BankAccount> accounts = db.selectBankAccounts();
        db.close();

        ObservableList accountItems = FXCollections.observableArrayList();

        for (BankAccount ba : accounts) {
            accountItems.add(ba);
        }

        transactionBankAccountChoiceBox.setItems(accountItems);
        transactionBankAccountChoiceBox.getSelectionModel().selectFirst();
    }

    //Fills contents of choice box for recording investments
    void populateNewInvestmentTypeChoiceBox(){
        ObservableList assetTypes = FXCollections.observableArrayList();
        assetTypes.add("Stock");
        assetTypes.add("Crypto");
        assetTypes.add("Custom");
        newInvestmentTypeChoiceBox.setItems(assetTypes);
        newInvestmentTypeChoiceBox.getSelectionModel().selectFirst();
    }


 //Fill the content of the portfolio table
    private void fillPortfolio(){

        DatabaseConnector db = new DatabaseConnector();
        ObservableList<Investment> portfolio = db.getPortfolio();
        db.close();

        //portfolioAssetColumn
        //portfolioAmountColumn
        //portfolioPriceColumn
        //portfolioValueColumn

        portfolioAssetColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getName()));
        portfolioAmountColumn.setCellValueFactory(data -> {
            if(data.getValue() instanceof Stock)return new ReadOnlyStringWrapper(Integer.toString(((Stock) data.getValue()).getNumberOfShares()));
            else if(data.getValue() instanceof Crypto) return new ReadOnlyStringWrapper(Double.toString(((Crypto) data.getValue()).getNumberOwned()));
            else return new ReadOnlyStringWrapper(Double.toString(((CustomAsset) data.getValue()).getQuantity()));
        });
        portfolioPriceColumn.setCellValueFactory(data -> {
            if(data.getValue() instanceof Stock) return new ReadOnlyStringWrapper(Double.toString(InvestmentLookup.getMostRecentStockPrice(data.getValue().getName())));
            else if(data.getValue() instanceof Crypto) return new ReadOnlyStringWrapper(Double.toString(InvestmentLookup.getMostRecentCryptoPrice(data.getValue().getName())));
            else return new ReadOnlyStringWrapper(Double.toString(((CustomAsset) data.getValue()).getCurrentValue()));
        });
        portfolioValueColumn.setCellValueFactory(data -> {
           if(data.getValue() instanceof Stock) return new ReadOnlyStringWrapper(
                   Double.toString(((Stock) data.getValue()).getNumberOfShares()*(InvestmentLookup.getMostRecentStockPrice(data.getValue().getName())))
           );
           else if(data.getValue() instanceof Crypto) return new ReadOnlyStringWrapper(
                   Double.toString(((Crypto) data.getValue()).getNumberOwned() * InvestmentLookup.getMostRecentCryptoPrice(data.getValue().getName()))
           );
           else return new ReadOnlyStringWrapper(
                   Double.toString((((CustomAsset) data.getValue()).getQuantity()) * (((CustomAsset) data.getValue()).getCurrentValue()))
                   );
        });
        portfolioTable.setItems(portfolio);
    }

    private void fillHomeScreenTransactionsTable(){

        DatabaseConnector db = new DatabaseConnector();
        ObservableList<Transaction> recentTransactions = db.getRecentTransactions();

        //home_transactionAmountColumn
        //_transactionDateColumn
        //_transactionMerchantColumn
        home_transactionDateColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDate().toString()));
        home_transactionMerchantColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getMerchant()));
        home_transactionAmountColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(Double.toString(data.getValue().getAmount())));

        home_recentTransactions.setItems(recentTransactions);
    }

    private void fillTransactionsTable(){

        DatabaseConnector db = new DatabaseConnector();
        ObservableList<Transaction> transactions = db.getRecentTransactions(); //Maybe need different DB method TODO: Verify

        //TransactionDateColumn
        //TransactionAmountColumn
        //TransactionLabelColumn
        //TransactionMerchantColumn
        //TransactionBankAccountColumn
        //TransactionPerpetualColumn

        TransactionDateColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDate().toString()));
        TransactionAmountColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(Double.toString(data.getValue().getAmount())));
        TransactionMerchantColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getMerchant()));
        TransactionLabelColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getLabel()));
        TransactionBankAccountColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getAccount()));
        TransactionPerpetualColumn.setCellValueFactory(data -> {
            if ((data.getValue() instanceof Transaction) && (data.getValue().isRecurring())) return new ReadOnlyStringWrapper("Yes");
            else return new ReadOnlyStringWrapper("No");
            /*
            if(data.getValue() instanceof Transaction && !(data.getValue() instanceof RecurringTransaction)) return new ReadOnlyStringWrapper("No");
            else {
                if(((RecurringTransaction) data.getValue()).isPerpetual()) return new ReadOnlyStringWrapper("Yes");
                else return new ReadOnlyStringWrapper("No");
            } */
        });

        TransactionsTable.setItems(transactions);
    }

    private void fillBudgetTransactionsTable(){
        DatabaseConnector db = new DatabaseConnector();
        //ObservableList<Category> categories = db.get
        //TODO

        //budgetCategoriesTable.setItems(categories);
    }

    private void fillBankAccountTransactionsTable(){
        DatabaseConnector db = new DatabaseConnector();
        BankAccount bankAccount = selectBankAccountChoiceBox.getValue();
        ObservableList<Transaction> transactions = db.getBankAccountTransactions(bankAccount.getName());
        db.close();
        accountTransactionDateColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getDate().toString()));
        accountTransactionAmountColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(Double.toString(data.getValue().getAmount())));
        accountTransactionLabelColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getLabel()));

        accountTransactionsTable.setItems(transactions);
    }

    private void populateSelectBankAccountChoiceBox(){
        DatabaseConnector db = new DatabaseConnector();
        ObservableList<BankAccount> bankAccounts = db.getBankAccounts();
        db.close();
        selectBankAccountChoiceBox.setItems(bankAccounts);
        selectBankAccountChoiceBox.getSelectionModel().selectFirst();
    }

    private void setBankAccountBalanceText(){
        accountBalance.setText("Balance: $" + selectBankAccountChoiceBox.getValue().getBalance());
    }


    private void populateSelectBudgetChoiceBox(){
        DatabaseConnector db = new DatabaseConnector();
        ObservableList<MonthlyBudget> budgets = db.getMonthlyBudgets();
        db.close();

        selectBudgetChoiceBox.setItems(budgets);
        selectBudgetChoiceBox.getSelectionModel().selectFirst();
    }

    private void drawHomeScreenPieCharts(){
        //home_thisMonthSpendingChart
        //home_thisMonthBudgetChart
        MonthlyBudget thisMonth = selectBudgetChoiceBox.getValue();
        ObservableList<Category> thisMonthCategories= thisMonth.getCategories();
        ObservableList<PieChart.Data> SpendingPieChartData = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> BudgetPieChartData = FXCollections.observableArrayList();
        for(int i = 0; i < thisMonthCategories.size(); i++){
            Category c = thisMonthCategories.get(i);
            BudgetPieChartData.add(new PieChart.Data(c.getLabel(), c.getPriceLimit()));
        }

        DatabaseConnector db = new DatabaseConnector();
        ObservableList<Transaction> thisMonthTransactions = db.getThisMonthTransactions();
        db.close();


        //Now tally up the amounts on each of the labels
        HashMap<String, Double> labelAmounts = new HashMap<String, Double>();
        for(int i = 0; i < thisMonthTransactions.size(); i++){
            String label = thisMonthTransactions.get(i).getLabel();
            double transactionAmount = thisMonthTransactions.get(i).getAmount();
            if(labelAmounts.containsKey(label)){
                labelAmounts.put(label, (labelAmounts.get(label)+transactionAmount));
            } else {
                labelAmounts.put(label, transactionAmount);
            }
        }

        //Get those amounts in the data list
        Set<Map.Entry<String, Double>> labelAmountsSet = labelAmounts.entrySet();
        Iterator<Map.Entry<String, Double>> labelAmountItr = labelAmountsSet.iterator();
        while(labelAmountItr.hasNext()){
            Map.Entry<String, Double> transactionData = labelAmountItr.next();
            SpendingPieChartData.add(new PieChart.Data(transactionData.getKey(), transactionData.getValue()));
        }

        home_thisMonthBudgetChart.setData(BudgetPieChartData);
        home_thisMonthSpendingChart.setData(SpendingPieChartData);


    }














    /*****************************************
        USELESS BELOW
     ******************************************/
    @FXML
    void filterDateClicked(ActionEvent event) {
    }
    @FXML
    void filterMerchantClicked(ActionEvent event) {
    }
    @FXML
    void filterAmountClicked(ActionEvent event) {
    }
    @FXML
    void filterAccountClicked(ActionEvent event) {
    }
    @FXML
    void filterLabelClicked(ActionEvent event) {
    }
    @FXML
    void filterPerpetualClicked(ActionEvent event) {
    }
}
