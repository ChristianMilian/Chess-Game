package util;
import game.*;
public class Pawn extends Piece{
    public Pawn(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
	if(!super.isLegal(move, game))
	    return false;
	//rules for pawn only!
	int rowDiff = move.getRow1() - move.getRow0();
	int colDiff = move.getCol1() - move.getCol0();
	if(rowDiff > 0 && white || rowDiff < 0 && !white) //making sure it is a white piece, and it is not moving illegally
	    return false;//pawn doesn't move backward!

	//add more rules here
		if(game.getPiece(move.getRow1(),move.getCol1()) == null){//move and not capture
			if (colDiff != 0)//not vertical

				return false;

			return Math.abs(rowDiff) == 1
					|| Math.abs(rowDiff) == 2 && move.getRow0() == 1 && !white && game.getPiece(2,move.getCol0()) == null
					|| Math.abs(rowDiff) == 2 && move.getRow0() == 6 && white && game.getPiece(5,move.getCol0()) == null;
		}else
			return Math.abs(rowDiff) * Math.abs(colDiff) == 1;
    }
	 @Override
	 public String toString() {
		return white?"\u2659":"\u265F";
    }
}
