package programmeprincipal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import phases.phase1;

public class Main extends Application {

	
	public void start(Stage stage) throws Exception {
		Label accueil = new Label("Bienvenue sur ce jeu magnifique !");
		Button start = new Button("NOUVELLE PARTIE !");
		
		start.addEventHandler(ActionEvent.ACTION, e -> {
			phase1 p1 = new phase1();
			Stage s = new Stage();
			try {
				p1.start(s);
				stage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
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
