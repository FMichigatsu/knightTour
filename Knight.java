public class Knight {
    private Chessboard chessboard;
    private int row;
    private int col;

    public Knight(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValidMove(int row, int col) {
        int[] rowMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] colMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
        for (int i = 0; i < 8; i++) {
            int nextRow = this.row + rowMoves[i];
            int nextCol = this.col + colMoves[i];
            if (nextRow == row && nextCol == col && chessboard.isEmpty(row, col)) {
                return true;
            }
        }
        return false;
    }

    public void moveTo(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
