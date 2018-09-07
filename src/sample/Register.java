package sample;

import java.awt.ActiveEvent;
import java.awt.Button.*;
import java.beans.EventHandler;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Register {
  public static void display(){
    Stage window = new Stage();
    window.setTitle("Register");



    Label welcome = new Label("Welcome New User!");

    Label createUser = new Label("Create Username:");

    TextField userText = new TextField();

    Label createPass = new Label("Create Password:");

    PasswordField passText = new PasswordField();

    Button create = new Button("Create!");
    create.setOnAction(e -> {

      try{
        FileWriter fw = new FileWriter("Accounts.txt",true);
        PrintWriter pw = new PrintWriter(fw);

        String user = userText.getText();
        String pass = passText.getText();

        pw.println(user.toLowerCase() + " " + pass.toLowerCase());


        pw.close();


      }catch (IOException er){
        System.out.println("ERROR");
      }
      window.close();


    });

    VBox layout = new VBox(10);
    layout.getChildren().addAll(welcome,createUser,userText,createPass,passText,create);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout,400,300);

    window.setScene(scene);
    window.show();

  }

}
