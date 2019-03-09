package cs1302.arcade;
import cs1302.tetris.Tetris;
import cs1302.reversi.ReversiMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ArcadeConsole extends Stage{
	
	public ArcadeConsole(){
		VBox root = new VBox();
		Button tetrisButton = new Button("", new ImageView("file:res/TetrisLogo.png"));
		Button reversiButton = new Button("", new ImageView("file:res/ReversiLogo.png"));
		
		root.setAlignment(Pos.CENTER);
		
		tetrisButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				Tetris tetris = new Tetris();
			}//handle
			
		});
		
		reversiButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				ReversiMenu rMenu = new ReversiMenu();
			}//handle
			
		});
		
		Scene scene = new Scene(root);
		
		root.getChildren().addAll(tetrisButton, reversiButton);
		
	setTitle("Arcade");
    	setScene(scene);
    	setResizable(false);
    	sizeToScene();	        	
    	show();
	}
	
}
