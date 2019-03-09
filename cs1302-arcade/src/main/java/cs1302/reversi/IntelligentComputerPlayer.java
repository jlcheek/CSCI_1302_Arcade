package cs1302.reversi;

import java.util.ArrayList;
import java.util.Random;


public class IntelligentComputerPlayer extends ComputerPlayer{
    
    /**
     * This method returns the best place that awards the most
     * flipped pieces.
     * 
     * @param userGuessArray the 2D array that makes up the game board
     * @param isDark boolean that determines which players turn it is
     * 
     * @return int[] an int array that contains 2 integers of the computers guess
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
		
		int randomR = 0;
		
		randomR = r.nextInt(list.size());
		    
		n = list.get(randomR);
	
		return n;

    }//guess

}//IntelligentComputerPlayer