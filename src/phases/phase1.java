package phases;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class phase1 extends Application {

	
	private Random rand = new Random();
	public static ArrayList<String> questions_reponses = new ArrayList<>();
	
	public void start(Stage stage) throws Exception {
		phase1.changeQuestion();
		int longueur = questions_reponses.size();
		int alea = rand.nextInt(longueur/5)*5;
		Label titre_phase = new Label("Question simples");
		Label question = new Label(questions_reponses.get(alea));
		Button A = new Button (questions_reponses.get(alea+1));
		Button B = new Button (questions_reponses.get(alea+2));
		Button C = new Button (questions_reponses.get(alea+3));
		Button D = new Button (questions_reponses.get(alea+4));
		
		//Classes et Id
		
		
		
		
		
		
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
		
		
		 A.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println("Bravo");
		 });
		 B.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println("Faux");
		 });
		 C.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println("Faux");
		 });
		 D.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println("Faux");
		 });
		
		
		qr.getChildren().addAll(h_question,h_rep1,h_rep2);
		Region blanc = new Region();
		blanc.setPrefHeight(100);
		blanc.setPrefWidth(100);
		h_question.setId("pane");
		root.getChildren().addAll(h_titre,blanc,qr);
		
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
	
		
	public static void changeQuestion() throws IOException {
		File doc = new File("src/questions/JeuxVideos.txt");
		Scanner sc = new Scanner (doc);
		String texte = "init";
		while (!(texte.equals("FIN"))) {
			texte=sc.nextLine();
			questions_reponses.add(texte);
		}
		
		sc.close();
		questions_reponses.remove(questions_reponses.size()-1);

	}
	
	
}