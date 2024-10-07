package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                sb.append(fileReader.readLine());
            }
        }

        String tag = args[0];
        Pattern patternTag = Pattern.compile("(?<one><" + tag + "(?:.*?)?>)|(?<two></" + tag + ">)", Pattern.DOTALL);

        String sb1 = sb.toString().replaceAll("[\\r\\n]+", "");

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dequeStart = new ArrayDeque<>();
        Matcher matcher = patternTag.matcher(sb1);
        while (matcher.find()) {
            String one = matcher.group("one");
            String two = matcher.group("two");
            if (one != null) {
                dequeStart.addFirst(matcher.start("one"));
            } else {
                if (two != null)
                    map.put(dequeStart.pollFirst(), matcher.end());
            }

        }
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(sb1.substring(entry.getKey(), entry.getValue())));
    }
}
