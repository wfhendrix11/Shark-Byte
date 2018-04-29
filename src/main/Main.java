package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.*;
import javafx.scene.text.Text;

public class Main extends Application {

    public static int userID = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Login Screen
        Stage loginStage = new Stage();
        loginStage.setTitle("JavaFX Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 300, 275);
        loginStage.setScene(scene);

        javafx.scene.text.Text scenetitle = new javafx.scene.text.Text("Welcome");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Button btn1 = new Button("Create Account");
        HBox hbBtn1 = new HBox(10);
        hbBtn.setAlignment(Pos.TOP_LEFT);
        hbBtn.getChildren().add(btn1);
        grid.add(hbBtn1, 2, 4);

        // Action for Sign In button
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                // open home screen
                DatabaseConnector db = new DatabaseConnector();
                
                primaryStage.show();
            }
        });

        // Action for Sign In button
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                // open home screen
                System.out.print("CREATE NEW ACCOUNT");
            }
        });

        // show login screen
        loginStage.show();

        // main screen
        Parent root = FXMLLoader.load(getClass().getResource("shark_byte_gui.fxml"));
        primaryStage.setTitle("Shark Byte Financial Suite");
        primaryStage.setScene(new Scene(root, 1000, 650));
    }


    public static void main(String[] args) {
        launch(args);
    }
}