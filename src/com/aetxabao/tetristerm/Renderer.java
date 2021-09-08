package com.aetxabao.tetristerm;

public class Renderer {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void drawInit() {
        clearScreen();
        System.out.println("########################");
        System.out.println("# TETRIS TERMINAL GAME #");
        System.out.println("########################");
        System.out.println();
        System.out.println("\t'Q' quit game");
        System.out.println();
        System.out.println("\tPiece actions");
        System.out.println("\t'W' rotate piece");
        System.out.println("\t'A' move left");
        System.out.println("\t'S' sink to bottom");
        System.out.println("\t'D' move right");
        System.out.println("\t'X' move down");
        System.out.println();
        System.out.println("Press ENTER key afterwards");
        System.out.println("      -----               ");
        System.out.println();
    }

    public static void drawBoard(Board board) {
        clearScreen();
        System.out.println();
        StringBuilder sb = new StringBuilder(board.getWidth() + 2);
        int height = board.getHeight();
        int width = board.getWidth();
        ETetromino[][] m = board.getBoardWithPiece();
        for(int i = 0; i<height; i++){
            sb.setLength(0);
            sb.append("|");
            for(int j = 0; j<width; j++){
                sb.append(m[i][j]);
            }
            sb.append("|");
            System.out.println(sb);
        }
        String s = "=";
        String bottomLine = s.repeat(width + 2);
        System.out.println(bottomLine);
        String t = board.getNextPiece().getTetromino().toString();
        int n = board.getLines();
        System.out.println("Next:" + t + "  L:" + n);
    }

    public static void drawYouWon(Board board) {
        drawBoard(board);
        System.out.println("************");
        System.out.println("* YOU WON! *");
        System.out.println("************");
    }

    public static void drawYouLost(Board board) {
        drawBoard(board);
        System.out.println("~~~~~~~~~~~~");
        System.out.println("~ You lost ~");
        System.out.println("~~~~~~~~~~~~");
    }
}
