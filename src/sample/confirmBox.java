package sample;

import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;

import java.io.IOException;

public class confirmBox {

    static boolean answer;
    public static Stage window;
    public static boolean display(String title) throws IOException {

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Parent root = FXMLLoader.load(confirmBox.class.getResource("Scenes/confirmExit.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Main.css");

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public void returnYes(){
        answer = true;
        this.window.close();
    }
    public void returnNo(){
        answer = false;
        this.window.close();

    }
}