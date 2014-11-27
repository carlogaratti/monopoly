import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;

import org.junit.Test;


public class MonopolyR1 {

	
	
	@Test
	public void rollSevenFromPositionZero(){
		
		PlaceHolder placeHolder = new PlaceHolder(new Board());
		Dice dice = new Dice();
		dice.result(7);
		Player player = new Player(placeHolder);
		player.dice(dice);
		player.run();
		assertEquals(7, placeHolder.position());
	}
	
	@Test
	public void rollSixFromPositionThirtyNine(){
		PlaceHolder placeHolder = new PlaceHolder(new Board());
		Dice dice = new Dice();
		dice.result(6);
		Player player = new Player(placeHolder);
		player.dice(dice);
		placeHolder.postion(39);
		player.run();
		assertEquals(5, placeHolder.position());
	}
	
	@Test
	public void HorseAndCarPlayAGame(){
		Game game = new Game();
		Board board = new Board();
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
		Game game = new Game();
		Board board = new Board();
		PlaceHolder horsePlaceHolder = new PlaceHolder(board);
		Player horse = new Player(horsePlaceHolder);
		game.partecipant(horse);
		game.play(3);
	}
	
	@Test(expected=IncorrectNumberOfPlayersException.class)
	public void isImpossibleToPlayaGameWithNinePlayer() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		Game game = new Game();
		Board board = new Board();
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.partecipant(new Player(new PlaceHolder(board)));
		game.play(3);
	}
	
	@Test
	public void HorseAndCarPlay100GamesRandomically(){
		Board board = new Board();
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
	public void totalRoundsWas20AndEachPlayerPlayed20rounds() throws IncorrectNumberOfPlayersException, OrderOfPlayersIsChangedException{
		Game game = new Game();
		Board board = new Board();
		Dice dice = new Dice();
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
	
	private void initialRandomOrdering(Player firstPlayer, Player secondPlayer) {
		Game game = new Game();
		game.partecipant(firstPlayer);
		game.partecipant(secondPlayer);
		assertEquals(Arrays.asList(firstPlayer, secondPlayer), game.partecipants());
	}

}
