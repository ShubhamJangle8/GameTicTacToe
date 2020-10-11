package com.game.myNewGame;

import java.util.Scanner;

public class TicTacToeMyGame {	
	static char[] board;
	static char playerSymbol = 0, compSymbol = 0;
	static int count = 0;
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
	public static void moveToPlayer(Scanner scanner) {
		while(true) {
			System.out.println("Player enter the position you want to move to : ");
			int position = scanner.nextInt();
			if(position < 1 && position > 9) {
				System.out.println("Enter valid position");
				continue;
			}
			else {
				if(board[position] == ' ') {
					board[position] = playerSymbol;
					showBoard();
					count++;
					break;
				}
				else {
					System.out.println("Enter a valid position! Place already filled !");
				}
			}
		}
	}
	//modified for UC10
	public static void moveToComp() {
		System.out.println("Computer moves");
		while (true) {
			int position = 0;
			int[] corners = { 1, 3, 7, 9 };

			int winPosComp = winPosition(compSymbol);
			int winPosPlayer = winPosition(playerSymbol);

			if (winPosComp != 0) {
				position = winPosComp;
			} 
			else if (winPosPlayer != 0) { // computer will choose that position only if computer is not wining
				position = winPosPlayer;
			} 
			else {
				// counting number of empty corners
				int countEmptyCorners = 0;
				for (int i = 0; i < corners.length; i++) {
					if (board[corners[i]] == ' ') {
						countEmptyCorners++;
					}
				}
				System.out.println("Empty corners : " + countEmptyCorners);
				// if no one is wining then selecting corner
				if (countEmptyCorners == 0) {
					// if corner is not available then taking center
					if (board[5] == ' ') {
						position = 5;
					}
					// if center is not available then taking side
					else {
						while (true) {
							position = (int) Math.floor(Math.random() * 10) % 9 + 1;
							if (board[position] == ' ')
								break;
						}
					}
				}
				// if corner is empty then selecting random corner
				else {
					while (true) {
						position = corners[(int) Math.floor(Math.random() * 10) % 4];
						if (board[position] == ' ')
							break;
					}
				}
			}
			if(board[position] == ' ') {
				board[position] = compSymbol;
				showBoard();
				count++;
				return;
			}	
		}
	}
	//UC6
	public static int getTossDone() {
		return (int)Math.floor(Math.random() * 10) % 2;
	}
	//UC7
	public static int getWinner(char symbol, char[] board) {
		if(count == 9) {
			return 2;
		}
		if ((board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
			(board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
			(board[7] == symbol && board[8] == symbol && board[9] == symbol) ||
			(board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
			(board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
			(board[3] == symbol && board[6] == symbol && board[9] == symbol) ||
			(board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
			(board[3] == symbol && board[5] == symbol && board[7] == symbol)) {
			return 1;
		}
		else {
			return 0;
		}		
	}
	//UC8 and UC9 modified
	public static int winPosition(char symbol) {
		char[] copyBoard = board.clone();
		
		for(int i = 1; i<copyBoard.length; i++) {
			if(copyBoard[i] == ' ') {
				copyBoard[i] = symbol;
				if(getWinner(symbol, copyBoard) == 1) {
					return i;
				}
				else
					copyBoard[i] = ' ';
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		final int player = 0, computer = 1;
		Scanner input = new Scanner(System.in);
		//Welcome message
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
		//move player and computer based on toss
		while(true) {
			if(toss % 2 == player) {
				moveToPlayer(input);
				toss++;
				//Winning condition
				if(getWinner(playerSymbol, board) == 1) {
					System.out.println("Congratulations ,you have won this game");
					break;
				}
				else if(getWinner(playerSymbol, board) == 2) {
					System.out.println("No one won this game");
					break;
					
				}
			}
			else{
				moveToComp();
				toss++;
				if(getWinner(compSymbol, board) == 1) {
					System.out.println("Computer wins the game");
					break;
				}
				else if(getWinner(compSymbol, board) == 2) {
					System.out.println("No one won this game");
					break;
				}
			}
			
		}
		input.close();
	}	
}
