package main;
/**
 * Sample Skeleton for 'shark_byte_gui.fxml' Controller Class
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;

public class FXController {

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
    private TableColumn<?, ?> portfolioAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="TransactionPerpetualColumn"
    private TableColumn<?, ?> TransactionPerpetualColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetSpendingColumn"
    private TableColumn<?, ?> budgetSpendingColumn; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioValueColumn"
    private TableColumn<?, ?> portfolioValueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="filterAmountChoiceBox"
    private ChoiceBox<?> filterAmountChoiceBox; // Value injected by FXMLLoader

    @FXML // fx:id="newInvestmentQtyField"
    private TextField newInvestmentQtyField; // Value injected by FXMLLoader

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
    private TableColumn<?, ?> portfolioAssetColumn; // Value injected by FXMLLoader

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
    private TableView<?> portfolioTable; // Value injected by FXMLLoader

    @FXML // fx:id="home_transactionAmountColumn"
    private TableColumn<?, ?> home_transactionAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="budgetCategoriesTable"
    private TableView<?> budgetCategoriesTable; // Value injected by FXMLLoader

    @FXML // fx:id="accountValueChart"
    private LineChart<?, ?> accountValueChart; // Value injected by FXMLLoader

    @FXML // fx:id="filterPerpetualChoiceBox"
    private ChoiceBox<?> filterPerpetualChoiceBox; // Value injected by FXMLLoader

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
    private TableColumn<?, ?> portfolioPriceColumn; // Value injected by FXMLLoader

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
    void homeTabChanged(Event event) {

    }

    @FXML
    void manageAccount(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        final Stage dialog = new Stage();

        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(theStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("Manage Account"));
        Scene dialogScene = new Scene(dialogVbox, 900, 600);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    @FXML
    void transactionTabChanged(Event event) {
        updateTransactionLabels();
    }

    @FXML
    void enterTransaction(ActionEvent event) {
        // transactionLabelChoiceBox
        // transactionBankAccountChoiceBox
        // transactionMerchantField
        // transactionAmountField
        // transactionDatePicker
    }

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

    }

    @FXML
    void budgetsTabChanged(Event event) {

    }

    @FXML
    void addNewBudget(ActionEvent event) {

    }

    @FXML
    void investmentsTabChanged(Event event) {

    }


    @FXML
    void searchAsset(ActionEvent event) {

    }

    @FXML
    void investmentTypeClicked(ActionEvent event) {

    }

    @FXML
    void recordInvestment(ActionEvent event) {

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

}
