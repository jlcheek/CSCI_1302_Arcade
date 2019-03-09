package cs1302.tetris;

import java.util.ArrayList;
import java.util.Random;

public class Engine {
	
	private final ArrayList<Shape> LIST = new ArrayList<Shape>();
	private int count = 0;
	
	public Engine(){
		
		//generateNewList(15);
		
	}//Engine
	
	public void generateNewList(int n){
		Random r = new Random();
		
		for(int x = 0; x < n; x++){
			int num = r.nextInt(7);
			
			if(num == 0){
				LIST.add(new I());
			}//else if
			else if(num == 1){
				LIST.add(new T());
			}//else if
			else if(num == 2){
				LIST.add(new L());			
			}//else if
			else if(num == 3){
				LIST.add(new BL());
			}//else if
			else if(num == 4){
				LIST.add(new Box());
			}//else if
			else if(num == 5){
				LIST.add(new Jig());
			}//else if
			else if(num == 6){
				LIST.add(new Jag());
			}//else if
			
		}//for
		
	}//generateNewList
	
	/*public Shape getNext(){
		if(count < 15){
			return LIST.get(count++);
		}//if
		return null;
	}//getNext*/
	
	public Shape getNext(){
		Random r = new Random();
		int num = r.nextInt(7);
		
		if(num == 0){
			return new I();
		}//else if
		else if(num == 1){
			return new T();
		}//else if
		else if(num == 2){
			return new L();			
		}//else if
		else if(num == 3){
			return new BL();
		}//else if
		else if(num == 4){
			return new Box();
		}//else if
		else if(num == 5){
			return new Jig();
		}//else if
		
		return new Jag();
		
	}//getNext
	
}//Engine
