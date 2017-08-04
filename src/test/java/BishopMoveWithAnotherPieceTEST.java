import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BishopMoveWithAnotherPieceTEST {

    private Board board;
    private Bishop bishop;
    private Bishop anotherBishop;

    private Position from;
    private Position to;
    private Position anotherBishopPosition;
    private boolean expectedResult;

    public BishopMoveWithAnotherPieceTEST(Position from, Position to, Position anotherBishopPosition, boolean expectedResult) {
        this.from = from;
        this.to = to;
        this.anotherBishopPosition = anotherBishopPosition;
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
        bishop = new Bishop(color, position, isAlive, hasMove, board);

        anotherBishop = new Bishop(color, position, isAlive, hasMove, board);

    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][] {
                //ruch o jedno pole
                {new Position("a1"), new Position("b2"),new Position("b3"), true},
                {new Position("c2"), new Position("b1"),new Position("h8"), true},
                //ruch o więcej niż jedno pole prawidłowy
                {new Position("a1"), new Position("c3"), new Position("a2"), true},
                {new Position("g6"), new Position("d3"), new Position("a1"), true},
                //ruch o więcej niż jedno pole nieprawidłowy
                {new Position("c1"), new Position("f4"), new Position("d2"), false},
                {new Position("h8"), new Position("a1"), new Position("c3"), false},
                {new Position("c4"), new Position("f1"), new Position("d3"), false},
                {new Position("f1"), new Position("a6"), new Position("e2"), false},

        });
    }


    @Test
    public void testBishopMove() {
        //ustawiamy pozycję gońca
        bishop.setPosition(from);
        //ustawiamy pozycję drugiej figury
        anotherBishop.setPosition(anotherBishopPosition);

        boolean result = bishop.move(to);

        assertEquals(expectedResult, result);
    }

}