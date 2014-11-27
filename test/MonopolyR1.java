import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;

import org.junit.Before;
import org.junit.Test;


public class MonopolyR1 {

	private Dice dice;
	private Game game;
	private Board board;
	
	@Before
	public void init(){
		dice = new Dice();
		game = new Game();
		board = new Board();

	}
	
	@Test
	public void rollSevenFromPositionZero(){
		PlaceHolder placeHolder = new PlaceHolder(new Board());
		dice.result(7);
		Player player = new Player(placeHolder);
		player.dice(dice);
		player.run();
		assertEquals(7, placeHolder.position());
	}
	
	@Test
	public void rollSixFromPositionThirtyNine(){
		PlaceHolder placeHolder = new PlaceHolder(new Board());
		dice.result(6);
		Player player = new Player(placeHolder);
		player.dice(dice);
		placeHolder.postion(39);
		player.run();
		assertEquals(5, placeHolder.position());
	}
	
	@Test
	public void HorseAndCarPlayAGame(){
		PlaceHolder horsePlaceHolder = new PlaceHolder(board);
		Player horse = new Player(horsePlaceHolder);
		game.partecipant(horse);
		PlaceHolder carPlaceHolder = new PlaceHolder(board);
		Player car = new Player(carPlaceHolder);
		game.partecipant(car);
		assertEquals(Arrays.asList(horse, car), game.partecipants());
		
	}
	
	@Test(expected=IncorrectNumberOfPlayersException.class)
	public void isImpossibleToPlayaGameWithOnePlayer() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		PlaceHolder horsePlaceHolder = new PlaceHolder(board);
		Player horse = new Player(horsePlaceHolder);
		game.partecipant(horse);
		game.play(3);
	}
	
	@Test(expected=IncorrectNumberOfPlayersException.class)
	public void isImpossibleToPlayaGameWithNinePlayer() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		ninePartecipants(game, board);
		game.play(3);
	}

	
	
	@Test
	public void HorseAndCarPlay100GamesRandomically() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		PlaceHolder horsePlaceHolder = new PlaceHolder(board);
		Player horse = new Player(horsePlaceHolder);
		PlaceHolder carPlaceHolder = new PlaceHolder(board);
		Player car = new Player(carPlaceHolder);
		for (int i = 0; i < 50; i++) {
			initialRandomOrdering(horse, car);
			initialRandomOrdering(car, horse);
		}
	}

	
	@Test
	public void totalRoundsWas20AndEachPlayerPlayed20roundsAndthePartecipantsOrderIsTheSame() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		PlaceHolder horsePlaceHolder = new PlaceHolder(board);
		Player horse = new Player(horsePlaceHolder);
		horse.dice(dice);
		game.partecipant(horse);
		PlaceHolder carPlaceHolder = new PlaceHolder(board);
		Player car = new Player(carPlaceHolder);
		car.dice(dice);
		game.partecipant(car);
		game.play(20);
		assertEquals(20, horse.rounds());
		assertEquals(20, car.rounds());
	}
	
	private void initialRandomOrdering(Player firstPlayer, Player secondPlayer) throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException {
		Game game = new Game();
		firstPlayer.dice(dice);
		secondPlayer.dice(dice);
		game.partecipant(firstPlayer);
		game.partecipant(secondPlayer);
		game.play(20);
		assertEquals(Arrays.asList(firstPlayer, secondPlayer), game.partecipants());
	}
	
	private void ninePartecipants(Game game, Board board) {
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
	}

}
