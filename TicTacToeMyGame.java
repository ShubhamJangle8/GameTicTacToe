package com.game.myNewGame;

import java.util.Scanner;

public class TicTacToeMyGame {	
	static char[] board;
	static char playerSymbol = 0, compSymbol = 0;
	//UC1
	public TicTacToeMyGame() {
		board = new char[10];
		for(int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}
	//UC2
	public static void getSymbol() {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Play with X/O ? ");
			playerSymbol = input.next().charAt(0);
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
	}
	//UC3
	public static void showBoard() {
		for(int i = 1; i < board.length; i++) {
			System.out.print(board[i]);
			if(i % 3 == 0) {
				System.out.println("\n---------");
				continue;
			}
			System.out.print(" | ");
		}
	}
	//UC4and5
	public static boolean moveToPlayer() {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("Player enter the position you want to move to : ");
			int position = input.nextInt();
			if(position < 1 && position > 9) {
				System.out.println("Enter valid position");
				continue;
			}
			else {
				if(board[position] == ' ') {
					board[position] = playerSymbol;
					showBoard();
					return true;
				}
				else {
					System.out.println("Enter a valid position! Place already filled !");
					return false;
				}
			}
		}

	}
	
	public static boolean moveToComp() {
		while(true) {
			System.out.println("Computer moves");
			int position = (int)Math.floor(Math.random() * 10) % 9 + 1;
			if(position < 1 && position > 9) {
				continue;
			}
			else {
				if(board[position] == ' ') {
					board[position] = compSymbol;
					showBoard();
					return true;
				}
				else {
					return false;
				}
			}
		}
	}
	//UC6
	public static int getTossDone() {
		return (int)Math.floor(Math.random() * 10) % 2;
	}
	
	public static void main(String[] args) {
		final int player = 0, computer = 1;
		Scanner input = new Scanner(System.in);
		//Welcome msg
		System.out.println("Welcome to the TicTacToe game");
		//Creating board
		new TicTacToeMyGame();
		//Showing board
		showBoard();
		//getting symbol for player and computer
		getSymbol();
		//It's toss time
		int toss = getTossDone();
		if(toss == player) {
			System.out.println("Player 1 won the toss");
		}
		else {
			System.out.println("Computer won the toss");
		}
		while(true) {
			if(toss == player) {
				moveToPlayer();
				moveToComp();
				break;
			}
			if(getTossDone() == computer) {
				moveToComp();
				moveToPlayer();
				break;
			}
			
		}
		input.close();
	}	
}
