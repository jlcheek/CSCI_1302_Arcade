package cs1302.reversi;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Dialog extends Stage{
	
	public Dialog(String error, String message){
		VBox root = new VBox();
		Scene scene = new Scene(root);
		Label label = new Label(message);
		Button button = new Button("Okay");
		Button restart = new Button("Restart");
		
		button.setOnAction(e -> hide());
		
		restart.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				hide();
				ReversiMenu rMenu = new ReversiMenu();
			}//handle
			
		});

		root.setAlignment(Pos.CENTER);
		
		root.getChildren().addAll(label, button, restart);
		
		initModality(Modality.APPLICATION_MODAL);
		setTitle(error);
    	setScene(scene);
    	setResizable(false);
    	sizeToScene();	        	
    	show();
		
	}//Dialog
}//
