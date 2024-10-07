package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InterruptedThread());
        threads.add(new UraThread());
        threads.add(new MessageThread());
        threads.add(new IntSumThread());
    }

    public static void main(String[] args) {
    }
    public static class InfinityThread extends Thread{
        @Override
        public void run() {

            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println("InfinityThread");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class InterruptedThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class UraThread extends Thread {
        @Override
        public void run() {
            try {
                while(!isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MessageThread extends Thread implements Message {

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void showWarning() {
            while (isAlive()) {
                interrupt();
            }
        }
    }

    public static class IntSumThread extends Thread {
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                int sum = 0;
                while(!("N".equals(line = reader.readLine()))) {
                    sum += Integer.parseInt(line);
                }
                System.out.println(sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}