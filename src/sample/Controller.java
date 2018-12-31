package sample;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button button;

    public void handleButtonClick(){
        AlertBox.display("Error","Hi, Bitch!");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Loading Data...");
    }
}
