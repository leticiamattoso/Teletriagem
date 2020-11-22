package teletriagem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImagemVetorial extends Application {
    @FXML private Button btn;
@FXML private Label label;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane p = new Pane();
        Parent root = FXMLLoader.load(getClass().getResource("ImagemController.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}