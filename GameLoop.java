import java.util.Scanner;

public class GameLoop {
    private Chessboard chessboard;
    private int boardSize;
    private int moveNumber;
    private Scanner scanner;

    public GameLoop(int boardSize) {
        this.boardSize = boardSize;
        chessboard = new Chessboard(boardSize);
        moveNumber = 1;
        scanner = new Scanner(System.in);
    }

    public void start() {
        // プレイヤーにスタート位置を選択させる
        System.out.println("チェス盤のスタート位置を選択してください（1-8の範囲で選んでください）");
        System.out.print("行 (1-8): ");
        int currentRow = scanner.nextInt();
        System.out.print("列 (1-8): ");
        int currentCol = scanner.nextInt();

        if (currentRow >= 1 && currentRow <= 8 && currentCol >= 1 && currentCol <= 8) {
            currentRow--; // ナイトの位置に合わせて調整
            currentCol--;
            chessboard.placeKnight(currentRow, currentCol);
        } else {
            System.out.println("無効な位置です。1から8の範囲で選択してください。");
            return; // ゲームを終了
        }

        // ゲームのメインループ
        while (!chessboard.isGameFinished()) {
            chessboard.printChessboard();

            System.out.println("次の移動先を選択してください（1-8の範囲で選んでください）");
            System.out.print("行 (1-8): ");
            int nextRow = scanner.nextInt();
            System.out.print("列 (1-8): ");
            int nextCol = scanner.nextInt();

            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                nextRow--; // ナイトの位置に合わせて調整
                nextCol--;

                if (chessboard.isEmpty(nextRow, nextCol)) {
                    chessboard.placeKnight(nextRow, nextCol);
                    moveNumber++;
                } else {
                    System.out.println("そのマスは既に訪れています。再度選択してください。");
                }
            } else {
                System.out.println("無効な位置です。1から8の範囲で選択してください。");
            }
        }

        System.out.println("ゲーム終了！全てのマスを巡回しました。");
        scanner.close();
    }

    public static void main(String[] args) {
        GameLoop game = new GameLoop(8);
        game.start();
    }
}
