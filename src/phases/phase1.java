package phases;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
	public static int numero_question = 1;
	int longueur;
	int alea;
	String reponse;
	Label titre_phase = new Label("Phase 1: Questions simples");
	Label question = new Label();
	Button A = new Button();
	Button B = new Button();
	Button C = new Button();
	Button D = new Button();
	Label score1 = new Label (Scores.j1+ ": "+Scores.s1);
	Label score2 = new Label ( Scores.j2+": "+Scores.s2);
	
	public void startGame(Stage stage) throws Exception {
		for (int cat = 0;cat<Scores.categories.length;cat++) {
			chargeQuestion(Scores.categories[cat]);			
		}
		settere();
		
		
		
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
			 correction(A,reponse,stage);
		 });
		 B.addEventHandler(ActionEvent.ACTION, e -> {
			 correction(B,reponse,stage);
		 });
		 C.addEventHandler(ActionEvent.ACTION, e -> {
			 correction(C,reponse,stage);
		 });
		 D.addEventHandler(ActionEvent.ACTION, e -> {
			 correction(D,reponse,stage);
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
		score1.setId("score1");
		score2.setId("score2");
		root.setId("bg");
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
	
		
	public static void chargeQuestion(String categorie) throws IOException {
		File doc = new File("src/questions/"+categorie+".txt");
		Scanner sc = new Scanner (doc);
		String texte = "init";
		while (!(texte.equals("FIN"))) {
			texte=sc.nextLine();
			questions_reponses.add(texte);
		}
		
		sc.close();
		questions_reponses.remove(questions_reponses.size()-1);

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
	
	public void correction(Button b,String reponse,Stage stage) {
		
		if (numero_question == 5 && Scores.tour == 2) {
			phase2 p2 = new phase2();
			Stage s = new Stage();
			try {
				p2.start(s);
				stage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
		if (b.getText().equals(reponse)) {
			if (Scores.tour == 1) {
				Scores.s1+=1;
			}
			else {
				Scores.s2+=1;
			}
		}
		if (Scores.tour == 1) {
			Scores.tour = 2;
		}
		else {
			Scores.tour = 1;
			numero_question +=1;
		}
		
		settere();
		}
	
	}
	
	public void settere() {
		longueur = questions_reponses.size();
		alea = rand.nextInt(longueur/5)*5;
		ArrayList<Integer> choix = aleachoix();
		reponse = questions_reponses.get(alea+1);
		question.setText(numero_question+") "+questions_reponses.get(alea));
		A.setText(questions_reponses.get(alea+choix.get(0)));
		B.setText(questions_reponses.get(alea+choix.get(1)));
		C.setText(questions_reponses.get(alea+choix.get(2)));
		D.setText(questions_reponses.get(alea+choix.get(3)));
		questions_reponses.remove(alea);
		questions_reponses.remove(alea);
		questions_reponses.remove(alea);
		questions_reponses.remove(alea);
		questions_reponses.remove(alea);
		score1.setText(Scores.j1+": "+Scores.s1);
		score2.setText(Scores.j2+": "+Scores.s2);
		
	}
	
	
}