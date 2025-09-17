/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chessboard;

/**
 *
 * @author BED
 */
public class Chessboard {
    public static void main(String[] args) {

        int boardSize = 8;
        for (int row = 0; row < boardSize; row++) {  
            for (int col = 0; col < boardSize; col++) {
                if ((row + col) % 2 == 0) {
                    // Print a white square (W)
                    System.out.print("W ");  // 'W' stands for White square
                } else {
                    // Print a black square (B)
                    System.out.print("B ");  // 'B' stands for Black square
                }
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}

