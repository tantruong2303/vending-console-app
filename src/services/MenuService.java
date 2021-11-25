/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import utils.MyScanner;

/**
 *
 * @author Lenovo
 */
public class MenuService {

    String[] hints;
    int numberOfHints = 0;

    public MenuService(int size) {
        if (size < 1) {
            size = 10;
        }
        hints = new String[size];
    }

    public void add(String aHint) {
        if (numberOfHints < hints.length) {
            hints[numberOfHints++] = aHint;
        }
    }

    public int getChoice() {
        int result = 0;
        if (numberOfHints > 0) {

            for (int i = 0; i < numberOfHints; i++) {
                System.out.println((i + 1) + " - " + hints[i]);
            }
            result = MyScanner.setInt(numberOfHints, 1, "***********\nPlease select an operation: ");
        }
        return result;
    }
}
