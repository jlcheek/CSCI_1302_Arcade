package cs1302.tetris;

public class Box extends Shape{

	public Box(){
		super(0, 0, 1, 1, 5, 4, 5, 4, "Green");
	}//Box
	
	public void rotate(){
		//not supported
	}//rotate
	
	public String getImage(){
		return "file:res/BoxPicture.png";
	}//getImage
	
}//Box
