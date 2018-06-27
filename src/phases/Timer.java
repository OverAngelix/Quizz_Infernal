package phases;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import programmeprincipal.Scores;

public class Timer implements Runnable {
	private Stage prevStage;
	private volatile boolean b=false;

	public Timer(Stage stage) {
		this.prevStage=stage;
	}
	
	int time=0;

	public void run() {
	      
	         try {
	        	 while (time<=5) {
	        		 Platform.runLater(() -> phase3.setTime(time++));
	    	    	 Thread.sleep(1000);
	    	     	 
	        	 }
	        	 
	 			 Platform.runLater(() -> {
	 				if (b) {
					try {
						phase4 p4 = new phase4();
			 			Stage s = new Stage();
						p4.start(s);
						this.prevStage.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 				}
	 				else {b=true;Scores.tour=2;}
				});
	         } 
	         catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	      }
	   }

