package com.game.myNewGame;

import java.util.Scanner;

public class TicTacToeMyGame {	
	static char[] board;
	
	//UC1
	public TicTacToeMyGame() {
		board = new char[10];
		for(int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}
	//UC2
	public char getSymbol() {
		Scanner input = new Scanner(System.in);
		System.out.println("Play with X/O ? ");
		char symbol = input.next().charAt(0);
		return symbol;
	}
	//UC3
	public void showBoard() {
		for(int i = 1; i < board.length; i++) {
			System.out.print(board[i]);
			if(i % 3 == 0) {
				System.out.println("\n---------");
				continue;
			}
			System.out.print(" | ");
		}
	}
	//UC4
	public boolean moveTo(int position, char playerSymbol) {
		if(board[position] == ' ') {
			board[position] = playerSymbol;
			return true;
		}
		else {
			System.out.println("Enter a valid position! Place already filled !");
			return false;
		}	
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
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
		System.out.println("Your symbol is " + playerSymbol);
		System.out.println("Computer symbol is " + compSymbol);
		game.showBoard();
		while(true) {
			System.out.println("Player enter the position you want to move to : ");
			int position = input.nextInt();
			if(position < 1 && position > 9) {
				System.out.println("Enter valid position");
				continue;
			}
			if(game.moveTo(position, playerSymbol)) {
				game.showBoard();
				break;
			}
		}
		input.close();
	}	
}
