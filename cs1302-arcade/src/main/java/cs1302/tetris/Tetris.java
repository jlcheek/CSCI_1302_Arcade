package cs1302.tetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Tetris extends Stage{
	
	private Pane pane = new Pane();
	private TilePane gamePane = new TilePane();
	private StackPane nextShapePane = new StackPane();
	private Label scorePane = new Label();
	private Label nextShapePicture = new Label();
	private HBox root = new HBox();
	private Scene scene = new Scene(root, Color.BLACK);
	private Block[][] blocks = new Block[20][10];
	/*private T t = new T();
	private Box box = new Box();
	private I i = new I();
	private L l = new L();
	private BL bl = new BL();
	private Jig jig = new Jig();
	private Jag jag = new Jag();*/
	private Shape shape;
	private Engine engine = new Engine();
	private double time = 1;
	private String[] collisionDown = new String[4];
	private String[] collisionRight = new String[4];
	private String[] collisionLeft = new String[4];
	private int score = 0;
	private Label scoreLabel = new Label(score + "");
	private Label nextShapeLabel = new Label("Next Shape");
	private double shapeCount = 0;
	private Shape nextShape;
	private Timeline timeline;
	
	public Tetris(){

		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent e){
            	if(e.getCode() == KeyCode.RIGHT){
            		moveRight();
            	}//if
            	if(e.getCode() == KeyCode.LEFT){
            		moveLeft();
            	}//if
            	if(e.getCode() == KeyCode.DOWN){
            		moveDown();
            	}//if
            	if(e.getCode() == KeyCode.SPACE){
            		rotate();
            	}//if
            	
            }//handle
            
        });
		 
		scoreLabel.setTextFill(Color.AQUA);
		gamePane.setPrefColumns(10);
		gamePane.setPrefRows(20);
		root.setStyle("-fx-background-color: #000000;");
		pane.setPrefWidth(400);
		pane.setStyle("-fx-border-color: white");
		gamePane.setStyle("-fx-border-color: white");
		
		for(int x = 0; x < 20; x++){
			for(int y = 0; y < 10; y++){
				blocks[x][y] = new Block("Gray");
				gamePane.getChildren().add(blocks[x][y]);
			}//for y
			
		}//for x
		
		nextShape = engine.getNext();
		shape = engine.getNext();
		nextShapePicture.setGraphic(new ImageView(new Image(nextShape.getImage())));
		scorePane.setGraphic(new ImageView(new Image("file:res/ScoreImage.png")));
		scorePane.setTranslateX(10);
		nextShapePane.setTranslateX(80);
		nextShapePane.setTranslateY(460);
		nextShapePane.getChildren().add(nextShapePicture);
		setNextShape();
		
		scoreLabel.setLayoutX(80);
		scoreLabel.setLayoutY(220);
		scoreLabel.setFont(new Font("Arial Bold", 40));
		
		nextShapeLabel.setLayoutX(110);
		nextShapeLabel.setLayoutY(400);
		nextShapeLabel.setFont(new Font("Arial Bold", 30));
		
		pane.getChildren().addAll(nextShapeLabel, nextShapePane, scorePane, scoreLabel);
		root.getChildren().add(pane, gamePane);
	
	//initModality(Modality.APPLICATION_MODAL);	
	setTitle("Tetris");
        setScene(scene);
        setResizable(false);
        sizeToScene();
        show();
        
        createTimer();
		
	}//Tetris
	
	public void setNextShape(){
		shapeCount += 1.0;
		shape = nextShape;
		nextShape = engine.getNext();
		nextShapePicture.setGraphic(new ImageView(new Image(nextShape.getImage())));
		place();
		setCollision();
		
		if((shapeCount % 12) == 0){
			time -= .05;
			createTimer();
		}//if
		
	}//setNextShape
	
	public void createTimer(){
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(time), new EventHandler<ActionEvent>(){
		    		
			public void handle(ActionEvent e){
				moveDown();
			}//handle
		        	
		});//handler);
		     		        
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().addAll(keyFrame);
		timeline.play();
		
	}//createTimer
	
	public void moveDown(){
		if(checkDown()){
			clear();
			shape.moveDown();
			place();
		}//if
		else{
			if(checkGame()){
				hide();
				new Dialog("Darn!", "Game Over!\nYour score was " + score);
			}//if
			checkRows();
			setNextShape();
		}//else
		
	}//moveDown
	
	public void moveLeft(){
		if(checkLeft()){
			clear();
			shape.moveLeft();
			place();
		}//if
		
	}//moveLeft
	
	public void moveRight(){
		if(checkRight()){
			clear();
			shape.moveRight();
			place();
		}//if
		
	}//moveRight
	
	public boolean checkGame(){
		if(blocks[3][4].getColor() != "Gray" || blocks[3][5].getColor() != "Gray" || blocks[3][4].getColor() != "Gray"){
			return true;
		}//if
		
		return false;
		
	}//checkGame
	
	public void place(){
		for(int x = 0; x < 4; x++){
			blocks[shape.getX(x)][shape.getY(x)].setColor(shape.getColor());
		}//for
		
	}//place
	
	public void clear(){
		for(int x = 0; x < 4; x++){
			blocks[shape.getX(x)][shape.getY(x)].setColor("Gray");
		}//for
		
	}//clear
	
	public void rotate(){
		if(checkRight() && checkDown() && checkLeft()){
			clear();
			shape.rotate();
			place();
			setCollision();
		}//if
		
	}//rotate
	
	public void setCollision(){
		for(int x = 0; x < 4; x++){
			if(shape.getX(x) < 19){
				if(blocks[shape.getX(x) + 1][shape.getY(x)].getColor() == "Gray"){
					collisionDown[x] = "Gray";
				}//if
				else{
					collisionDown[x] = "Other";
				}//else
				
			}//if Down
			
			if(shape.getY(x) < 9){
				if(blocks[shape.getX(x)][shape.getY(x) + 1].getColor() == "Gray"){
					collisionRight[x] = "Gray";
				}//if
				else{
					collisionRight[x] = "Other";
				}//else
				
			}//if Right
			
			if(shape.getY(x) > 0){
				if(blocks[shape.getX(x)][shape.getY(x) - 1].getColor() == "Gray"){
					collisionLeft[x] = "Gray";
				}//if
				else{
					collisionLeft[x] = "Other";
				}//else
				
			}//if Left
			
		}//for
		
	}//setCollision
	
	public boolean checkLeft(){
		for(int x = 0; x < 4; x++){
			if(shape.getY(x) > 0){
				if(blocks[shape.getX(x)][shape.getY(x) - 1].getColor() != "Gray" && collisionLeft[x].equals("Gray")){
					return false;
				}//if
				
			}//if
			else{
				return false;
			}//
			
		}//for
		return true;
	}//checkCollision
	
	public boolean checkRight(){
		for(int x = 0; x < 4; x++){
			if(shape.getY(x) < 9){
				if(blocks[shape.getX(x)][shape.getY(x) + 1].getColor() != "Gray" && collisionRight[x].equals("Gray")){
					return false;
				}//if
				
			}//if
			else{
				return false;
			}//
			
		}//for
		return true;
	}//checkCollision
	
	public boolean checkDown(){
		for(int x = 0; x < 4; x++){
			if(shape.getX(x) < 19){
				if(blocks[shape.getX(x) + 1][shape.getY(x)].getColor() != "Gray" && collisionDown[x].equals("Gray")){
					return false;
				}//if
				
			}//if
			else{
				return false;
			}//
			
		}//for
		return true;
	}//checkCollision
	
	public void checkRows(){
		int rowsEliminated = 0;
		for(int x = 19; x > -1; x--){
			int count = 0;
			for(int y = 0; y < 10; y++){
				if(blocks[x][y].getColor() == "Gray"){
					break;
				}//if
				else{
					count++;
				}//else
				if(count == 10){
					eliminateRow(x);
					shiftTilesDown(x - 1);
					x++;
					rowsEliminated++;
				}//if
				
			}//for
			
		}//for
		
		if(rowsEliminated == 1){
			score += 100;
		}//if
		else{
			score += (rowsEliminated * 100) * 2;
		}//else
		
		updateScore();
		
	}//checkRows
	
	public void updateScore(){
		scoreLabel.setText(score + "");
	}//updateScore
	
	public void eliminateRow(int row){
		for(int y = 0; y < 10; y++){
			blocks[row][y].setColor("Gray");
		}//for
		
	}//eliminateRow
	
	public void shiftTilesDown(int row){
		for(int x = row; x > 0; x--){
			for(int y = 0; y < 10; y++){
				blocks[x + 1][y].setColor(blocks[x][y].getColor());
				blocks[x][y].setColor("Gray");
			}//for
			
		}//for
		
	}//shiftTilesDown
	
}//Tetris
