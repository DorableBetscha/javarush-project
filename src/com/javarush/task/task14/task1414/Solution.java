package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;

        while ((key = reader.readLine()) != null) {
            Movie movie = MovieFactory.getMovie(key);
            if (movie == null) {
                return;
            }
            System.out.println(movie.getClass().getSimpleName());
        }
    }
    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            switch (key) {
                case "cartoon":
                    movie = new Cartoon();
                    break;
                case "thriller":
                    movie = new Thriller();
                    break;
                case "soapOpera":
                    movie = new SoapOpera();
                    break;
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
