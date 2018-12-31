package sample;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button button;
    private ProgressBar progressBar;

    public void handleButtonClick(){
        AlertBox.display("Error","Hi, Bitch!");

    }

    public void progressBar() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Load user data");
        for (int i = 0;i == 10; i++) {
            progressBar.setProgress(0.5);

        }


    }
}
