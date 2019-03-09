package cs1302.reversi;

import java.util.ArrayList;
import java.util.Random;

public class RandomComputerPlayer extends ComputerPlayer{

    /**
     * this method is the computers guess that is completely
     * randomized using a Random generator
     *
     * @param userGuessArray the 2D array of the game board
     *
     * @return returns an int array of size 2 containing the computers row and 
     * col choice.
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
    	
		return n;

    }//guess

}//RandomComputerPlayer