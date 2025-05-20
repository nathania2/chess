public class Square {
    private int row;
    private int col;
    private int x; 
    private int y; 
    private Piece occupyingPiece;

    public Square(int row, int col, int x, int y) {
        this.row = row;
        this.col = col;
        this.x = x;
        this.y = y;
        this.occupyingPiece = null; // starts empty
    }

    // Getters for board position
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Check if square is occupied
    public boolean isOccupied() {
        return occupyingPiece != null;
    }

    // Get the piece on this square
    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    // Place a piece on this square
    public void setOccupyingPiece(Piece piece) {
        this.occupyingPiece = piece;
    }

    // Remove any piece from this square
    public void removePiece() {
        this.occupyingPiece = null;
    }

    @Override
    public String toString() {
        return "Square (" + row + ", " + col + ")";
    }
}
