import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;




    @RunWith(Parameterized.class)
    public class RookBeatTest {

        private Board board;
        private Rook rook;
        private Position from;
        private Position to;
        private boolean expectResult;
        private String color;
        private String anotherColor;
        private Piece anotherPiece;


        public RookBeatTest( Position from, Position to, String color, String anotherColor,boolean expectResult) {
            this.from = from;
            this.to = to;
            this.color = color;
            this.expectResult=expectResult;
            this.anotherColor = anotherColor;
        }

        @Before
        public void setUp(){

            //szachownica
            board = new Board();

            //pionek
            Position position= new Position("d4");
            String color = "white";
            boolean isAlive = true;
            boolean hasMove = true;
            rook = new Rook(color, position, isAlive, hasMove, board);
            anotherPiece = new Rook(color, position, isAlive, hasMove, board);
        }

        @Parameterized.Parameters
        public static Collection params() {
            return Arrays.asList(new Object[][]{
                    //bicie prawidlowe
                    {new Position("a1"), new Position("a5"),"white","black",true},
                    {new Position("a1"), new Position("g1"),"black","white",true},
                    {new Position("a8"), new Position("a3"),"black","white",true},
                    {new Position("h1"), new Position("b1"),"white","black",true},
                    //bicie nieprawidlowe
                    {new Position("a1"), new Position("a4"),"white","white",false},
                    {new Position("a1"), new Position("g1"),"black","black",false},

            });
        }

        @Test

        public void testRookBeat(){

            rook.setPosition(from);
            rook.setColor(color);

            anotherPiece.setAlive(true);
            anotherPiece.setPosition(to);
            anotherPiece.setColor(anotherColor);

            boolean result = rook.beatMove(to);
            assertEquals(expectResult,result);
        }

    }