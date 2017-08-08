import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class KnightMoveTest {

    private Board board;
    private Knight knight;

    private Position from;
    private Position to;
    private boolean expectedResult;

    public KnightMoveTest(Position from, Position to, boolean expectedResult) {
        this.from = from;
        this.to = to;
        this.expectedResult = expectedResult;
    }

@Before
public void setUp(){
        board = new Board();

        Position position = new Position("e4");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;
        knight = new Knight (color,position, isAlive, hasMove, board);
    }


    @Parameterized.Parameters
    public static Collection params(){
        return Arrays.asList(new Object[][] {
                //ruch po dlugim boku prawidlowy w prawo
                {new Position("e4"), new Position("f6"), true},
                {new Position("e4"), new Position("g3"), true},
                {new Position("e4"), new Position("d2"), true},
                {new Position("e4"), new Position("c5"), true},
                //ruch po dlugim boku prawidlowy w lewo
                {new Position("e4"), new Position("c3"), true},
                {new Position("e4"), new Position("f2"), true},
                {new Position("e4"), new Position("g5"), true},
                {new Position("e4"), new Position("d6"), true},
                //ruch nieprawidłowy
                {new Position("e4"), new Position("h3"), false},
                {new Position("e4"), new Position("d7"), false},
                {new Position("e4"), new Position("e1"), false},
                {new Position("e4"), new Position("d3"), false},

        });
    }
    @Test
    public void testKnightMove(){
        knight.setPosition(from);

        boolean result = knight.move(to);

        assertEquals(expectedResult, result);
    }
}