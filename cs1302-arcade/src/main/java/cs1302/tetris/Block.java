package cs1302.tetris;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block extends ImageView{
	
	String color = "Gray";
	
	public Block(){
		setImage(new Image("file:res/Block.png"));
	}//Block
	
	public Block(String color){
		this.color = color;
		setImage(new Image("file:res/" + this.color + "Block.png"));
	}//Block
	
	public void setColor(String color){
		this.color = color;
		setImage(new Image("file:res/" + this.color + "Block.png"));
	}//setColor
	
	public String getColor(){
		return color;
	}//getType
	
}//Block
