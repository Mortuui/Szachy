import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class) ///brakowalo!!!!
public class RookMoveTest {

    private Board board;
    private Rook rook;

    private Position from;
    private Position to;
    private boolean expectedResult;

    public RookMoveTest(Position from, Position to, boolean expectedResult) {
        this.from = from;
        this.to = to;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        //inicjacja szachownicy
        board = new Board();

        //inicjacja białego pionka żywego nieruszanego na pozycji d2
        Position position = new Position("d4");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;
        rook = new Rook(color, position, isAlive, hasMove, board);

    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][] {
                //ruch o jedno pole
                {new Position("a1"), new Position("a2"), true},
                {new Position("c2"), new Position("b2"), true},
                {new Position("d4"), new Position("d3"), true},
                {new Position("d5"), new Position("c5"), true},
                //ruch o więcej niż jedno pole prawidłowy
                {new Position("a1"), new Position("a6"), true},
                {new Position("g6"), new Position("a6"), true},
                {new Position("c1"), new Position("f1"), true},
                //ruch o więcej niż jedno pole nieprawidłowy
                {new Position("b1"), new Position("a3"), false},
                {new Position("d5"), new Position("c1"), false},
                {new Position("d4"), new Position("h1"), false},
                {new Position("c3"), new Position("a2"), false},

        });
    }


    @Test
    public void testRookMove() {
        rook.setPosition(from);

        boolean result = rook.move(to);

        assertEquals(expectedResult, result);
    }

}