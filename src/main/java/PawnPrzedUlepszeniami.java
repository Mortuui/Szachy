//
//
//
//public class PawnPrzedUlepszeniami extends Piece{
//
//
//
//    public PawnPrzedUlepszeniami(String color, Position position, boolean isAlive,
//                boolean hasMove, Board board) {
//        super(color, position, isAlive, hasMove, board);
//
//    }
//
//
//
//    @Override
//    boolean move(Position destination) {
//        //ruch o jedno pole do przodu
//        if(this.color == "white" && !this.hasMove &&
//                this.position.getX() == destination.getX() &&
//                this.position.getY() + 1 == destination.getY() &&
//                this.board.getCell(destination).getPiece() == null) {
//
//            //ustawianie parametrów po udanym ruchu
//            this.position = destination;
//            this.hasMove = true;
//            this.board.getCell(destination).setPiece(this);
//            return true;
//        } else {
//            //ruch o dwa pola do przodu
//            if(this.color == "white" && !this.hasMove &&
//                    this.position.getX() == destination.getX() &&
//                    this.position.getY() + 2 == destination.getY() &&
//                    this.board.getCell(destination).getPiece() == null &&
//                    this.board.getCell(new Position(this.position.getX(),
//                            this.position.getY()+1)).getPiece() == null) {
//
//                //ustawianie parametrów po udanym ruchu
//                this.position = destination;
//                this.hasMove = true;
//                this.board.getCell(destination).setPiece(this);
//                return true;
//            } else {
//                //bicie
//                if(this.color == "white" && Math.abs(this.position.getX() - destination.getX()) == 1 &&
//                        this.position.getY() + 1 == destination.getY() &&
//                        this.board.getCell(destination).getPiece() != null &&
//                        this.board.getCell(destination).getPiece().getColor() == "black") {
//
//                    //ustawianie parametrów zbitej figury
//                    this.board.getCell(destination).getPiece().setAlive(false);
//
//                    //ustawianie parametrów po udanym ruchu
//                    this.position = destination;
//                    this.hasMove = true;
//                    this.board.getCell(destination).setPiece(this);
//
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
//    }
//}
