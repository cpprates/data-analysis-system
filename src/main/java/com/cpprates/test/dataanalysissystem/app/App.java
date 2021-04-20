package com.cpprates.test.dataanalysissystem.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Write the code");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] separate = line.split("ç");
        System.out.println(separate[0] + " content of index 0");
        System.out.println(separate[1] + " content of index 1");
        System.out.println(separate[2] + " content of index 2");
        System.out.println(separate[3] + " content of index 3");


    }
}
