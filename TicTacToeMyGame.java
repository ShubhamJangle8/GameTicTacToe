package com.game.myNewGame;

public class TicTacToeMyGame {	
	char[] board;
	
	public TicTacToeMyGame() {
		board = new char[10];
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the TicTacToe game");
		TicTacToeMyGame game = new TicTacToeMyGame();
	}	
}
