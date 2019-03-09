package cs1302.reversi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReversiMenu extends Stage{

	public ReversiMenu(){
		VBox root = new VBox();
		Button playerVPlayer = new Button("Player vs Player");
		Button playerVComputer = new Button("Player vs Computer");
		Button computerVComputer = new Button("Computer vs Computer");
		
		root.setAlignment(Pos.CENTER);
		
		playerVPlayer.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				hide();
				new Reversi(new HumanPlayer(), new HumanPlayer());
			}//handle
			
		});
		
		playerVComputer.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				hide();
				new Reversi(new HumanPlayer(), new RandomComputerPlayer());
			}//handle
			
		});
		
		computerVComputer.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				hide();
				new Reversi(new RandomComputerPlayer(), new RandomComputerPlayer());
			}//handle
			
		});
		
		root.getChildren().addAll(playerVPlayer, playerVComputer, computerVComputer);
		
		Scene scene = new Scene(root);
		
		setTitle("Reversi Menu");
    	setScene(scene);
    	setResizable(false);
    	setMaxHeight(150);
    	setHeight(150);
    	sizeToScene();	        	
    	show();
	}//ReversiMenu
	
}//ReversiMenu
