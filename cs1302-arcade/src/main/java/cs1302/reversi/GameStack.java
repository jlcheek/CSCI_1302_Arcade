package cs1302.reversi;

import javafx.scene.layout.StackPane;

public class GameStack extends StackPane{
	private int x = 0;
	private int y = 0;
	
	public GameStack(){
		
	}//GameStack
	
	public void setX(int x){
		this.x = x;
	}//setX
	public int getX(){
		return x;
	}//getX
	public void setY(int y){
		this.y = y;
	}//setX
	public int getY(){
		return y;
	}//getX
	
}//GameStack
