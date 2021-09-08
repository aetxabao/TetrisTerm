package com.aetxabao.tetristerm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Input {

    static void waitStart(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in.readLine();
        } catch (IOException e) {}
    }

    static EAction readAction(){
        System.out.print("QWASDX:  ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        switch (str.toUpperCase(Locale.ROOT)){
            case "Q":
                return EAction.QUIT_GAME;
            case "W":
                return EAction.ROTATE_PIECE;
            case "A":
                return EAction.MOVE_LEFT;
            case "S":
                return EAction.SINK_PIECE;
            case "D":
                return EAction.MOVE_RIGHT;
            default:
                return EAction.NO_ACTION;
        }
    }
}
