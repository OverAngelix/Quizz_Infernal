package phases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	int longueur;
	int alea;
	HBox q1q2 = new HBox();
	HBox q3q4 = new HBox();
	private Random rand = new Random();
	Button rep4= new Button();
	Button rep3= new Button();
	Button rep2= new Button();
	Button rep1= new Button();
	Label question= new Label();
	
	public void lecture_question() throws FileNotFoundException {
		File doc = new File("src/questions/Musique.txt");
		Scanner sc = new Scanner (doc);
		String texte = "";
		while (!(texte.equals("FIN"))) {
			texte=sc.nextLine();
			questions.add(texte);
		}
		
		sc.close();
				
	}

	public void modfif_questions() {
		longueur = questions.size();
		alea = rand.nextInt(longueur/5)*5;
		question.setText(questions.get(alea));
		rep1.setText(questions.get(alea+1));
		rep2.setText(questions.get(alea+2));
		rep3.setText(questions.get(alea+3));
		rep4.setText(questions.get(alea+4));
		questions.remove(alea);
		questions.remove(alea);
		questions.remove(alea);
		questions.remove(alea);
		questions.remove(alea);
	}
	
	public void placement_button() {
		q1q2.getChildren().clear();
		q3q4.getChildren().clear();
		int aleao= rand.nextInt(4);
		if (aleao==0) {
			q1q2.getChildren().addAll(rep1,rep2);
			q3q4.getChildren().addAll(rep3,rep4);
		}
		if (aleao==1) {
			q1q2.getChildren().addAll(rep4,rep2);
			q3q4.getChildren().addAll(rep3,rep1);
		}
		if (aleao==2) {
			q1q2.getChildren().addAll(rep3,rep2);
			q3q4.getChildren().addAll(rep1,rep4);
		}
		if (aleao==3) {
			q1q2.getChildren().addAll(rep2,rep1);
			q3q4.getChildren().addAll(rep3,rep4);
		}
	}
	
	public void start(Stage stage) throws Exception {
		
		
		lecture_question();
		
		modfif_questions();
		
		rep1.setOnMouseClicked(e->{
			//System.out.println(rep1.getText().equals(questions.get(1)));
		});
		rep2.setOnMouseClicked(e->{
			//System.out.println(rep2.getText().equals(questions.get(1)));
		});
		rep3.setOnMouseClicked(e->{
			//System.out.println(rep3.getText().equals(questions.get(1)));
		});
		rep4.setOnMouseClicked(e->{
			//System.out.println(rep4.getText().equals(questions.get(1)));
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
			 t2.setOnFinished(a->{
				 modfif_questions();
				 placement_button();
			 });
		 });
		
		VBox roulette = new VBox(imageRoue,imageFleche) ;
		q1q2.getChildren().addAll(rep1,rep2);
		q3q4.getChildren().addAll(rep3,rep4);
		 roulette.setId("pane");
		 q1q2.setId("pane");
		 q3q4.setId("pane");
		VBox root = new VBox(roulette,question,q1q2,q3q4,start);
		root.setId("bg");
		Scene scn = new Scene(root,500,600);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}