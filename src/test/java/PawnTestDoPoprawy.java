//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//
//public class PawnTestDoPoprawy {
//
//    private Board board;
//    private Pawn whitePawn;
//    private Pawn blackPawn;
//
//    @Before
//    public void SetUp() {
//
//        //inicjacja planszy
//        board = new Board();
//        //inicjacja czarnego pionka zywego nie ruszanego na pozycji startowej c7
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//        blackPawn = new Pawn(color, position, isAlive, hasMOve, board);
//        //inicjacja bialego pionka zywego nie ruszanego na pozycji startowej d2
//         position = new Position("d2");
//         color = "white";
//         isAlive = true;
//         hasMOve = false;
//        whitePawn = new Pawn(color, position, isAlive, hasMOve, board);
//    }
//
//
//    //DLA CZARNYCH PIONKOW
//    @Test
//    public void testBlackPawnOneStep() {
//
//        Board board = new Board(); //jest w SetUp
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        boolean moveResult = pawn.move(new Position("c6"));
//
//        assertEquals(true, moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("c6", positionString);
//        assertTrue(pawn.isHasMove());
//    }
//
//    @Test
//    public void testBlackNotMovePawnToStepSucces() {
//
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        boolean moveResult = pawn.move(new Position("c6"));
//
//        assertEquals(true, moveResult); //sprawdzamy czy asercja zwrocila true
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("c6", positionString);
//        assertTrue(pawn.isHasMove());
//
//    }
//
//    @Test
//    public void testBlackNotMovePawnToStepFailure() {
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = true;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve,board);
//
//        boolean moveResult = pawn.move(new Position("d7"));
//
//        assertFalse( moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("c7", positionString);
//        assertFalse(pawn.isHasMove());
//
//    }
//
//    @Test
//    public void testBlackNotMovePawnOneStepBeatSucces() {
//
//        Board board = new Board(); //jest w SetUp
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        //figura do bicia
//        Position position2 = new Position("b6");
//        String color2 = "white";
//        boolean isAlive2 = true;
//        boolean hasMove2 = false;
//
//        Pawn pawn2 = new Pawn(color2, position2, isAlive2, hasMove2, board);
//
//        boolean moveResult = pawn.move(new Position("b6"));
//
//        assertEquals(true, moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("b6", positionString);
//        assertTrue(pawn.isHasMove());
//
//        //speawdzanie zbitego pionka
//        String positionString2 = pawn2.getPosition().getPositionsString();
//        assertEquals("", positionString2);
//        assertFalse(pawn2.isAlive());
//    }
//
//    @Test
//    public void testBlackNotMovePawnOneStepBeatFailuer() {
//
//        Board board = new Board(); //jest w SetUp
//        Position position = new Position("c7");
//        String color = "black";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        //figura do bicia
//        Position position2 = new Position("b6");
//        String color2 = "white";
//        boolean isAlive2 = true;
//        boolean hasMove2 = true;
//
//        Pawn pawn2 = new Pawn(color2, position2, isAlive2, hasMove2, board);
//
//        boolean moveResult = pawn.move(new Position("b6"));
//
//        assertEquals(false, moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("c7", positionString);
//        assertFalse(pawn.isHasMove());
//
//        //speawdzanie zbitego pionka
//        String positionString2 = pawn2.getPosition().getPositionsString();
//        assertEquals("b6", positionString2);
//        assertTrue(pawn2.isAlive());
//    }
//
//    //DLA BIALYCH PIONKOW
//
//    @Test
//    public void testWhitePawnOneStep() {
//
//        Board board = new Board(); //jest w SetUp
//        Position position = new Position("d2");
//        String color = "white";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        boolean moveResult = pawn.move(new Position("d3"));
//
//        assertEquals(true, moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("d3", positionString);
//        assertTrue(pawn.isHasMove());
//    }
//
//    @Test
//    public void testWhiteNotMovePawnTwoStepSucces() {
//
//        boolean moveResult = whitePawn.move(new Position("d4"));
//
////        Position position = new Position("d2");
////        String color = "white";
////        boolean isAlive = true;
////        boolean hasMOve = false;
////        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        assertEquals(true, moveResult); //sprawdzamy czy asercja zwrocila true
//        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("d4", positionString);
//        assertTrue(whitePawn.isHasMove());
//
//    }
//
//    @Test
//    public void testWhiteNotMovePawnTwoStepFailure() {
//
//        //ustalamy czy wczesniej wykonal ruch
//        whitePawn.setHasMove(true);
//        boolean moveResult = whitePawn.move(new Position("d4"));
//
////        Position position = new Position("d3");
////        String color = "white";
////        boolean isAlive = true;
////        boolean hasMOve = true;
////
////        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
////        boolean moveResult = whitePawn.move(new Position("d4"));
//
//        assertFalse( moveResult);
//        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("d2", positionString);
//       // assertFalse(whitePawn.isHasMove());
//
//    }
//
//    @Test
//    public void testWhiteNotMovePawnOneStepBeatSucces() {
//
//        //czarny pionek jako figura do bicia
//
//
////        Board board = new Board(); //jest w SetUp
////        Position position = new Position("d2");
////        String color = "white";
////        boolean isAlive = true;
////        boolean hasMOve = false;
////        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        //ustawienia dla bitego pionka
//        blackPawn.setPosition(new Position("c3"));
//        blackPawn.setHasMove(true);
////        Position position2 = new Position("c3");
////        String color2 = "black";
////        boolean isAlive2 = true;
////        boolean hasMove2 = false;
////        Pawn pawn2 = new Pawn(color2, position2, isAlive2, hasMove2, board);
//
//        boolean moveResult = blackPawn.move(new Position("c3"));
//
//        assertEquals(true, moveResult);
//        String positionString = whitePawn.getPosition().getPositionsString();
//        assertEquals("c3", positionString);
//        assertTrue(whitePawn.isHasMove());
//
//        //speawdzanie zbitego pionka
//        String positionString2 = blackPawn.getPosition().getPositionsString();
//        assertEquals("", positionString2);
//        assertFalse(blackPawn.isAlive());
//    }
//
//    @Test
//    public void testWhiteNotMovePawnOneStepBeatFailuer() {
//
//        Board board = new Board(); //jest w SetUp
//        Position position = new Position("d2");
//        String color = "white";
//        boolean isAlive = true;
//        boolean hasMOve = false;
//
//        Pawn pawn = new Pawn(color, position, isAlive, hasMOve, board);
//
//        //figura do bicia
//        Position position2 = new Position("e3");
//        String color2 = "black";
//        boolean isAlive2 = true;
//        boolean hasMove2 = true;
//
//        Pawn pawn2 = new Pawn(color2, position2, isAlive2, hasMove2, board);
//
//        boolean moveResult = pawn.move(new Position("e3"));
//
//        assertEquals(false, moveResult);
//        String positionString = pawn.getPosition().getPositionsString();
//        assertEquals("d2", positionString);
//        assertFalse(pawn.isHasMove());
//
//        //speawdzanie zbitego pionka
//        String positionString2 = pawn2.getPosition().getPositionsString();
//        assertEquals("e3", positionString2);
//        assertTrue(pawn2.isAlive());
//    }
//}