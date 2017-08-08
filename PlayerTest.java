import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {      //zaslepianie obiektow MOCK

    Player player;
    Board board;

    @Mock
    Timer timer;

    @Before
    public void SetUp(){

        String color = "white";
        timer = mock(Timer.class);
        board = new Board();

        player = new Player(color,board,timer);

        Mockito.when(timer.getWhiteTime()).thenReturn(2000);  // zawsze metoda wywolana getWhiteTime da nam 2000s

    }

    @Test
    public void testMoveHasFigureCorrectTurnCorrectTimeCorrectDestinationSuccess(){
        board.setTurn("white");

        Position from = new Position("b2");
        Position to = new Position("b3");


        //inicjalizacja figury
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;



        Pawn pawn = new Pawn(color,from, isAlive, hasMove, board);

        // boolean result = player.doMove(new Position("b2"), new Position("c2"));
        boolean result = player.doMove(from, to);

     //   assertTrue(result);
}

    @Test
    public void testMoveHasFigureInCorrectTurnCorrectTimeCorrectDestinationFailure(){
        board.setTurn("black");

        Position from = new Position("a2");
        Position to = new Position("a3");


        //inicjalizacja figury
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;

        Pawn pawn = new Pawn(color, from, isAlive, hasMove, board);

        // boolean result = player.doMove(new Position("b2"), new Position("c2"));
        boolean result = player.doMove(from, to);

        assertFalse(result);
    }

    @Test
    public void testMoveHasNoFigureCorrectTurnCorrectTimeCorrectDestinationFailure(){
        board.setTurn("white");

        Position from = new Position("b2");
        Position to = new Position("b3");
        Position pawnPosition = new Position("d4");


        //inicjalizacja figury
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;

        Pawn pawn = new Pawn(color, pawnPosition, isAlive, hasMove, board);

        boolean result = player.doMove(from, to);

        assertFalse(result);
    }

    @Test
    public void testMoveHasWrongFigureCorrectTurnCorrectTimeCorrectDestinationFailure(){
        board.setTurn("black");

        Position from = new Position("c2");
        Position to = new Position("c3");


        //inicjalizacja figury
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;

        Pawn pawn = new Pawn(color, from, isAlive, hasMove, board);

        boolean result = player.doMove(from, to);

        assertFalse(result);
    }

    @Test
    public void testMoveHasFigureCorrectTurnCorrectTimeIncorrectDestinationFailure(){
        board.setTurn("black");

        Position from = new Position("b2");
        Position to = new Position("f7");


        //inicjalizacja figury
        String color = "black";
        boolean isAlive = true;
        boolean hasMove = true;

        Pawn pawn = new Pawn(color, from, isAlive, hasMove, board);

        boolean result = player.doMove(from, to);

        assertFalse(result);
    }

}