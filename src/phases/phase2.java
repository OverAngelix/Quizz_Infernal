package phases;

import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class phase2 extends Application {

	
	public void start(Stage stage) throws Exception {
	
		Label question = new Label("Combien vaut un Iphone 100 ?");
		
		Button rep1 = new Button("150€");
		Button rep2 = new Button("1784€");
		Button rep3 = new Button("Un Smic ?");
		Button rep4 = new Button("Au pire tu vends Dark :) ");
		rep1.setId("button2");
		rep2.setId("button2");
		rep3.setId("button2");
		rep4.setId("button2");
		
		
		Button start = new Button("NOUVELLE PARTIE !");
		
		Image roue = new Image("/images/roue.png");  
		ImageView imageRoue = new ImageView(roue); 
		Image fleche = new Image("/images/fleche.png");  
		ImageView imageFleche = new ImageView(fleche); 
		
		imageRoue.setFitHeight(350); 
		imageRoue.setFitWidth(350);
		
		imageFleche.setFitHeight(75); 
		imageFleche.setFitWidth(75);
		
		 start.addEventHandler(ActionEvent.ACTION, e -> {
			 RotateTransition t2 = new RotateTransition(Duration.seconds(2), imageRoue);
			 t2.setByAngle(920);
			 t2.play();	
		 });
		
		VBox roulette = new VBox(imageRoue,imageFleche) ;
		HBox q1q2 = new HBox(rep1,rep2);
		HBox q3q4 = new HBox(rep3,rep4);
		 roulette.setId("pane");
		 q1q2.setId("pane");
		 q3q4.setId("pane");
		VBox root = new VBox(roulette,question,q1q2,q3q4,start);
		root.setId("pane");
		Scene scn = new Scene(root,500,600);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}