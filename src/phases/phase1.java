package phases;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
import programmeprincipal.Scores;




public class phase1 extends Application {

	
	private static Random rand = new Random();
	public static ArrayList<String> questions_reponses = new ArrayList<>();
	public static String[] categories = {"Jeux Videos","Musique"};
	
	public void startGame(Stage stage) throws Exception {
		phase1.changeQuestion();
		int longueur = questions_reponses.size();
		int alea = rand.nextInt(longueur/5)*5;
		ArrayList<Integer> choix = aleachoix();
		String reponse = questions_reponses.get(alea+1);
		Label titre_phase = new Label("Phase 1: Questions simples");
		Label question = new Label(questions_reponses.get(alea));
		Button A = new Button (questions_reponses.get(alea+choix.get(0)));
		Button B = new Button (questions_reponses.get(alea+choix.get(1)));
		Button C = new Button (questions_reponses.get(alea+choix.get(2)));
		Button D = new Button (questions_reponses.get(alea+choix.get(3)));
		
		Label score1 = new Label (""+Scores.s1);
		Label score2 = new Label (""+Scores.s2);
		
		
		//Classes et Id
		
		
		
		
		
		
		question.getStyleClass().add("question");
		A.getStyleClass().add("button");
		B.getStyleClass().add("button");
		C.getStyleClass().add("button");
		D.getStyleClass().add("button");
		
		
		
		VBox root = new VBox();
		HBox header = new HBox();
		HBox h_titre = new HBox (titre_phase);
		VBox qr = new VBox();
		HBox h_question = new HBox(question);
		HBox h_rep1 = new HBox (A,B);
		HBox h_rep2 = new HBox (C,D);
		
		
		 A.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println(correction(A,reponse));
		 });
		 B.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println(correction(B,reponse));
		 });
		 C.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println(correction(C,reponse));
		 });
		 D.addEventHandler(ActionEvent.ACTION, e -> {
			 System.out.println(correction(D,reponse));
		 });
		
		
		qr.getChildren().addAll(h_question,h_rep1,h_rep2);
		header.getChildren().addAll(score1,h_titre,score2);
		Region blanc = new Region();
		blanc.setPrefHeight(100);
		blanc.setPrefWidth(100);
		h_question.setId("pane");
		h_rep1.setId("pane");
		h_rep2.setId("pane");
		header.setId("pane");
		root.getChildren().addAll(header,blanc,qr);
		
		h_titre.getStyleClass().add("titre");
		h_question.setId("titre_question");
		qr.setId("pane");
		
	
		Scene scn = new Scene(root,600,200);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		
	}
	
		
	public static void changeQuestion() throws IOException {
		int alea = rand.nextInt(categories.length);
		File doc = new File("src/questions/"+categories[alea]+".txt");
		Scanner sc = new Scanner (doc);
		String texte = "init";
		while (!(texte.equals("FIN"))) {
			texte=sc.nextLine();
			questions_reponses.add(texte);
		}
		
		sc.close();
		questions_reponses.remove(questions_reponses.size()-1);

	}
	
	void restart(Stage stage) throws Exception {
	    startGame(stage);
	}
	
	public void start(Stage stage) throws Exception {
	    startGame(stage);
	}
	
	//fonction qui renvoie 4 nombres entre 1 et 4 tous différents
	public static ArrayList<Integer> aleachoix() {
		ArrayList<Integer> nombres = new ArrayList<>();
		nombres.add(1);
		nombres.add(2);
		nombres.add(3);
		nombres.add(4);
		Collections.shuffle(nombres);
		return nombres;
	}
	
	public Boolean correction(Button b,String reponse) {
		Scores.s1+=1;
		return b.getText().equals(reponse);
		
	
	}

	
	
}