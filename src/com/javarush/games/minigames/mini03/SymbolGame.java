package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    @Override
    public void initialize(){
        setScreenSize(8, 3);
        showGrid(false);
        char[] array = "JAVARUSH".toCharArray();
        for (int i = 0; i < array.length; i++){
            setCellValueEx(i, 1, Color.ORANGE, array[i] + "");
        }
    }
}
