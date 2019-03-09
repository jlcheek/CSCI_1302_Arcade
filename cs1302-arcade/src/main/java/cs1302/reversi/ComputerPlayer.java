package cs1302.reversi;

import java.util.ArrayList;
import java.util.Random;

public abstract class ComputerPlayer extends Player{

    /**
     * This method is the computers guess that is not as randomized 
     * as the RandomComputerPlayer to make the strategy a little
     * harder.
     *
     * @param userGuessArray the 2D array of the game board
     *
     * @return returns an int array of size 2 containing the coordinates
     * to the computers next play
     *
     */
    public int[] guess(String[][] userGuessArray, boolean isDark){

    	int[] n = new int[2];
		Random r = new Random();
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int x = 0; x < 8; x++){
		    for( int y = 0; y < 8; y++){
		    	if(userGuessArray[x][y] == "_"){
			    	int[] tempInt = new int[2];
					tempInt[0] = x;
					tempInt[1] = y;
					list.add(tempInt);
		    	}//if
		    	
		    }//for y
	
		}//for x
		
		if(list.size() == 0) return null;
		
		int randomR = 0;
		
		randomR = r.nextInt(list.size());
		    
		n = list.get(randomR);
		
		boolean running = true;
    	long lastTime = System.nanoTime();
    	final double amountOfTicks = 60D;
    	double ns = 1000000000 / amountOfTicks;
    	double delta = 0;
    	while(running){
    		long now = System.nanoTime();
    	    delta += (now - lastTime) / ns;
    	    lastTime = now;
    		if(delta >= 1){
    		    if(delta > 100){
    		    	break;
    		    }//if
    		    
    		}//if
    		
    	}//while
	
		return n;

    }//guess

}//ComputerPlayer