Feature: TicTacToePlayGame
	In order to play a TicTacToe game
	As a gamer
	I want to be able to put crosses or noughts and determine a winner

Scenario: Play game
	Given I started a new game	
	When I put three crosses in a row
	Then I should win
