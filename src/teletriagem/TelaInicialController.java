package teletriagem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author leticiamtt
 */
public class TelaInicialController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("ImagemVetorial"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 400, 240);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void criaPaciente() {
        File file;
        BufferedWriter writter;

        try {
            String caminhoPaciente = "Pacientes\\pacientes.txt";
            file = new File(caminhoPaciente);
            FileWriter fileWriter = new FileWriter(file, true);
            writter = new BufferedWriter(fileWriter);

            //BufferedWriter append = writter.append(this.TextField.getText() );         
            writter.close();

            System.out.println("Paciente cadastrado com sucesso");
        } catch (IOException erro) {
            System.out.println("Não foi possível escrever o arquivo no disco...");
        }

    }

    @FXML
    void handleButtonAction2(ActionEvent event) {
        criaPaciente();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
