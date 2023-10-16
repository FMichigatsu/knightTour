public class Chessboard {
    private int size;
    private int[][] board;
    private Knight knight;

    public Chessboard(int size) {
        this.size = size;
        board = new int[size][size];
        knight = new Knight(this);
    }

    public int getSize() {
        return size;
    }

    public void placeKnight(int row, int col) {
        board[row][col] = 1;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public boolean isGameFinished() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printChessboard() {
        System.out.print("  ");
        for (int col = 0; col < size; col++) {
            System.out.print(col + 1 + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < size; col++) {
                if (knight.getRow() == row && knight.getCol() == col) {
                    System.out.print("K ");
                } else if (board[row][col] == 0) {
                    if (knight.isValidMove(row, col)) {
                        System.out.print("o ");
                    } else {
                        System.out.print("× ");
                    }
                } else {
                    System.out.print("済 ");
                }
            }
            System.out.println();
        }
    }
}