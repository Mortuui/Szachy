import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


    @RunWith(Parameterized.class)
    public class BishopBeatTest {

        private  Board board;
        private  Bishop bishop;
        private Position from;
        private Position to;
        private boolean expectResult;
        private String color;
        private String anotherColor;
        private  Bishop anotherBishop;

        public BishopBeatTest(Position from, Position to,String color,String anotherColor, boolean expectResult){
            this.from=from;
            this.to=to;
            this.color = color;
            this.anotherColor = anotherColor;
            this.expectResult = expectResult;
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
            return Arrays.asList(new Object[][]{
                    //bicie prawidlowe
                    {new Position("a1"), new Position("b2"),"white","black",true},
                    {new Position("c2"), new Position("b1"),"black","white",true},
                    {new Position("d4"), new Position("e3"),"black","white",true},
                    {new Position("d4"), new Position("c5"),"white","black",true},
                    //bicie nieprawidlowe
                    {new Position("c1"), new Position("e4"),"black","black",false},
                    {new Position("d4"), new Position("a1"),"white","white",false},

            });
        }


        @Test
        public void testBishopMove(){
            //ustalamy kolor i pozycje gonca
            bishop.setPosition(from);
            bishop.setColor(color);
            //ustalamy kolor i pozycje drugiegej figury
            anotherBishop.setPosition(to);
            anotherBishop.setColor(anotherColor);


            boolean result = bishop.move(to);

            assertEquals(expectResult,result);

        }

    }

