package com.game.myNewGame;

import java.util.Scanner;

public class TicTacToeMyGame {	
	char[] board;
	
	
	public TicTacToeMyGame() {
		board = new char[10];
		for(int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
	}
	
	public char getSymbol() {
		Scanner input = new Scanner(System.in);
		System.out.println("Play with X/O ? ");
		char symbol = input.next().charAt(0);
		return symbol;
	}
	
	public static void main(String[] args) {
		char playerSymbol;
		char compSymbol;
		System.out.println("Welcome to the TicTacToe game");
		TicTacToeMyGame game = new TicTacToeMyGame();
		while(true) {
			playerSymbol = game.getSymbol();
			compSymbol = (playerSymbol == 'X') ? 'O' : 'X';	
			if(playerSymbol == 'X' || playerSymbol == 'O') {
				break;
			}
			else {
				System.out.println("Enter a valid Character");
			}
		}
	}	
}
