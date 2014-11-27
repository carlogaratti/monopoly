import java.util.ArrayList;
import java.util.List;


public class Game {
	

	private List<Player> partecipants;
	
	public Game() {
		this.partecipants = new ArrayList<Player>();
	}

	public void partecipant(Player aPlayer) {
		partecipants.add(aPlayer);
	}

	public List<Player> partecipants() {
		return partecipants;
	}

	public void play(int times) throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException {
		if (partecipants.size() < 2 || partecipants.size() > 8) throw new IncorrectNumberOfPlayersException("Numero di Giocatori non corretto. Cosi non si Gioca");
		for (int i = 0; i < times; i++) {
			round();
		}
		
	}

	private void round() throws OrderOfPlayersIsChangedException {
		List<Player> partecipantsRun = new ArrayList<Player>();
		for (Player aPartecipant : partecipants) {
			aPartecipant.run();
			partecipantsRun.add(aPartecipant);
		}
		if (!(partecipants.equals(partecipantsRun))) throw new OrderOfPlayersIsChangedException("ordine dei players e' cambiato", partecipantsRun, partecipants);
	}

}
class IncorrectNumberOfPlayersException extends Exception {
	public IncorrectNumberOfPlayersException(String message) {
	}
}

class OrderOfPlayersIsChangedException extends Exception {
	public OrderOfPlayersIsChangedException(String message, List<Player> partecipantsRun, List<Player> partecipants) {
		System.out.println(partecipants);
		System.out.println(partecipantsRun);
	}
}
