import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class KnightBeatTest {

    private Board board;
    private Knight knight;
    private Piece anotherPice;
    private String color;
    private String anotherColor;
    private Position from;
    private Position to;
    private boolean expectResult;

    public KnightBeatTest(Position from, Position to, String color, String anotherColor, boolean expectResult) {  //kolejnosc pozycji w konstruktorze sie LICZY!!!!!!!!!!!!!
        this.from = from;
        this.to = to;
        this.color = color;
        this.expectResult=expectResult;
        this.anotherColor = anotherColor;
    }

    @Before
    public void setUp(){
        board = new Board();

        Position position = new Position("e4");
        String color = "white";
        boolean isAlive = true;
        boolean hasMove = true;
        knight = new Knight(color,position,isAlive,hasMove,board);
        anotherPice = new Knight(color,position,isAlive,hasMove,board);
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                //bicie prawidlowe po dlugim boku w prawo
                {new Position("e4"), new Position("f6"),"white","black",true},
                {new Position("e4"), new Position("g3"),"black","white",true},
                {new Position("e4"), new Position("d2"),"black","white",true},
                {new Position("e4"), new Position("c5"),"white","black",true},
                //bicie prawidlowe po dlugim boku w lewo
                {new Position("e4"), new Position("c3"),"white","black",true},
                {new Position("e4"), new Position("f2"),"black","white",true},
                {new Position("e4"), new Position("g5"),"black","white",true},
                {new Position("e4"), new Position("d6"),"white","black",true},
                //bicie nieprawidlowe po dlugim boku w prawo
                {new Position("e4"), new Position("f6"),"white","white",false},
                {new Position("e4"), new Position("g3"),"black","black",false},
                //bicie nieprawidlowe po dlugim boku w lewo
                {new Position("e4"), new Position("g5"),"black","black",false},
                {new Position("e4"), new Position("d6"),"black","black",false},

        });
    }
    @Test
    public void testBeatKnight(){
        knight.setPosition(from);
        knight.setColor(color);

        anotherPice.setAlive(true);
        anotherPice.setPosition(to);
        anotherPice.setColor(anotherColor);

        boolean result = knight.beatMove(to);
        assertEquals(expectResult,result);
    }
}