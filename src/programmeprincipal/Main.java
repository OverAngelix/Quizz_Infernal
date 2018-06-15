package programmeprincipal;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import phases.phase1;

public class Main extends Application {

	
	public void start(Stage stage) throws Exception {
		
		Label accueil = new Label("LE QUIZZ INFERNAL");
		accueil.setFont((Font.font(null, FontWeight.BOLD, 36)));
		
		Button start = new Button("NOUVELLE PARTIE !");
		Button quit = new Button("QUITTER");
		
		start.addEventHandler(ActionEvent.ACTION, e -> {
			phase1 p1 = new phase1();
			Stage s = new Stage();
			try {
				 Scores.j1 = JOptionPane.showInputDialog("Nom du joueur 1");
				 Scores.j2 = JOptionPane.showInputDialog("Nom du joueur 2");
				p1.start(s);
				stage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		quit.setOnMouseClicked(e->{
			System.exit(1);
		});
		
		VBox root = new VBox(accueil,start,quit);
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
