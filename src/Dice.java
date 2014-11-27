import java.util.Random;


public class Dice {
	private int result;

	public int roll(){
		return result;
	}

	public int randomRoll() {
		this.result = new Random().nextInt(12 - 1) + 1;
		return result;
	}

	public void result(int result) {
		this.result = result;
		
	}
}
