package teletriagem;

import java.awt.TextField;
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

    String caminhoPacientes = "C:\\Users\\leticiamtt\\Documentos\\GiHub\\Teletriagem\\Pacientees\\pessoas.txt";

    @FXML
    private Label label;

    @FXML
    private TextField texto1;

    @FXML
    private TextField texto2;

    @FXML
    private TextField texto3;

    @FXML
    private TextField texto4;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("ImagemController.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 450);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
        }

    }

    public void criaPaciente() {
        File file;
        BufferedWriter writter;

        try {
            file = new File(caminhoPacientes);
            FileWriter fileWriter = new FileWriter(file, true);
            writter = new BufferedWriter(fileWriter);

            writter.append(this.texto1.getText() + ";" + this.texto2.getText() + ";" + this.texto3.getText() + ";" + this.texto4.getText() + ";");
            writter.close();

            System.out.println("Paciente cadastrado com sucesso");
        } catch (IOException erro) {
            System.out.println("Não foi possível escrever o arquivo no disco...");
        }

    }

    @FXML
    void criaPaciente(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
