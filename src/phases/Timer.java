package phases;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Timer implements Runnable {
	
	int time=0;

	public void run() {
	      while (time<=60) {
	    	  System.out.println(time);
	         time++;
	         try {
	            Thread.sleep(100);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }
	   }

}
