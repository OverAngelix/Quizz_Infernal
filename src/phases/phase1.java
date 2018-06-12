package phases;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class phase1 extends Application {

	public static ArrayList<String> questions_reponses = new ArrayList<>();
	
	public void start(Stage stage) throws Exception {
		Label titre_phase = new Label("Question simples");
		Label question = new Label("Francky, mais qui est lui ?");
		Button A = new Button ("Franck Dubosc");
		Button B = new Button ("Franck Ribéry");
		Button C = new Button ("Anjetar");
		Button D = new Button ("Jonathan");
		
		//Classes et Id
		
		System.out.println(phase1.changeQuestion());
		question.getStyleClass().add("question");
		A.getStyleClass().add("button");
		B.getStyleClass().add("button");
		C.getStyleClass().add("button");
		D.getStyleClass().add("button");
		
		
		
		VBox root = new VBox();
		HBox h_titre = new HBox (titre_phase);
		VBox qr = new VBox();
		HBox h_question = new HBox(question);
		HBox h_rep1 = new HBox (A,B);
		HBox h_rep2 = new HBox (C,D);
		
		
		root.getChildren().addAll(h_titre,qr);
		qr.getChildren().addAll(h_question,h_rep1,h_rep2);
		
		h_titre.getStyleClass().add("titre");
		qr.setId("pane");
		
	
		Scene scn = new Scene(root,400,400);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		
	}
	
		
	public static ArrayList<String> changeQuestion() throws IOException {
		File doc = new File("src/questions/JeuxVideos.txt");
		Scanner sc = new Scanner (doc);
		String texte = "init";
		while (!(texte.equals("FIN"))) {
			texte=sc.nextLine();
			questions_reponses.add(texte);
		}
		
		sc.close();
		questions_reponses.remove(questions_reponses.size()-1);
		return questions_reponses;

	}
	
}