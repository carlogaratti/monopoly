
public class PlaceHolder {

	private Board board;
	private int position;
	
	public PlaceHolder(Board board) {
		this.position = 0;
		this.board = board;
	}
	
	public void moveOfPasses(int passes) {
		position = board.next(this, passes);
		
	}

	public void postion(int position) {
		this.position = position;
		
	}

	public int position() {
		return position;
	}

}
