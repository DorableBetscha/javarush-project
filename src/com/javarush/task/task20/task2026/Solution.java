package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int count;

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        count = 0;
        boolean[][] visited = new boolean[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && !visited[i][j]) {
                    dfs(a, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(byte[][] a, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[x].length ||
                a[x][y] != 1 || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            dfs(a, visited, newX, newY);
        }
    }
}
