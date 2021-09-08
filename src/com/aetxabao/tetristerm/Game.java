package com.aetxabao.tetristerm;

import static com.aetxabao.tetristerm.Conf.*;

public class Game {

    private static EGameStatus gameStatus;
    private static Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);

    static void run() {
        init_game();
        while (gameStatus == EGameStatus.GAME_PLAYING) {
            render_game();
            process_input();
            update_game();
        }
        finish_game();
    }

    static void init_game() {
        Renderer.drawInit();
        Input.waitStart();
        gameStatus = EGameStatus.GAME_PLAYING;
    }

    static void render_game() {
        Renderer.drawBoard(board);
    }

    static void process_input() {
        EAction action = Input.readAction();
        if (action == EAction.QUIT_GAME){
            gameStatus = EGameStatus.GAME_QUIT;
            return;
        }
        if (board.canPieceDo(action)) {
            board.pieceDoes(action);
        }
    }

    static void update_game() {
        if (board.canPieceDo(EAction.MOVE_DOWN)){
            board.pieceDoes(EAction.MOVE_DOWN);
        }else{
            board.mergePiece();
            board.removeLines();
            if (board.getLines() == TARGET_LINES){
                gameStatus = EGameStatus.GAME_WON;
            }
            if (!board.newPiece()){
                gameStatus = EGameStatus.GAME_LOST;
            }
        }
    }

    static void finish_game() {
        switch (gameStatus){
            case GAME_WON:
                Renderer.drawYouWon(board);
                break;
            case GAME_LOST:
                Renderer.drawYouLost(board);
                break;
            default:
                Renderer.clearScreen();
        }
    }

}
