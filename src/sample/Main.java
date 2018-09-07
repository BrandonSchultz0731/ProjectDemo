package sample;

import apple.laf.JRSUIUtils.TabbedPane;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AlertBox alertBox = new AlertBox();
        window = primaryStage;
        window.setTitle("Brandon Schultz");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(8);

        Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene accountScreen = new Scene(root,500,500);


        grid.setStyle("-fx-background-color: #8fbc8f;");

        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel,0,0);

        //Name input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput,1,0);

        //Password Label
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel,0,1);

        //Password input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Enter Password");
        GridPane.setConstraints(passInput,1,1);

        //Login Button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton,1,2);
        loginButton.setOnAction(e -> {
            //Read Textfile
            try{
                String user = nameInput.getText();
                String pass = passInput.getText();

                FileReader fr = new FileReader("Accounts.txt");
                BufferedReader br = new BufferedReader(fr);

                String str;
                boolean found = false;
                while ((str = br.readLine()) != null && !found){
                    if((user.toLowerCase() + " " + pass).equals(str)){
                        System.out.println("Log In Success!");
                        found = true;
                        window.setScene(accountScreen);


                    }
                }
                if(!found){
                    alertBox.display("No Account","Could Not Find Account. Please"
                        + " Try Again or Create Account");
                }
                br.close();

            }catch (IOException er){
                System.out.println("ERROR: File Not Found");
            }

        });

        //Create Button
        Button createButton = new Button("Create Account");
        GridPane.setConstraints(createButton,2,2);
        createButton.setOnAction(e -> Register.display());



        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,createButton);

        scene = new Scene(grid,400,400);

        grid.setGridLinesVisible(true);





        //button = new Button("Close Program");
        //Retrieving info from other windows
//        button.setOnAction(e -> {
//            //alertBox.display("New Window","New Message");
//            boolean result = ConfirmBox.display("Window","Are You Sure You Want To Do This?");
//            if(result){
//                System.out.println("SENT");
//            }
//            else{
//                System.out.println("STOPPED");
//            }
//        });
        //Closing Program properly
//        button.setOnAction(e -> closeProgram());
//        window.setOnCloseRequest(e -> {
//            e.consume();
//            closeProgram();
//        });

//        HBox topMenu = new HBox();
//        Button buttonA = new Button("File");
//        Button buttonB = new Button("Edit");
//        Button buttonC = new Button("View");
//        topMenu.getChildren().addAll(buttonA,buttonB,buttonC);
//
//        VBox leftMenu = new VBox();
//        Button buttonD = new Button("D");
//        Button buttonE = new Button("E");
//        Button buttonF = new Button("F");
//        leftMenu.getChildren().addAll(buttonD,buttonE,buttonF);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setTop(topMenu);
//        borderPane.setLeft(leftMenu);



        //StackPane layout = new StackPane();
        //layout.getChildren().add(button);
        window.setScene(scene);
        window.show();


    }
    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title","Are You sure?");
        if(answer){
            window.close();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}
