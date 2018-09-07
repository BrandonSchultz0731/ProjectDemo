package sample;

import com.sun.jdi.InvocationException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller extends Main{
  @FXML
  private Button logoutBtn;

  public void logoutClicked() throws RuntimeException {

    GridPane test = new GridPane();
    Scene testScene = new Scene(test,500,500);

    window.setScene(testScene);
    window.show();
  }


}
