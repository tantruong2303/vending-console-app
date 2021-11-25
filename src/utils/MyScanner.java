/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MyScanner {

    public static int setInt(int max, int min, String str) {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true || input > max || input < min) {
            try {
                System.out.print(str);
                input = Integer.parseInt(sc.nextLine());
                if (input <= max && input >= min) {
                    break;
                }
                System.out.println("Invalid input!!");
            } catch (NumberFormatException error) {
                System.out.println("Invalid input!!");
            }
        }
        return input;
    }
}
