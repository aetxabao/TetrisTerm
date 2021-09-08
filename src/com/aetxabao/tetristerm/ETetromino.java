package com.aetxabao.tetristerm;

public enum ETetromino {

    X(0),I(1),O(2),T(3),L(4),J(5),S(6),Z(7);

    private final String [] symbols = {" ", "I", "O", "T", "L", "J", "S", "Z"};

    private int code;

    ETetromino(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString(){
        return symbols[code];
    }

}
