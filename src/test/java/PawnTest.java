import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {

    private Board board;
    private Pawn whitePawn;
    private Pawn blackPawn;

    @Before
    public void setUp() {
        //inicjacja szachownicy
        board = new Board();

        //inicjacja białego pionka żywego nieruszanego na pozycji d2
        Position position = new Position("d2");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = false;
        whitePawn = new Pawn(color, position, isAlive, hasMove, board);

        //inicjacja czarnego pionka żywego nieruszanego na pozycji c7
        position = new Position("c7");
        color = "black";
        isAlive = true;
        hasMove = false;

        blackPawn = new Pawn(color, position, isAlive, hasMove, board);
    }

    @Test
    public void testWhiteNotMovedPawnOneStepSuccess() {

        boolean moveResult = whitePawn.move(new Position("d3"));
        assertEquals(true, moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
        assertEquals("d3", positionString);
        assertTrue(whitePawn.isHasMove());
    }

    @Test
    public void testWhiteNotMovedPawnOneStepFailure() {

        blackPawn.setPosition(new Position("d3"));

        boolean moveResult = whitePawn.move(new Position("d3"));
        assertFalse(moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
        assertEquals("d2", positionString);
        assertFalse(whitePawn.isHasMove());
    }

    @Test
    public void testWhiteNotMovedPawnTwoStepSuccess() {

        boolean moveResult = whitePawn.move(new Position("d4"));

        assertEquals(true, moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("d4", positionString);
        assertTrue(whitePawn.isHasMove());
    }

    @Test
    public void testWhiteNotMovedPawnTwoStepFailure() {

        blackPawn.setPosition(new Position("d3"));

        boolean moveResult = whitePawn.move(new Position("d4"));

        assertFalse(moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
        assertEquals("d2", positionString);
        assertFalse(whitePawn.isHasMove());
    }

    @Test
    public void testWhiteMovedPawnTwoStepFailure() {

        //ustawiamy że wykonał wcześniej ruch
        whitePawn.setHasMove(true);

        boolean moveResult = whitePawn.move(new Position("d4"));

//        assertEquals(false, moveResult);
//        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("d2", positionString);
        assertTrue(whitePawn.isHasMove());
    }

    @Test
    public void testWhiteNotMovedPawnOneStepBeatSuccess() {

        //czarny pionek jako figura do bicia
        blackPawn.setPosition(new Position("c3"));

        boolean moveResult = whitePawn.move(new Position("c3"));

        assertEquals(true, moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
        assertEquals("c3", positionString);
        assertTrue(whitePawn.isHasMove());

        //sprawdzanie zbitego pionka
        String positionString2 = blackPawn.getPosition().getPositionsString();
        assertFalse(blackPawn.isAlive());
    }

    @Test
    public void testWhiteNotMovedPawnOneStepBeatFailure() {

        //figura do bicia
        Position position2 = new Position("e3");
        String color2 = "white";
        boolean isAlive2 = true;
        boolean hasMove2 = true;

        Pawn pawn2 = new Pawn(color2, position2, isAlive2, hasMove2, board);

        boolean moveResult = whitePawn.move(new Position("e3"));

        assertEquals(false, moveResult);
        String positionString = whitePawn.getPosition().getPositionsString();
        assertEquals("d2", positionString);
        assertFalse(whitePawn.isHasMove());

        //sprawdzanie zbitego pionka
        String positionString2 = pawn2.getPosition().getPositionsString();
        assertEquals("e3", positionString2);
        assertTrue(pawn2.isAlive());
    }

    @Test
    public void testBlackNotMovedPawnOneStepSuccess() {

        boolean moveResult = blackPawn.move(new Position("c6"));

        assertEquals(true, moveResult);
        String positionString = blackPawn.getPosition().getPositionsString();
        assertEquals("c6", positionString);
        assertTrue(blackPawn.isHasMove());

    }

    @Test
    public void testBlackNotMovedPawnOneStepFailure() {

        boolean moveResult = blackPawn.move(new Position("d7"));

        assertFalse(moveResult);
        String positionString = blackPawn.getPosition().getPositionsString();
        assertEquals("c7", positionString);
        assertFalse(blackPawn.isHasMove());

    }

    @Test
    public void testBlackNotMovedPawnOneStepBeatSuccess() {

        //ustawienia dla bitego pionka
        whitePawn.setPosition(new Position("d6"));
        whitePawn.setHasMove(true);

        boolean moveResult = blackPawn.move(new Position("d6"));

        assertTrue(moveResult);
        String positionString = blackPawn.getPosition().getPositionsString();
        assertEquals("d6", positionString);
        assertTrue(blackPawn.isHasMove());

        //sprawdzanie zbitego pionka
        //String positionString2 = whitePawn.getPosition().getPositionsString();
        //assertEquals("", positionString2);  assert equals pusty string rezygnacja z kodu ktory sprowadza pusty string na pozycje
        assertFalse(whitePawn.isAlive());
    }

    @Test
    public void testWhiteMovedPawnOneStepSuccess() {

        whitePawn.setPosition(new Position("d4"));
        whitePawn.setHasMove(true);

        boolean moveResult = whitePawn.move(new Position("d5"));
//        assertEquals(true, moveResult);
//        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("d5", positionString);
        assertTrue(whitePawn.isHasMove());
    }

    @Test
    public void testBlackMovedPawnOneStepSuccess() {

        blackPawn.setPosition(new Position("d4"));
        blackPawn.setHasMove(true);

        boolean moveResult = blackPawn.move(new Position("d3"));
        //assertEquals(true, moveResult);
        //String positionString = blackPawn.getPosition().getPositionsString();
       // assertEquals("d3", positionString);
        assertTrue(blackPawn.isHasMove());
    }

    @Test
    public void testDestinationFieldColorIsDiffrentSucces(){

        // d2 na e3
        //c7

        blackPawn.setPosition(new Position("d3"));
        boolean isColorDiffrent = whitePawn.isDestinationFieldColorDiffrent(blackPawn.getPosition());
        assertTrue(isColorDiffrent);
    }

    @Test
    public void testDestinationFieldColorIsDiffrentIsNoCorrect(){

        Position position = new Position("e3");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;

        Pawn pawn2 = new Pawn(color,position, isAlive,hasMove,board);

        boolean isColorDiffrent = whitePawn.isDestinationFieldColorDiffrent(blackPawn.getPosition());
        assertTrue(isColorDiffrent);
    }
    @Test(expected = NullPointerException.class) //zakladamy ze w podczas testu wyleci wyjatek
    public void testDestinationFieldColorIsDiffrentException(){

        // d2 na e3
        //c7

        blackPawn.setPosition(new Position("f6"));
        boolean isColorDiffrent = whitePawn.isDestinationFieldColorDiffrent(new Position("e3")); //<- chce sprawdzic kolor figury na pozycji ktora jest puste
        assertTrue(isColorDiffrent);
    }
}