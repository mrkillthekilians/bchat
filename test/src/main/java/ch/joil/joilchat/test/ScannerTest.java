package ch.joil.joilchat.test;

import java.util.Scanner;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class ScannerTest {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String test = scanner.nextLine();

            System.out.println(test);
        }
    }
}
