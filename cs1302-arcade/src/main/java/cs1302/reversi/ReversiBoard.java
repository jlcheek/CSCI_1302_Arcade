package cs1302.reversi;

public class ReversiBoard implements Board{
    
    /**
     * This method uses the game board and a given position on the board where the player 
     * has chosen to play and iterates throught to find pieces of the opponent's to flip
     *
     * @param userGuessArray the 2D array that displays the game and is used for functions of the game as well
     * @param row integer for the row value
     * @param col integer for the column value
     * @param isDark boolean variable to define players
     *
     * @return String[][]
     */
    public String[][] swapPieces(String[][] userGuessArray, int row, int col, boolean isDark){
	String player;
	String opponent;

	if(isDark){
	    player = "X";
	    opponent = "O";
	}//if
	else{
	    player = "O";
	    opponent = "X";
	}//else
	
	boolean[] isTrue = new boolean[8];
	for(int x = 0; x < 8; x++){
	    isTrue[x] = true;
	}//for
	
	int count = 0;
	boolean isRunning = true;
	while(isRunning){
	    //right
	    if((col + 1) < 7){
		if(userGuessArray[row][col + 1] == opponent && isTrue[0]){
		    int n = 1;
		    while((col + n) < 7){
			n++;
			if(userGuessArray[row][col + n] == "."){
			    isTrue[0] = false;
			    break;
			}//if
			else if(userGuessArray[row][col + n] == player){
			    break;
			}//else if
			
		    }//while
		    n = 1;
		    while((col + n) < 7 && userGuessArray[row][col + n] == opponent && isTrue[0]){
			userGuessArray[row][col + n] = player;
			n++;
		    }//while
		    
		    isTrue[0] = false;
		    
		}//if
		else{
		    isTrue[0] = false;
		}//else
	    }//if
	    else{
		isTrue[0] = false;
	    }//else

	    //left
	    if((col - 1) > 0){
		if(userGuessArray[row][col - 1] == opponent && isTrue[1]){
		    int n = 1;
		    while((col - n) > 0){
			n++;
			if(userGuessArray[row][col - n] == "."){
			    isTrue[1] = false;
			    break;
			}//if
			else if(userGuessArray[row][col - n] == player){
			    break;
			}//else if
			
		    }//while
		    n = 1;
		    while((col- n) > 0 && userGuessArray[row][col - n] == opponent && isTrue[1]){
			userGuessArray[row][col - n] = player;
			n++;
		    }//while
		    
		    isTrue[1] = false;
		    
		}//if
		else{
		    isTrue[1] = false;
		}//else
	    }//if
	    else{
		isTrue[1] = false;
	    }//else

	    //up
	    if((row - 1) > 0){
		if(userGuessArray[row - 1][col] == opponent && isTrue[2]){
		    int n = 1;
		    while((row - n) > 0){
				n++;
				if(userGuessArray[row - n][col] == "."){
				    isTrue[2] = false;
				    break;
				}//if
				else if(userGuessArray[row - n][col] == player){
				    break;
				}//else if
				
		    }//while
			n = 1;
			while((row - n) > 0 && userGuessArray[row - n][col] == opponent && isTrue[2]){
				userGuessArray[row - n][col] = player;
				n++;
		    }//while
		    
		    isTrue[2] = false;
		    
		}//if
		else{
		    isTrue[2] = false;
		}//else
		
	    }//if
	    else{
	    	isTrue[2] = false;
	    }//else
	    
	    //down
	    if((row + 1) < 7){
		if(userGuessArray[row + 1][col] == opponent && isTrue[3]){
		    int n = 1;
		    while((row + n) < 7){
				n++;
				if(userGuessArray[row + n][col] == "."){
				    isTrue[3] = false;
				    break;
				}//if
				else if(userGuessArray[row + n][col] == player){
				    break;
				}//else if
			
		    }//while
		    n = 1;
		    while((row + n) < 7 &&  userGuessArray[row + n][col] == opponent && isTrue[3]){
		    	userGuessArray[row + n][col] = player;
		    	n++;
		    }//while
		    
		    isTrue[3] = false;
		    
		}//if
		else{
		    isTrue[3] = false;
		}//else
		
	    }//if
	    else{
	    	isTrue[3] = false;
	    }//else

	    //upRight
	    if((col + 1) < 7 && (row - 1) > 0){
			if(userGuessArray[row - 1][col + 1] == opponent && isTrue[4]){
			    int n = 1;
			    while((col + n) < 7 && (row - n) > 0){
					n++;
					if(userGuessArray[row - n][col + n] == "."){
					    isTrue[4] = false;
					    break;
					}//if
					else if(userGuessArray[row - n][col + n] == player){
					    break;
					}//else if
				
			    }//while
			    n = 1;
			    while((col + n) <= 7 && (row - n) >= 0 && userGuessArray[row - n][col + n] == opponent && isTrue[4]){
					userGuessArray[row - n][col + n] = player;
					n++;
			    }//while
			    
			    isTrue[4] = false;
			    
			}//if
			else{
			    isTrue[4] = false;
			}//else
			
	    }//if
	    else{
	    	isTrue[4] = false;
	    }//else

	    //upLeft
	    if((col - 1) > 0 && (row - 1) > 0){
			if(userGuessArray[row - 1][col - 1] == opponent && isTrue[5]){
			    int n = 1;
			    while((col - n) > 0 && (row - n) > 0){
				n++;
				if(userGuessArray[row - n][col - n] == "."){
				    isTrue[5] = false;
				    break;
				}//if
				else if(userGuessArray[row - n][col - n] == player){
				    break;
				}//else if
				
			    }//while
			    n = 1;
			    while((col - n) > 0 && (row - n) > 0 && userGuessArray[row - n][col - n] == opponent && isTrue[5]){
					userGuessArray[row - n][col - n] = player;
					n++;
			    }//while
			    
			    isTrue[5] = false;
			    
			}//if
			else{
			    isTrue[5] = false;
			}//else
			
	    }//if
	    else{
		isTrue[5] = false;
	    }//else
	    
	    //downLeft
	    if((col - 1) > 0 && (row + 1) < 7){
		if(userGuessArray[row + 1][col - 1] == opponent && isTrue[6]){
		    int n = 1;
		    while((col - n) > 0 && (row + n) < 7){
			n++;
			if(userGuessArray[row + n][col - n] == "."){
			    isTrue[6] = false;
			    break;
			}//if
			else if(userGuessArray[row + n][col - n] == player){
			    break;
			}//else if
			
		    }//while
		    n = 1;
		    while((col - n) > 0 && (row + n) < 8 && userGuessArray[row + n][col - n] == opponent && isTrue[6]){
			userGuessArray[row + n][col - n] = player;
			n++;
		    }//while
		    
		    isTrue[6] = false;
		    
		}//if
		else{
		    isTrue[6] = false;
		}//else
	    }//if
	    else{
		isTrue[6] = false;
	    }//else

	    //downRight
	    if((col + 1) < 7 && (row + 1) < 7){
		if(userGuessArray[row + 1][col + 1] == opponent && isTrue[7]){
		    int n = 1;
		    while((col + n) < 7 && (row + n) < 7){
			n++;
			if(userGuessArray[row + n][col + n] == "."){
			    isTrue[7] = false;
			    break;
			}//if
			else if(userGuessArray[row + n][col + n] == player){
			    break;
			}//else if
			
		    }//while
		    n = 1;
		    while((col + n) < 7 && (row + n) < 7 && userGuessArray[row + n][col + n] == opponent && isTrue[7]){
			userGuessArray[row + n][col + n] = player;
			n++;
		    }//while
		    
		    isTrue[7] = false;
		    
		}//if
		else{
		    isTrue[7] = false;
		}//else
	    }//if
	    else{
		isTrue[7] = false;
	    }//else

	    if(isTrue[0] == false && isTrue[1] == false && isTrue[2] == false && isTrue[3] == false && isTrue[4] == false && isTrue[5] == false && isTrue[6] == false && isTrue[7] == false){
		isRunning = false;
	    }

	    count++;
	    
	}//while
	
	return userGuessArray;

    }//swapPieces
    
    /**
     * This method clears the grid so that parsing in the swapPieces method
     * won't have to deal with the "_" character.
     * 
     * 
     * @param userGuessArray the 2D array of the game board
     *
     * @return String[][] returns the updated userGuessArray
     * 
     */
    public String[][] clearGrid(String[][] userGuessArray){

	for(int x = 0; x < 8; x++){
	    for(int y = 0; y < 8; y++){
		if(userGuessArray[x][y] == "_"){
		    userGuessArray[x][y] = ".";
		}//if

	    }//for y

	}//for x

	return userGuessArray;

    }//clearGrid
    
    /**
     * This method is responsible for printing the graphical representation
     * of this game using the userGuessArray game board 2D array
     *
     * @param userGuessArray the 2D array of the game board
     *
     */
    public void  printGrid(String[][] userGuessArray){
    	String rowString = "";

		//for-loop to create the grid by rows
		for(int x = 0; x < 8; x++){
		    rowString += " " + (x + 1) + " ";
		    
		    for(int y = 0; y < 8; y++){
	
				if(x < 8 && y < 8){
				    rowString += " " + userGuessArray[x][y];
				}//if
	
		    }//row-loop
		    
		    System.out.println(rowString);
	
		    rowString = "";
	
		}//column-loop
    
    }//printGrid
    
    /**
     * This method uses an algorithm to search through the grid and find available
     * places to play the next move of the game.
     *
     * @param userGuessArray the 2D array of the game board
     * @param isDark is used to define the current player's turn
     * 
     * @return returns a 2D array of the updated game board
     */
    public String[][] findAvailableSlots(String[][] userGuessArray, boolean isDark){
    	boolean isRight = true;
    	boolean isLeft = true;
    	boolean isUp = true;
    	boolean isDown = true;
    	boolean upRight = true;
    	boolean upLeft = true;
    	boolean downRight = true;
    	boolean downLeft = true;

    	int right = 1;
    	int left = -1;
    	int up = -1;
    	int down = 1;
    	String player;
    	String opponent;
    	if(isDark){
    	    player = "X";
    	    opponent = "O";
    	}//if
    	else{
    	    player = "O";
    	    opponent = "X";
    	}//else
    	int count = 0;

    	for(int x = 0; x < 8; x++){
    	    for(int y = 0; y < 8; y++){
    		if(userGuessArray[x][y] == "."){
    		    boolean isRunning = true;
    		    
    		    while(isRunning){
    			if((y + right) < 7){
    			    if(isRight && userGuessArray[x][y + right] == opponent){
    				while((y + right) < 7){
    				    right++;
    				    if(userGuessArray[x][y + right] == player){
    					userGuessArray[x][y] = "_";
    					break;
    				    }//if
    				    else if(userGuessArray[x][y + right] == "." || userGuessArray[x][y + right] == "_"){
    					break;
    				    }//else if
    				    
    				}//while
    				
    			    }//if
    			    else{
    				isRight = false;
    			    }//else
    	    
    			}//if
    			else{
    			    isRight = false;
    			}//else
    						
    			if((y + left) > 0){
    			    if(isLeft && userGuessArray[x][y + left] == opponent){
    				while((y + left) > 0){
    				    left--;
    				    if(userGuessArray[x][y + left] == player){
    					userGuessArray[x][y] = "_";
    					break;
    				    }//if
    				    else if(userGuessArray[x][y + left] == "." || userGuessArray[x][y + left] == "_"){
    					break;
    				    }//else if

    				}//while
    							
    			    }//if
    			    else{
    				isLeft = false;
    			    }//else
    			    
    			}//if
    			else{
    			    isLeft = false;
    			}//else
    						
    			if((x + up) > 0){
    			    if(isUp && userGuessArray[x + up][y] == opponent){
    				while((x + up) > 0){
    				    up--;
    				    if(userGuessArray[x + up][y] == player){
    					userGuessArray[x][y] = "_";
    					break;
    				    }//if
    				    else if(userGuessArray[x + up][y] == "." || userGuessArray[x + up][y] == "_"){
    					break;
    				    }//else if

    				}//while
    			    
    			    }//if
    			    else{
    				isUp = false;
    			    }//else
    			    
    			}//if
    			else{
    			    isUp = false;
    			}//else
    						
    			if((x + down) < 7){
    			    if(isDown && userGuessArray[x + down][y] == opponent){
	    				while((x + down) < 7){
	    				    down++;
	    				    if(userGuessArray[x + down][y] == player){
	    					userGuessArray[x][y] = "_";
	    					break;
	    				    }//if
	    				    else if(userGuessArray[x + down][y] == "." || userGuessArray[x + down][y] == "_"){
	    					break;
	    				    }//else if
	
	    				}//while
    							
    			    }//if
    			    else{
    				isDown = false;
    			    }//else
    			    
    			}//if
    			else{
    			    isDown = false;
    			}//else
    			

    			//up-right
    			if((y + 1) < 7 && (x - 1) > 0){
    			    if(upRight && userGuessArray[x - 1][y + 1] == opponent){
	    				int r = 1;
	    				int u = -1;
	    				while((y + r) < 7 && (x + u) > 0){
	    				    r++;
	    				    u--;
	    				    if(userGuessArray[x + u][y + r] == player){
		    					upRight = false;
		    					userGuessArray[x][y] = "_";
		    					break;
	    				    }//if
	    				    else if(userGuessArray[x + u][y + r] == "." || userGuessArray[x + u][y + r] == "_"){
		    					upRight = false;
		    					break;
	    				    }//else if
	
	    				}//while
    								
    			    }//if
    			    else{
    			    	upRight = false;
    			    }//else

    			}//if
    			else{
    			    upRight = false;
    			}//else
    			
    			//up-left
    			if((y - 1) > 0 && (x - 1) > 0){
    			    if(upLeft && userGuessArray[x - 1][y - 1] == opponent){
    			    	int u = -1;
    					int l = -1;
	    				while((y + l) > 0 && (x + u) > 0){
	    				    l--;
	    				    u--;
	    				    if(userGuessArray[x + u][y + l] == player){
		    					userGuessArray[x][y] = "_";
		    					upLeft = false;
		    					break;
	    				    }//if
	    				    else if(userGuessArray[x + u][y + l] == "." || userGuessArray[x + u][y + l] == "_"){
		    					upLeft = false;
		    					break;
	    				    }//else if
	
	    				}//while
    				
    			    }//if
    			    else{
    			    	upLeft = false;
    			    }//else

    			}//if
    			else{
    			    upLeft = false;
    			}//else
    			
    			//down-right
    			if((y + 1) < 7 && (x + 1) < 7){
    			    if(downRight && userGuessArray[x + 1][y + 1] == opponent){
    				int r = 1;
    				int d = 1;
    				while((y + r) < 7 && (x + d) < 7){
    				    r++;
    				    d++;
    				    if(userGuessArray[x + d][y + r] == player){
	    					userGuessArray[x][y] = "_";
	    					downRight = false;
	    					break;
    				    }//if
    				    else if(userGuessArray[x + d][y + r] == "." || userGuessArray[x + d][y + r] == "_"){
	    					downRight = false;
	    					break;
    				    }//else if

    				}//while
    								
    			    }//if
    			    else{
    			    	downRight = false;
    			    }//else

    			}//if
    			else{
    			    downRight = false;
    			}//else
    			
    			//down-left
    			if((y - 1) > 0 && (x + 1) < 7){
    			    if(downLeft && userGuessArray[x + 1][y - 1] == opponent){
    				int d = 1;
    				int l = -1;
    				while((y + l) > 0 && (x + d) < 7){
    				    l--;
    				    d++;
    				    if(userGuessArray[x + d][y + l] == player){
          					userGuessArray[x][y] = "_";
	    					downLeft = false;
	    					break;
    				    }//if
    				    else if(userGuessArray[x + d][y + l] == "." || userGuessArray[x + d][y + l] == "_"){
	    					downLeft = false;
	    					break;
    				    }//else if
    			
    				}//while
    							
    			    }//if
    			    else{
    			    	downLeft = false;
    			    }//else

    			}//if
    			else{
    			    downLeft = false;
    			}//else
    			
    			if(isRight == false && isLeft == false && isUp == false && isDown == false && upRight == false && upLeft == false && downLeft == false && downRight == false){
    			    upRight = true;
    			    upLeft = true;
    			    downRight = true;
    			    downLeft = true;
    			    isRight = true;
    			    isLeft = true;
    			    isUp = true;
    			    isDown = true;
    			    right = 1;
    			    up = -1;
    			    left = -1;
    			    down = 1;
    			    isRunning = false;
    			    count = 0;
    			}//if
    			count++;
    			if(count == 1000){
    			    upRight = false;
    			    upLeft = false;
    			    downRight = false;
    			    downLeft = false;
    			    isRight = false;
    			    isLeft = false;
    			    isUp = false;
    			    isDown = false;
    			}
    		    }//while

    		}//if

    	    }//for y

    	}//for x

    	return userGuessArray;
    	
    }//findAvalaibleSlots
    
}//ReversiBoard
