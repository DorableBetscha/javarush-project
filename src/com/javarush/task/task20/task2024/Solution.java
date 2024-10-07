package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* 
Знакомство с графами
*/

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution (int node) {
        this.node = node;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution sol1 = new Solution(1);
        Solution sol2 = new Solution(2);
        Solution sol3 = new Solution(3);
        Solution sol4 = new Solution(4);
        Solution sol5 = new Solution(5);
        Solution sol6 = new Solution(6);

        sol1.edges.add(sol2);
        sol2.edges.add(sol2);
        sol2.edges.add(sol4);
        sol2.edges.add(sol5);
        sol4.edges.add(sol1);
        sol4.edges.add(sol5);
        sol5.edges.add(sol4);
        sol6.edges.add(sol3);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(sol1);
        oos.writeObject(sol2);
        oos.writeObject(sol3);
        oos.writeObject(sol4);
        oos.writeObject(sol5);
        oos.writeObject(sol6);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Solution loadedSol1 = (Solution) ois.readObject();
        Solution loadedSol2 = (Solution) ois.readObject();
        Solution loadedSol3 = (Solution) ois.readObject();
        Solution loadedSol4 = (Solution) ois.readObject();
        Solution loadedSol5 = (Solution) ois.readObject();
        Solution loadedSol6 = (Solution) ois.readObject();

        baos.close();
        oos.close();
        ois.close();

        System.out.println(sol1);
        System.out.println(Objects.equals(sol1, loadedSol1));
        System.out.println(Objects.equals(sol2, loadedSol2));
        System.out.println(Objects.equals(sol3, loadedSol3));
        System.out.println(Objects.equals(sol4, loadedSol4));
        System.out.println(Objects.equals(sol5, loadedSol5));
        System.out.println(Objects.equals(sol6, loadedSol6));
    }
}
