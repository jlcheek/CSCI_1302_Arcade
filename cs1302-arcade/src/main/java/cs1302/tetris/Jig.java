package cs1302.tetris;

public class Jig extends Shape{
	
	public Jig(){
		super(0, 1, 1, 2, 4, 4, 5, 5, "Purple");
	}//Jig
	
	public void rotate(){
		//1 stays still
		if(position == 0){
			position = 1;
			setX(0, getX(0) + 1);
			setY(0, getY(0) + 1);
			setX(2, getX(2) + 1);
			setY(2, getY(2) - 1);
			setY(3, getY(3) - 2);
		}//if
		else{
			position = 0;
			setX(0, getX(0) - 1);
			setY(0, getY(0) - 1);
			setX(2, getX(2) - 1);
			setY(2, getY(2) + 1);
			setY(3, getY(3) + 2);
		}//else
		
	}//rotate
	
	public String getImage(){
		return "file:res/JigPicture.png";
	}//getImage
	
}//Jig
