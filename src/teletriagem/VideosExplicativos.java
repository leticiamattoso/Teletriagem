package teletriagem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class VideosExplicativos extends Application {

@Override
public void start(Stage plano) {

Pane painel;
Scene cena;
WebView webVideo;
Button botao;
String lista[];
int indice;

lista = new String[3];
lista[0] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=ea1VIZdkeTk\"" //status vermelho
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";
lista[1] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=m2EbeMLINqo\"" //status vermelho
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";
lista[2] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=nDgXhusllVE\"" //status amarelo
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";

lista[3] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=tPd_b5jIR5c\"" //status amarelo
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";

lista[4] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=ERi4GGlwSIo\"" //status verde
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";

lista[5] = "<iframe width=\"560\""
+ "height=\"315\""
+ "src=\"https://www.youtube.com/watch?v=TCp_FA0CA4o\"" //status verde
+ "frameborder=\"0\" allow=\"accelerometer;"
+ "autoplay; encrypted-media; gyroscope;"
+ "picture-in-picture\" allowfullscreen></iframe>"
+ "";

botao = new Button("Mudar Canal");
webVideo = new WebView();

painel = new Pane();
painel.getChildren().add(botao);
botao.setTranslateX(0);
botao.setTranslateY(0);

cena = new Scene(painel, 640, 480);
plano.setTitle("Streaming da Plataforma YouTube");
plano.setScene(cena);
plano.show();

indice = 0;
botao.setOnAction((ActionEvent event) -> { 
webVideo.getEngine().loadContent(lista[indice], "text/html");
webVideo.setTranslateX(50);
webVideo.setTranslateY(50);
painel.getChildren().add(webVideo);

});

}
}

