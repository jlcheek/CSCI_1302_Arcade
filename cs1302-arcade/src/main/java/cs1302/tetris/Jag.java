package cs1302.tetris;

public class Jag extends Shape{

	public Jag(){
		super(0, 1, 1, 2, 5, 5, 4, 4, "Cyan");
	}//Jag
	
	public void rotate(){
		// stays still
		if(position == 0){
			position = 1;
			setX(0, getX(0) + 2);
			setX(1, getX(1) + 1);
			setY(1, getY(1) - 1);
			setX(3, getX(3) - 1);
			setY(3, getY(3) - 1);
		}//if
		else{
			position = 0;
			setX(0, getX(0) - 2);
			setX(1, getX(1) - 1);
			setY(1, getY(1) + 1);
			setX(3, getX(3) + 1);
			setY(3, getY(3) + 1);
		}//else
			
	}//rotate
	
	public String getImage(){
		return "file:res/JagPicture.png";
	}//getImage
	
}//Jag
