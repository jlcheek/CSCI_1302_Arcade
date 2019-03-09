package cs1302.tetris;

public class I extends Shape{
	
	public I(){
		super(0, 1, 2, 3, 4, 4, 4, 4, "Yellow");
	}//I
	
	public void rotate(){
		//starts out upright
		//0 stays still
		if(y[0] > 0){
			if(position == 0){
				position = 1;
				setX(1, getX(1) - 1);
				setY(1, getY(1) - 1);
				setX(2, getX(2) - 2);
				setY(2, getY(2) + 1);
				setX(3, getX(3) - 3);
				setY(3, getY(3) + 2);
			}//if
			else{
				if(y[0] < 8){
					position = 0;
					setX(1, getX(1) + 1);
					setY(1, getY(1) + 1);
					setX(2, getX(2) + 2);
					setY(2, getY(2) - 1);
					setX(3, getX(3) + 3);
					setY(3, getY(3) - 2);
				}//if
				
			}//else
		
		}//if
		
	}//rotate
	
	public String getImage(){
		return "file:res/IPicture.png";
	}//getImage
	
}//I
