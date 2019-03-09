package cs1302.tetris;

public class T extends Shape{

	public T(){
		super(1, 1, 1, 2, 3, 4, 5, 4, "Orange");
	}//T
	
	public void rotate(){
		//1 stays put
		if(position == 0){
			position = 1;
			setX(0, getX(0) + 1);
			setY(0, getY(0) + 1);
			setX(2, getX(2) - 1);
			setY(2, getY(2) - 1);
			setX(3, getX(3) - 1);
			setY(3, getY(3) + 1);
		}//if
		else if(position == 1){
			position = 2;
			setX(0, getX(0) - 1);
			setY(0, getY(0) + 1);
			setX(2, getX(2) + 1);
			setY(2, getY(2) - 1);
			setX(3, getX(3) - 1);
			setY(3, getY(3) - 1);
		}//else if
		else if(position == 2){
			position = 3;
			setX(0, getX(0) - 1);
			setY(0, getY(0) - 1);
			setX(2, getX(2) + 1);
			setY(2, getY(2) + 1);
			setX(3, getX(3) + 1);
			setY(3, getY(3) - 1);
		}//else if
		else if(position == 3){
			position = 0;
			setX(0, getX(0) + 1);
			setY(0, getY(0) - 1);
			setX(2, getX(2) - 1);
			setY(2, getY(2) + 1);
			setX(3, getX(3) + 1);
			setY(3, getY(3) + 1);
		}//else if
		
	}//rotate
	
	public String getImage(){
		return "file:res/TPicture.png";
	}//getImage
	
}//T
