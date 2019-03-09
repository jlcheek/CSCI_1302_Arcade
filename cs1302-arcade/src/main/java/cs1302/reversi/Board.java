package cs1302.reversi;

public interface Board{
    
    String[][] swapPieces(String[][] userGuessArray, int row, int col, boolean isDark);
    String[][] clearGrid(String[][] userGuessArray);
    void printGrid(String[][] userGuessArray);
    String[][] findAvailableSlots(String[][] userGuessArray, boolean isDark);

}//Board