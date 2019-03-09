package cs1302.tetris;

public abstract class Shape {
	
	protected int[] x = new int[4];
	protected int[] y = new int[4];
	private String color;
	int position;
	
	public Shape(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, String color){
		x[0] = x1;
		x[1] = x2;
		x[2] = x3;
		x[3] = x4;
		y[0] = y1;
		y[1] = y2;
		y[2] = y3;
		y[3] = y4;
		this.color = color;
		position = 0;
		
	}//Shape
	
	public boolean checkDown(){
		for(int x = 0; x < 4; x++){
			if(!(this.x[x] < 19)){
				return false;
			}//if
			
		}//for
		
		return true;
		
	}//check
	
	public boolean checkRight(){
		for(int x = 0; x < 4; x++){
			if(!(y[x] < 9)){
				return false;
			}//if
			
		}//for
		
		return true;
		
	}//check
	
	public boolean checkLeft(){
		for(int x = 0; x < 4; x++){
			if(!(y[x] > 0)){
				return false;
			}//if
			
		}//for
		
		return true;
		
	}//check
	
	public void moveDown(){
		x[0]++;
		x[1]++;
		x[2]++;
		x[3]++;
	}//moveDown
	
	public void moveRight(){
		y[0]++;
		y[1]++;
		y[2]++;
		y[3]++;
	}//moveRight
	
	public void moveLeft(){
		y[0]--;
		y[1]--;
		y[2]--;
		y[3]--;
	}//moveLeft
	
	public int getX(int n){
		return x[n];
	}//getXs
	
	public int getY(int n){
		return y[n];
	}//getYs
	
	public String getColor(){
		return color;
	}//getColor
	
	public void setX(int n, int x){
		this.x[n] = x;
	}//setXs
	
	public void setY(int n, int y){
		this.y[n] = y;
	}//setYs
	
	public void setColor(String color){
		this.color = color;
	}//setColor
	
	public abstract void rotate();
	public abstract String getImage();
	
}//Shape
