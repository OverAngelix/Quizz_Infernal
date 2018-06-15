package phases;

import java.util.ArrayList;
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

	private ArrayList<String> questions = new ArrayList<>();
	Button rep4;
	Button rep3;
	Button rep2;
	Button rep1;
	Label question;
	
	public void tyuiop () {
		questions.add("Combien vaut un Iphone 100 ?");
		questions.add("150€");
		questions.add("1520€");
		questions.add("15550€");
		questions.add("151550€");
		questions.add("Qui est le plus fort a FORTNITE");
		questions.add("Steven");
		questions.add("Florent");
		questions.add("Ekyn");
		questions.add("Florian");
				
	}
	public void settere() {
		question.setText(questions.get(5));
		rep1.setText(questions.get(6));
		rep2.setText(questions.get(7));
		rep3.setText(questions.get(8));
		rep4.setText(questions.get(9));
	}
	
	public void start(Stage stage) throws Exception {
		
		tyuiop();
		
		question = new Label(questions.get(0));
		
		rep1 = new Button(questions.get(1));
		rep2 = new Button(questions.get(2));
		 rep3= new Button(questions.get(3));
		 rep4= new Button(questions.get(4));
		
		rep1.setOnMouseClicked(e->{
			System.out.println(rep1.getText().equals(questions.get(1)));
			settere();
		});
		rep2.setOnMouseClicked(e->{
			System.out.println(rep2.getText().equals(questions.get(1)));
			settere();
		});
		rep3.setOnMouseClicked(e->{
			System.out.println(rep3.getText().equals(questions.get(1)));
			settere();
		});
		rep4.setOnMouseClicked(e->{
			System.out.println(rep4.getText().equals(questions.get(1)));
			settere();
		});
		
		
		
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