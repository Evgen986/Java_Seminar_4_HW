package org.example.HW2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Дана строка ы, содержащая только символы '(', ')', '{', '}', '[' и ']', определите, является ли входная строка допустимой.
 * Входная строка допустима, если:
 * Открытые скобки должны быть закрыты скобками того же типа.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждая закрывающая скобка имеет соответствующую открытую скобку того же типа.
 */
public class Main {
    public static void main(String[] args) {
        String text1 = "()";
        System.out.println(check(text1));
    }

    public static boolean check(String s) {
        Deque<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||
                    s.charAt(i) == '{' ||
                    s.charAt(i) == '[') list.add(s.charAt(i));
            else {
                if (list.isEmpty()) return false;
                else if (s.charAt(i) == ')' && list.getLast().equals('(')) list.pollLast();
                else if (s.charAt(i) == '}' && list.getLast().equals('{')) list.pollLast();
                else if (s.charAt(i) == ']' && list.getLast().equals('[')) list.pollLast();
                else return false;
            }
        }
        return list.isEmpty();
    }
}