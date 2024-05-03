package org.example.task1;

import java.util.Scanner;

public class Survey {
    private Scanner scanner = new Scanner(System.in);
    public String survey(String msg) {
        Boolean flag = true;
        String value = null;

        try {
            while (flag) {
                System.out.println(msg);
                value = scanner.nextLine();
                flag = false;
            }
        } catch (NullPointerException e) {
            System.out.println("Вы не ввели начение");
        }
        return value;
    }
}
