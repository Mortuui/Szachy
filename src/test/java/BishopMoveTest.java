import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class BishopMoveTest {

    private  Board board;
    private  Bishop bishop;

    private Position from;
    private Position to;
    private boolean expectResult;

    public BishopMoveTest(Position from, Position to, boolean expectResult){
        this.from=from;
        this.to=to;
        this.expectResult = expectResult;
    }

    @Before
    public void setUp(){
        //inicjacja szachownicy
        board = new Board();

        //inicjacja białego pionka żywego nieruszanego na pozycji d2
        Position position = new Position("d4");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;
        bishop = new Bishop(color, position, isAlive, hasMove, board);



    }
    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][] {
                //ruch o jedno pole
                {new Position("a1"), new Position("b2"), true},
                {new Position("c2"), new Position("b1"), true},
                {new Position("d4"), new Position("e3"), true},
                {new Position("d4"), new Position("c5"), true},
                //ruch o więcej niż jedno pole prawidłowy
                {new Position("a1"), new Position("c3"), true},
                {new Position("g6"), new Position("d3"), true},
                {new Position("c1"), new Position("f4"), true},
                //ruch o więcej niż jedno pole nieprawidłowy
                {new Position("b1"), new Position("a3"), false},
                {new Position("d5"), new Position("d1"), false},
                {new Position("d4"), new Position("h1"), false},
                {new Position("c3"), new Position("a2"), false},
        });
    }


    @Test
    public void testBishopMove(){
        bishop.setPosition(from);

        boolean result = bishop.move(to);

        assertEquals(expectResult,result);

    }

}