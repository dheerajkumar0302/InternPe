package com.internpe.ticTacToe;

import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row = 0 ; row<board.length ; row++)
        {
            for(int col =0 ; col<board[row].length ; col++)
            {
                board[row][col]=' ';
            }
        }

        char player='X';
        boolean gameOver = false;
        int moveCount=0;

        Scanner scanner =  new Scanner(System.in);


        while (!gameOver && moveCount<9)
        {
            printBoardWithNumber(board);
            System.out.println("player "+player+" enter a position (1-9):  ");
            int pos = scanner.nextInt();

            if(pos>=1 && pos<=9)
            {
                int row=(pos-1)/3;
                int col=(pos-1)%3;
                if(board[row][col]==' ')
                {
                    board[row][col]=player;
                    moveCount++;
                    gameOver=haveWon(board,player);
                    if(gameOver)
                    {
                        System.out.println("Player "+player+" has won");
                    } else if (moveCount==9) {
                        System.out.println("It is draw! ");
                    }
                    else {
                        if(player=='X')
                            player='O';
                        else
                            player='X';
                    }
                }
                else
                {
                    System.out.println("Position is taken . Please try again. ");
                }
            }
            else
            {
                System.out.println("Invalid Move. Please enter value between 1 to 9 ");
            }
        }
        printBoard(board);
    }

    private static void printBoardWithNumber(char[][] board) {
        int position=1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    System.out.print(position + " | ");
                } else {
                    System.out.print(board[row][col] + " | ");
                }
                position++;
            }
            System.out.println();
        }
    }

    private static void printBoard(char[][] board) {
        for(int row = 0 ; row<board.length ; row++)
        {
            for(int col =0 ; col<board[row].length ; col++)
            {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    private static boolean haveWon(char[][] board, char player) {
        // for rows
        for(int row = 0 ; row<board.length ; row++)
        {
           if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
                return true;
        }
        // for col
        for(int col = 0 ; col<board.length ; col++)
        {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
                return true;
        }

        // for diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
                return true;

        if(board[0][2] == player && board[1][1]==player && board[2][0]==player)
                return true;

        return false;
    }
}
