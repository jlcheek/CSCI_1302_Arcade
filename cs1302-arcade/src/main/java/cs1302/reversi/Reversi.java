package cs1302.reversi;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

    public class Reversi extends Stage{
        
        public static Player darkPlayer;
        public static Player lightPlayer;
        private Board board = new ReversiBoard();
    	private String[][] userGuessArray = new String[8][8];
        
        private TilePane root = new TilePane();
        private Scene scene = new Scene(root);
    	private GameStack[][] pane = new GameStack[8][8];
    	private Label[][] label = new Label[8][8];
    	private boolean[][] isPlaced = new boolean[8][8];
    	private int whosTurn = 1;
    	private boolean darkPlayerTurn = true;
    	private boolean humanTurn = false;
    	private int tileCount = 60;
    	private boolean playerVPlayer = false;

	ToolBar toolBar = new ToolBar();
    	MenuBar menuBar = new MenuBar();
	Menu file = new Menu("File");
	MenuItem exit = new MenuItem("Exit");
	MenuItem restart = new MenuItem("Restart");

        public Reversi(Player o1, Player o2){
        	
		file.getItems().addAll(exit, restart);
		 //exit button to exit program safely
		 exit.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent e){
				Platform.exit();
				System.exit(0);
	       	}//handle
	       	
		 });
		 
		 //restarts game safely
		 restart.setOnAction(new EventHandler<ActionEvent>(){
			
			 public void handle(ActionEvent e){
				 hide();
				 Tetris tetris = new Tetris();
			 }//handle
	        	
		 });
		 menuBar.getMenus().add(file);

		root.getChildren().add(menuBar);

        	new Dialog("Before you start!", "You are player X!");
        	
        	darkPlayer = o1;
		    darkPlayer.setPlayer("X");
		    
		    lightPlayer = o2;
		    lightPlayer.setPlayer("O");
        	
        	root.setPrefColumns(8);
    		root.setPrefRows(8);
    		
    		int count = 0;
    		int num1 = 1;
    		int num2 = 0;
    		
    		for(int x = 0; x < 8; x++){
    			for(int y = 0; y < 8; y++){
    				label[x][y] = new Label();
    				if(count % 8 == 0){
    					if(num1 == 1){
    						num1 = 2;
    						num2 = 1;
    					}//if
    					else{
    						num1 = 1;
    						num2 = 2;
    					}//else
    					
    				}//if
    				
    				if(count % 2 == 0){
    					pane[x][y] = new GameStack();
    					pane[x][y].getChildren().addAll(new ImageView("file:res/" + num1 + "Tile.png"), label[x][y]);
    				}//else if
    				else{
    					pane[x][y] = new GameStack();
    					pane[x][y].getChildren().addAll(new ImageView("file:res/" + num2 + "Tile.png"), label[x][y]);
    				}//else
    				
    				pane[x][y].setAlignment(Pos.TOP_LEFT);
    				pane[x][y].setX(x);
    				pane[x][y].setY(y);
    				addListeners(pane[x][y]);
    				root.getChildren().add(pane[x][y]);
    								
    				count++;
    				
    			}//for
    			
    		}//for
    		
    		for(int x = 0; x < 8; x++){
	    	    for(int y = 0; y < 8; y++){
	    	    	userGuessArray[x][y] = ".";
	    		
	    	    }//for y
	
	    	}//for x
    		
        	add(3, 3, 1);
        	add(3, 4, 2);
        	add(4, 3, 2);
        	add(4, 4, 1);
        	
        	userGuessArray[3][3] = "X";
	    	userGuessArray[3][4] = "O";
	    	userGuessArray[4][3] = "O";
	    	userGuessArray[4][4] = "X";
	    	
		//initModality(Modality.APPLICATION_MODAL);
        	setTitle("Reversi");
        	setScene(scene);
        	setResizable(false);
        	sizeToScene();	        	
        	show();
        	
	    	userGuessArray = board.findAvailableSlots(userGuessArray, true);
	    	
	    	if(darkPlayer.getClass() != HumanPlayer.class && lightPlayer.getClass() != HumanPlayer.class){
	    		run();
	    	}//if
	    	else if(darkPlayer.getClass() == HumanPlayer.class && lightPlayer.getClass() == HumanPlayer.class){
	    		playerVPlayer = true;
	    		humanTurn = true;
	    	}//if
	    	else if(darkPlayer.getClass() == HumanPlayer.class && lightPlayer.getClass() != HumanPlayer.class){
	    		humanTurn = true;
	    	}//if

        }//Constructor
        
        public void addListeners(GameStack sp){
            sp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
    	    		if(userGuessArray[sp.getX()][sp.getY()] == "_" && humanTurn){     
    	    			if(playerVPlayer){
	    	    			boolean isDarkSwap = true;
	    	    			boolean isDarkFind = false;
	                		if(whosTurn == 1){
	                			whosTurn = 2;
	                			userGuessArray[sp.getX()][sp.getY()] = "X";
	                			board.clearGrid(userGuessArray);
	                			tileCount--;
	                		}//if
	                		else if(whosTurn == 2){ 
	                			whosTurn = 1;
	                			userGuessArray[sp.getX()][sp.getY()] = "O";
	                			board.clearGrid(userGuessArray);
	                			isDarkSwap = false;
	                			isDarkFind = true;
	                			tileCount--;
	                		}//else if
	                		
	                		userGuessArray = board.swapPieces(userGuessArray, sp.getX(), sp.getY(), isDarkSwap);
	                    	userGuessArray = board.findAvailableSlots(userGuessArray, isDarkFind);
	                		placeSwaps();
	                		
	                		if(darkPlayerTurn){
	                			if(lightPlayer.getClass() != HumanPlayer.class){
	                				humanTurn = false;
	                			}//if
	                			darkPlayerTurn = false;
	                		}//if
	                		else{
	                			if(darkPlayer.getClass() != HumanPlayer.class){
	                				humanTurn = false;
	                			}//if
	                			darkPlayerTurn = true;
	                		}//else
	                		
    	    			}//if
    	    			else{
    	    				userGuessArray[sp.getX()][sp.getY()] = "X";
                			board.clearGrid(userGuessArray);
    	    				userGuessArray = board.swapPieces(userGuessArray, sp.getX(), sp.getY(), true);
	                    	userGuessArray = board.findAvailableSlots(userGuessArray, false);
	                		int[] guess;
	        		    	if((guess = lightPlayer.guess(userGuessArray, false)) == null){
	        		    		tileCount = 0;
	        		    	}//if
	        		    	add(sp.getX(), sp.getY(), 1);
	        		    	placeSwaps();
	        		    		    
	        		    	if(tileCount > 0){
		        		    	userGuessArray[guess[0]][guess[1]] = "O";
		        		    	board.clearGrid(userGuessArray);
		        			   	userGuessArray = board.swapPieces(userGuessArray, guess[0], guess[1], false);
		        		        userGuessArray = board.findAvailableSlots(userGuessArray, true);
		        		       	placeSwaps();
		        			   	
		        			   	darkPlayerTurn = true;
		        			   	humanTurn = true;
		        			   	
		        		    	tileCount -= 2;
	        		    	}//if
	                		
                		}//else*/
    	    			
    	    			if(tileCount == 0){
        		    		int xCount = 0;
        				    int oCount = 0;
        		    		
        		    		for(int x = 0; x < 8; x++){
        		    			for(int y= 0; y < 8; y++){
        		    				if(userGuessArray[x][y] == "X"){
        		    					xCount++;
        		    				}//if
        		    				else{
        		    					oCount++;
        		    				}//else
        		    				
        		    			}//for
        		    			
        		    		}//for
        		    		
        		    		if(xCount > oCount) new Dialog("Game Over!", "Player X wins!"); 
        		    		else if(xCount < oCount)new Dialog("Game Over!", "Player O wins!");
        		    		else if(xCount == oCount)new Dialog("Game Over!", "It's a tie!");
        		    		hide();
        		    	}
    	    			
                	}//if
    	    		
                }//handle
                
            });
            sp.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                	if(userGuessArray[sp.getX()][sp.getY()] == "_" && !isPlaced[sp.getX()][sp.getY()] && humanTurn){
                		add(sp.getX(), sp.getY(), 0);
                	}//if
                	
                }//handle
            
            });
            sp.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                	if(!isPlaced[sp.getX()][sp.getY()] && humanTurn){
                		remove(sp.getX(), sp.getY(), 0);
                	}//if
                	
                }//handle
            
            });
            
        }//addListeners

        public void add(int row, int col, int player){
        	if(player != 0){
        		isPlaced[row][col] = true;
        	}//if
    		pane[row][col].getChildren().remove(label[row][col]);
    		label[row][col].setGraphic(new ImageView("file:res/player" + player + ".png"));
    		pane[row][col].getChildren().add(label[row][col]);
    		show();
    	}//add
    	
    	public void remove(int row, int col, int player){
    		pane[row][col].getChildren().remove(label[row][col]);
    		label[row][col] = new Label();
    		pane[row][col].getChildren().add(label[row][col]);
    		show();
    	}//add
        
    	public void placeSwaps(){
    		for(int x = 0; x < 8; x++){
    			for(int y = 0; y < 8; y++){
    				if(userGuessArray[x][y] == "X"){
    					add(x, y, 1);
    				}//if
    				else if(userGuessArray[x][y] == "O"){
    					add(x, y, 2);
    				}
    				else if(userGuessArray[x][y] == "." || userGuessArray[x][y] == "_"){
    					remove(x, y, 0);
    				}//else if
    				
    			}//for
    			
    		}//for
    		
    	}//placeSwaps
    	
    	
        /**
         * This method is what runs the game and iterates through all the
         * scenarios until the board has filled up and no more moves are
         * made
         *
         */
        public void run(){
        	boolean running = true;
        	int xCount = 0;
		    int oCount = 0;
		    		
        	while(running){
        		if(tileCount == 0){		    		
		    		break;
		    	}//if
        		
		    	if(darkPlayerTurn){
		    		int[] guess;
			   		if((guess = darkPlayer.guess(userGuessArray, true)) == null) break;
			   		userGuessArray[guess[0]][guess[1]] = "X";
			   		add(guess[0], guess[1], 1);
			   		board.clearGrid(userGuessArray);
			   		userGuessArray = board.swapPieces(userGuessArray, guess[0], guess[1], true);
		           	userGuessArray = board.findAvailableSlots(userGuessArray, false);
		       		placeSwaps();
			   		
			   		darkPlayerTurn = false;
			   		tileCount--;
		    	}//if
		    	else{
		    		int[] guess;
		    		if((guess = lightPlayer.guess(userGuessArray, false)) == null) break;
		    		userGuessArray[guess[0]][guess[1]] = "O";
		    		add(guess[0], guess[1], 2);
		    		board.clearGrid(userGuessArray);
			    	userGuessArray = board.swapPieces(userGuessArray, guess[0], guess[1], false);
		            userGuessArray = board.findAvailableSlots(userGuessArray, true);
		        	placeSwaps();
			    	
			    	darkPlayerTurn = true;
			    	
		    		tileCount--;
		    	}//else
		    	
        	}//while
        	
        	for(int x = 0; x < 8; x++){
    			for(int y= 0; y < 8; y++){
    				if(userGuessArray[x][y] == "X"){
    					xCount++;
    				}//if
    				else{
    					oCount++;
    				}//else
    				
    			}//for
    			
    		}//for
        	
        	if(xCount > oCount) new Dialog("Game Over!", "Player X wins!"); 
    		else if(xCount < oCount)new Dialog("Game Over!", "Player O wins!");
    		else if(xCount == oCount)new Dialog("Game Over!", "It's a tie!");
		
        }//run
        
    }//Reversi