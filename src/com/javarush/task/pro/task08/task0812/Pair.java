package com.javarush.task.pro.task08.task0812;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        x ^= y; // x = 100 101 = 001
        y ^= x; // y = 101 001 = 100
        x ^= y; // x = 001 100 = 101
    }
}
