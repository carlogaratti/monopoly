import java.util.Random;


public class Player {

	private PlaceHolder placeHolder;
	private Dice dice;
	private int rounds;

	public Player(PlaceHolder placeHolder) {
		this.placeHolder = placeHolder;
		this.rounds = 0;
	}

	
	public void run() {
		int position = dice.roll();	
		placeHolder.moveOfPasses(position);
		incrementRound();
		
	}

	private void incrementRound() {
		rounds++;	
	}

	public void dice(Dice dice) {
		this.dice = dice;
	}

	public Object rounds() {
		return rounds;
	}

	

}
