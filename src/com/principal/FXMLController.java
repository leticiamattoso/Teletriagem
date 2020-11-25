package com.principal;

import com.triagem.TelaInicial;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author leticiamtt
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField loginUsuario;

    @FXML
    private PasswordField pwdLogin;

    @FXML
    private TextField cadastroUsuario;

    @FXML
    private PasswordField cadastroPwd;

    @FXML
    private Button botaoFechar;

    @FXML
    private void handleCadastrar(ActionEvent event) {
        String usuario = "";
        String pwd = "";

        usuario = cadastroUsuario.getText();
        pwd = cadastroPwd.getText();

        if (!usuario.isEmpty() && !pwd.isEmpty()) {
            try {
                FileWriter arquivo = new FileWriter("C:\\Temp\\usuario.txt");
                PrintWriter escrever = new PrintWriter(arquivo);

                escrever.write(usuario + "|" + pwd + ";");
                escrever.close();

                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Informação");
                dialogoInfo.setHeaderText("Cadastrado com sucesso!");
                dialogoInfo.showAndWait();

            } catch (IOException ex) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setHeaderText("Não foi possível cadastrar!");
                dialogoErro.showAndWait();
            }
        }
    }

    @FXML
    private void handleEntrar(ActionEvent event) {
        String usuario = "";
        String pwd = "";

        usuario = loginUsuario.getText();
        pwd = pwdLogin.getText();

        if (!usuario.isEmpty() && !pwd.isEmpty()) {
            String usuarioArquivo = "";
            String pwdArquivo = "";

            try {
                BufferedReader bf = new BufferedReader(new FileReader("C:\\Temp\\usuario.txt"));

                while (bf.ready()) {
                    String linha = bf.readLine();
                    boolean usuarioCompleto = false;
                    boolean pwdCompleta = false;

                    usuarioArquivo = "";
                    pwdArquivo = "";

                    //Lendo caracter por caracter
                    for (int i = 0; i < linha.length(); i++) {
                        char letra = linha.charAt(i);

                        if (letra != '|' && !usuarioCompleto) {
                            usuarioArquivo = usuarioArquivo + letra;
                        } else if (letra == '|') {
                            usuarioCompleto = true;
                        }

                        if (letra != '|' && letra != ';' && !pwdCompleta && usuarioCompleto) {
                            pwdArquivo = pwdArquivo + letra;
                        } else if (letra == ';') {
                            pwdCompleta = true;
                        }
                    }
                }

                bf.close();
            } catch (IOException ex) {
                System.out.println("Conteudo não poderá ser gravado!");
            }

            //Veridica se usuário e senha são válidos
            if (usuario.equals(usuarioArquivo) && pwd.equals(pwdArquivo)) {
                System.out.println("Usuário logado!");

                //Fecha cena atual
                Stage stage = (Stage) botaoFechar.getScene().getWindow();
                stage.close();

                TelaInicial tela = new TelaInicial();
                try {
                    tela.start(stage);

                } catch (Exception ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Usuário ou senha incorretos!");
            }
        }
    }

    @FXML
    private void handleLimpar(ActionEvent event) {
        cadastroUsuario.setText("");
        cadastroPwd.setText("");
    }

    @FXML
    private void handleFechar(ActionEvent event) {
        Stage stage = (Stage) botaoFechar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
