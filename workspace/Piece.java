
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      return getLegalMoves(null, start); // For now, assume it controls the same squares it can move to
  }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start) {
      ArrayList<Square> legalMoves = new ArrayList<>();
      int row = start.getRow();
      int col = start.getCol();
      Square[][] board = b.getSquareArray();

      // Example logic for a King (moves one square in any direction)
      int[] rowMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
      int[] colMoves = {-1, 0, 1, -1, 1, -1, 0, 1};

      for (int i = 0; i < 8; i++) {
          int newRow = row + rowMoves[i];
          int newCol = col + colMoves[i];

          if (isValidMove(newRow, newCol, board)) {
              legalMoves.add(board[newRow][newCol]);
          }
      }

      return legalMoves;
  }

  // Checks if a move is valid (within bounds and not occupied by the same color)
  private boolean isValidMove(int row, int col, Square[][] board) {
      if (row < 0 || row >= 8 || col < 0 || col >= 8) return false; // Out of bounds
      Square target = board[row][col];
      return !target.isOccupied() || target.getOccupyingPiece().getColor() != this.color;
  }
}