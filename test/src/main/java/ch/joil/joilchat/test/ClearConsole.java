package ch.joil.joilchat.test;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by bananatreedad on 19/05/16.
 */
public class ClearConsole {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("hello\nwasischdalos");

        Thread.sleep(1000); // Just to give the user a chance to see "hello".

        for(int count = 0; count < 100; count++) {
            System.out.print(String.format("\033[%dA", 1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }


        for(int count = 0; count < 100; count++) {
            System.out.print("\b");
        }


        System.out.println("world");

        scanner.nextLine();
    }
}
