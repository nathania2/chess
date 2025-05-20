import java.awt.Graphics;
import java.util.ArrayList;

public class King extends Piece {

    public King(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }

    @Override
    public ArrayList<Square> getLegalMoves(Board b, Square currentSquare) {
        ArrayList<Square> legalMoves = new ArrayList<>();
        Square[][] board = b.getSquareArray();
        int row = currentSquare.getRow();
        int col = currentSquare.getCol();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length) {
                    Square targetSquare = board[newRow][newCol];
                    if (!targetSquare.isOccupied() || targetSquare.getOccupyingPiece().getColor() != this.getColor()) {
                        legalMoves.add(targetSquare);
                    }
                }
            }
        }

        return legalMoves;
    }

    @Override
    public ArrayList<Square> getControlledSquares(Square[][] board, Square currentSquare) {
        ArrayList<Square> controlledSquares = new ArrayList<>();
        int row = currentSquare.getRow();
        int col = currentSquare.getCol();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length) {
                    controlledSquares.add(board[newRow][newCol]);
                }
            }
        }
        return controlledSquares;
    }

    @Override
    public String toString() {
        return "A " + super.toString() + " king";
    }
}
