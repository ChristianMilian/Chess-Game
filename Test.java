package test;
import game.*;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input;

		String[] tokens;

		Game game = null;

		//Continuous loop labeled so it can be broken inside
		loop: while(true){

			input = scanner.nextLine();

			tokens = input.split(" ");

			//Switch statement taking all possible user input
			switch(tokens[0]){
				case "new":
					if (tokens[1].equals("game") && tokens.length == 4){
						game = new Game(tokens[2], tokens[3]);

						game.showBoard(System.out);

						break;
					}
					System.out.println("Illegal command! please try again");
					break;
				case "move":
					if (tokens[1].matches("[a-h][1-8][a-h][1-8]") && tokens.length == 2){
						Move move = new Move(tokens[1]);

						if (game.move(move)){
							if (!game.isWhiteTurn()){
								System.out.printf("%s moves: %s\n", game.getPlayer1(), tokens[1]);
							} else {
								System.out.printf("%s moves: %s\n", game.getPlayer2(), tokens[1]);
							}
						}

						game.showBoard(System.out);

						break;
					}
					System.out.println("Illegal command! please try again");
					break;
				case "capture":
					if (tokens[1].matches("[a-h][1-8][a-h][1-8]") && tokens.length == 2){
						Move move = new Move(tokens[1]);

						if (game.move(move)){
							if (!game.isWhiteTurn()){
								System.out.printf("%s captures: %s\n", game.getPlayer1(), tokens[1]);
							} else {
								System.out.printf("%s captures: %s\n", game.getPlayer2(), tokens[1]);
							}
							break;
						}
					}
					System.out.println("Illegal command! please try again");
					break ;
				case "undo":
					if (tokens.length == 1){
						Game alternative = new Game(game.getPlayer1(), game.getPlayer2());
						for (int i = 0; i < game.getMoves().size() - 1; i++){
							alternative.move(game.getMoves().get(i));
						}
						game = alternative;
						break ;
					}
					System.out.println("Illegal command! please try again");
					break;
				case "print":
					if (tokens[1].equals("status") && tokens.length == 2){
						game.showBoard(System.out);
						System.out.println("List of moves: " + game);
						break ;
					} else{
						System.out.println("Illegal command! please try again");
						break ;
					}
				case "DONE":
					break loop;
				default:
					System.out.println("Illegal command! please try again");

			}


		}

	}//end main

}//end class
