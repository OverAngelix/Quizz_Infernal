package programmeprincipal;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	
	public void start(Stage stage) throws Exception {
		Label accueil = new Label("Bienvenue sur ce jeu magnifique !");
		Button start = new Button("NOUVELLE PARTIE !");
		
		VBox root = new VBox(accueil,start);
		root.setId("pane");
		Scene scn = new Scene(root,400,400);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
