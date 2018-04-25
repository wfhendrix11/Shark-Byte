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
import java.util.ArrayList;

public class FXController {

    @FXML // fx:id="quitButton"
    private Button quitButton; //Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionsTable"
    private TableView<?> accountTransactionsTable; // Value injected by FXMLLoader

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
    private TableView<?> home_recentTransactions; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentSymbolField"
    private TextField newInvestmentSymbolField; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentTypeChoiceBox"
    private ChoiceBox<?> newInvestmentTypeChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="investmentsTab"
    private Tab investmentsTab; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionAmountColumn"
    private TableColumn<?, ?> accountTransactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="homeTab"
    private Tab homeTab; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionAmountColumn"
    private TableColumn<?, ?> TransactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transactionLabelChoiceBox"
    private ChoiceBox<?> transactionLabelChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="thisMonthSpendingChart"
    private PieChart thisMonthSpendingChart; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioAmountColumn"
    private TableColumn<Investment, String> portfolioAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionPerpetualColumn"
    private TableColumn<?, ?> TransactionPerpetualColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetSpendingColumn"
    private TableColumn<?, ?> budgetSpendingColumn; // Value injected by FXMLLoader

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
    private TableColumn<?, ?> TransactionLabelColumn; // Value injected by FXMLLoader

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
    private TableColumn<?, ?> home_transactionMerchantColumn; // Value injected by FXMLLoader

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
    private TableColumn<?, ?> home_transactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetCategoriesTable"
    private TableView<?> budgetCategoriesTable; // Value injected by FXMLLoader

    @FXML // fx:id="accountValueChart"
    private LineChart<?, ?> accountValueChart; // Value injected by FXMLLoader


    @FXML // fx:id="enterTransactionButton"
    private Button enterTransactionButton; // Value injected by FXMLLoader

    @FXML // fx:id="favoritesSymbolColumn"
    private TableColumn<?, ?> favoritesSymbolColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetAmountColumn"
    private TableColumn<?, ?> budgetAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="recordInvestmentButton"
    private Button recordInvestmentButton; // Value injected by FXMLLoader

    @FXML // fx:id="home_investmentValueChart"
    private LineChart<?, ?> home_investmentValueChart; // Value injected by FXMLLoader

    @FXML // fx:id="home_transactionDateColumn"
    private TableColumn<?, ?> home_transactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionBankAccountColumn"
    private TableColumn<?, ?> TransactionBankAccountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionDateColumn"
    private TableColumn<?, ?> accountTransactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetCategoryColumn"
    private TableColumn<?, ?> budgetCategoryColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionsTable"
    private TableView<?> TransactionsTable; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioPriceColumn"
    private TableColumn<Investment, String> portfolioPriceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="home_thisMonthBudgetChart"
    private PieChart home_thisMonthBudgetChart; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionMerchantColumn"
    private TableColumn<?, ?> TransactionMerchantColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionDateColumn"
    private TableColumn<?, ?> TransactionDateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transactionTab"
    private Tab transactionTab; // Value injected by FXMLLoader

    @FXML // fx:id="bankAccountTab"
    private Tab bankAccountTab; // Value injected by FXMLLoader

    @FXML // fx:id="assetTypeChoiceBox"
    private ComboBox<?> assetTypeChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="accountTransactionLabelColumn"
    private TableColumn<?, ?> accountTransactionLabelColumn; // Value injected by FXMLLoader

    @FXML // fx:id="accountBalance"
    private Text accountBalance; // Value injected by FXMLLoader


    @FXML
    void quitProgram(ActionEvent event){
        
    }

    @FXML
    void homeTabChanged(Event event) {

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
                db.replacePassword(text);
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

        // recurring transaction
        if (recurringRadio.isSelected()) {
            // TODO Lawrence working on this
            Node source = (Node) event.getSource();
            Window theStage = source.getScene().getWindow();

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(theStage);
            dialog.setTitle("Add Recurring Transaction");
            VBox dialogVbox = new VBox(20);

            Text intervalPrompt = new Text("Interval in days: ");

            TextField intervalField = new TextField();
            intervalField.setPromptText("Interval");

            Text executionsPromprt = new Text("Number of executions: ");

            TextField executionsField = new TextField();
            intervalField.setPromptText("Executions");

            RadioButton perpetualRadio = new RadioButton();
            perpetualRadio.setText("Perpetual");

            Button submitButton = new Button();
            submitButton.setText("Submit");

            EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    boolean perpetual = perpetualRadio.isSelected();
                    int interval = Integer.parseInt(intervalField.getText());
                    int executions = Integer.parseInt(executionsField.getText());

                    RecurringTransaction recurringTransaction =
                            new RecurringTransaction(date, amount, label, id, merchant, account, interval, executions, perpetual);
                    db.insertRecurringTransaction(recurringTransaction);
                    dialog.close();
                }
            };

            submitButton.setOnAction(handler);

            dialogVbox.getChildren().add(intervalPrompt);
            dialogVbox.getChildren().add(intervalField);
            dialogVbox.getChildren().add(executionsPromprt);
            dialogVbox.getChildren().add(executionsField);
            dialogVbox.getChildren().add(perpetualRadio);
            dialogVbox.getChildren().add(submitButton);
            Scene dialogScene = new Scene(dialogVbox, 300, 300);
            dialog.setScene(dialogScene);
            dialog.show();
        }
        // transaction
        else {
            Transaction transaction = new Transaction(date, amount, label, id, merchant, account);
            db.insertTransaction(transaction);
        }
    }

    @FXML
    void newBudgetCategory(ActionEvent event) {

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

        Text field1 = new Text("Choose budget type: ");

        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "Monthly Budget", "Yearly Budget")
        );

        Text field2 = new Text("Enter the name: ");
        TextField field3 = new TextField();
        field3.setPromptText("Name");

        Text field4 = new Text("Enter the budget amount: ");
        TextField field5 = new TextField();
        field5.setPromptText("Budget Amount");

        Text field6 = new Text("Enter the budget category: ");
        TextField field7 = new TextField();
        field7.setPromptText("Budget Category");

        Text field8 = new Text("Enter the month: ");
        TextField field9 = new TextField();
        field9.setPromptText("Budget Month");

        Text field10 = new Text("Enter the year: ");
        TextField field11 = new TextField();
        field11.setPromptText("Budget Year");

        Button submitButton = new Button();
        submitButton.setText("Submit");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseConnector db = new DatabaseConnector();

                String name = field3.getCharacters().toString();
                String budgetAmount = field5.getCharacters().toString();
                String budgetCategory = field7.getCharacters().toString();

                // ADD TO DATABASE
                MonthlyBudget newMonthlyBudget = new MonthlyBudget();
                //db.replacePassword(text);
                dialog.close();
            }
        };

        submitButton.setOnAction(handler);

        dialogVbox.getChildren().add(field1);
        dialogVbox.getChildren().add(cb);
        dialogVbox.getChildren().add(field2);
        dialogVbox.getChildren().add(field3);
        dialogVbox.getChildren().add(field4);
        dialogVbox.getChildren().add(field5);
        dialogVbox.getChildren().add(field6);
        dialogVbox.getChildren().add(field7);
        dialogVbox.getChildren().add(field8);
        dialogVbox.getChildren().add(field9);
        dialogVbox.getChildren().add(field10);
        dialogVbox.getChildren().add(field11);
        dialogVbox.getChildren().add(submitButton);
        Scene dialogScene = new Scene(dialogVbox, 500, 600);
        dialog.setScene(dialogScene);
        dialog.show();

    }

    @FXML
    void investmentsTabChanged(Event event) {

        populateAssetTypeChoiceBox();
        populateNewInvestmentTypeChoiceBox();
        fillPortfolio();
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
                //TODO: send stock to database
                break;
            case "Crypto":
                String cryptoName = newInvestmentSymbolField.getText();
                double numberOwned = Double.parseDouble(newInvestmentQtyField.getText());
                Crypto cryptoToRecord = new Crypto(cryptoName, numberOwned);
                //System.out.print(cryptoToRecord);
                //TODO: send crypto to database
                break;
            case "Custom":
                String assetName = newInvestmentSymbolField.getText();
                double price = Double.parseDouble(newInvestmentPriceField.getText());
                double interestRate = Double.parseDouble(newInvestmentInterestRateField.getText());
                int quantity = Integer.parseInt(newInvestmentQtyField.getText());
                CustomAsset assetToRecord = new CustomAsset(assetName, quantity, interestRate, price);
                //System.out.print(assetToRecord);
                //TODO: send asset to database
                break;
        }
    }

    void updateTransactionLabels() {
        DatabaseConnector db = new DatabaseConnector();
        ArrayList<String> labels = db.selectLabels();

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


















    /*
        USELESS BELOW
     */
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
