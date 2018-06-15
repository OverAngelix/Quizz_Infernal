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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import programmeprincipal.Scores;




public class phase3 extends Application {

	
	private static Random rand = new Random();
	public static ArrayList<String> questions_reponses = new ArrayList<>();
	public static String[] categories = {"Jeux Videos","Musique"};
	public static int numero_question = 1;
	
	public void startGame(Stage stage) throws Exception {
		phase3.changeQuestion();
		int longueur = questions_reponses.size();
		int alea = rand.nextInt(longueur/5)*5;
		
		ArrayList<Integer> choix = aleachoix();
		String reponse = questions_reponses.get(alea+1);
		Label titre_phase = new Label("Phase 3: Questions � la cha�ne");
		Label question = new Label(numero_question+") "+questions_reponses.get(alea));
		TextField reponseText = new TextField ();
		
		Label score1 = new Label ("Joueur 1: "+Scores.s1);
		Label score2 = new Label ("Joueur 2: "+Scores.s2);
		Label joueur = new Label ("Joueur "+Scores.tour);
		
		
		//Classes et Id
		
		
		
		
		
		
		question.getStyleClass().add("question");
		
		
		
		VBox root = new VBox();
		HBox header = new HBox();
		HBox h_titre = new HBox (titre_phase);
		HBox h_question = new HBox(question);
		HBox h_reponse = new HBox (reponseText);
		HBox h_joueur = new HBox (joueur);
		
		
		
		

		header.getChildren().addAll(score1,h_titre,score2);
		Region blanc = new Region();
		blanc.setPrefHeight(100);
		blanc.setPrefWidth(100);
		h_question.setId("pane");
		header.setId("pane");
		h_reponse.setId("pane");
		h_joueur.setId("pane");
		score1.setId("score1");
		score2.setId("score2");
		root.getChildren().addAll(header,h_question,blanc,h_joueur,h_reponse);
		
		h_titre.getStyleClass().add("titre");
		h_question.setId("titre_question");
		
		reponseText.addEventHandler(ActionEvent.ACTION, e -> {
			 correction3(reponseText,reponse,stage);
		 });
		
	
		Scene scn = new Scene(root,600,200);
		scn.getStylesheets().add(getClass().getResource("../css/main.css").toExternalForm());
		stage.setScene(scn);
		stage.show();
		
	}
	
	private void correction3(TextField reponseText, String reponse,Stage stage) {
		if (reponseText.getText().equals(reponse)) {
			if (Scores.tour == 1) {
				Scores.s1 += 1;
				Scores.tour = 2;
			}
			else {
				Scores.s2 += 1;
				Scores.tour = 1;
			}
		}
		else {
			if (Scores.tour == 1) {
				Scores.tour = 2;
			}
			else {
				Scores.tour = 1;
			}
		}
		phase3 p3 = new phase3();
		Stage s = new Stage();
		try {
			p3.start(s);
			stage.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
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
	
	
	public void start(Stage stage) throws Exception {
	    startGame(stage);
	}
	
	//fonction qui renvoie 4 nombres entre 1 et 4 tous diff�rents
	public static ArrayList<Integer> aleachoix() {
		ArrayList<Integer> nombres = new ArrayList<>();
		nombres.add(1);
		nombres.add(2);
		nombres.add(3);
		nombres.add(4);
		Collections.shuffle(nombres);
		return nombres;
	}

	
}