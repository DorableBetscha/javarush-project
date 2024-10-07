package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);
        showGrid(true);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
            return;
        }
        boolean result = true;
        do {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] == 0) {
                gameField[x][y] = getRandomNumber(10) <= 8 ? 2 : 4;
                result = false;
            }
        }
        while (result == true);
    }

    private boolean canUserMove() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] == 0) {
                    return true;
                }
                if ((y < SIDE - 1 && gameField[y][x] == gameField[y + 1][x]) ||   //по вертикали
                        (x < SIDE - 1 && gameField[y][x] == gameField[y][x + 1])) {  //по горизонтали
                    return true;
                }
            }
        }
        return false;
    }

    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] > max) {
                    max = gameField[y][x];
                }
            }
        }
        return max;
    }

    private void win() {
        showMessageDialog(Color.LIGHTPINK, "YOU WIN! ヽ(=^･ω･^=)丿", Color.BLACK, 50);
        isGameStopped = true;
    }

    private void gameOver() {
        showMessageDialog(Color.GRAY, "GAME OVER! (×﹏×)", Color.BLACK, 50);
        isGameStopped = true;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, color, str);
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.ALICEBLUE;
            case 2:
                return Color.LIGHTPINK;
            case 4:
                return Color.ANTIQUEWHITE;
            case 8:
                return Color.LIGHTSKYBLUE;
            case 16:
                return Color.LIGHTCORAL;
            case 32:
                return Color.VIOLET;
            case 64:
                return Color.LIGHTSALMON;
            case 128:
                return Color.AQUA;
            case 256:
                return Color.AQUAMARINE;
            case 512:
                return Color.LIGHTCYAN;
            case 1024:
                return Color.LIME;
            case 2048:
                return Color.CORAL;
            default:
                return Color.NONE;
        }
    }

    private boolean compressRow(int[] row) {
        int insertPosition = 0;
        boolean result = false;
        for (int x = 0; x < SIDE; x++) {
            if (row[x] > 0) {
                if (x != insertPosition) {
                    row[insertPosition] = row[x];
                    row[x] = 0;
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                result = true;
                score += row[i];
                setScore(score);
            }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped == true) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                score = 0;
                setScore(score);
                createGame();
                drawScene();
            } else {
                return;
            }
        }
        if (canUserMove() == false) {
            gameOver();
        } else {
            if (key == Key.SPACE) {
                createGame();
                drawScene();
            } else if (key == Key.LEFT) {
                moveLeft();
                drawScene();
            } else if (key == Key.RIGHT) {
                moveRight();
                drawScene();
            } else if (key == Key.UP) {
                moveUp();
                drawScene();
            } else if (key == Key.DOWN) {
                moveDown();
                drawScene();
            }
        }
    }

    private void moveLeft() {
        boolean needNewNumber = false;
        for (int[] row : gameField) {
            boolean compressed = compressRow(row);
            boolean merged = mergeRow(row);
            if (merged) {
                compressRow(row);
            }
            if (compressed || merged) {
                needNewNumber = true;
            }
        }
        if (needNewNumber) {
            createNewNumber();
        }
    }

    private void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                result[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = result;
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void drawScene() {
        for (int y = 0; y < SIDE; y++)
            for (int x = 0; x < SIDE; x++)
                setCellColoredNumber(x, y, gameField[y][x]);
    }
}