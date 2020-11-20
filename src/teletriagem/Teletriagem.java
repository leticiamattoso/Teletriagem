/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teletriagem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author leticiamtt
 */
public class Teletriagem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
     public  void criaPessoa()
	{
		File file;
		BufferedWriter writter;

	    try
	    {
                String caminhoPaciente = "Pacientes\\pacientes.txt";
	        file = new File(caminhoPaciente);
                FileWriter fileWriter = new FileWriter(file, true);
	        writter = new BufferedWriter(fileWriter);
	      
                    //BufferedWriter append = writter.append(this.TextField.getText() );         
                writter.close();

	        System.out.println("Paciente cadastrado com sucesso");
	    }

	    catch(IOException erro)
	    {
	    	System.out.println("Não foi possível escrever o arquivo no disco...");
	    }
	
        }
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
