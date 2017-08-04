

public class Pawn extends Piece { //jest to implementacja pozycji


    public Pawn(String color, Position position, boolean isAlive,
                boolean hasMove, Board board) {
        super(color, position, isAlive, hasMove, board);

    }

    /**/
    protected void setParamsAfterMove(Position destination) {
        this.position = destination;
        this.hasMove = true;
        this.board.getCell(destination).setPiece(this);
            }

    protected void setBeatenPieceParams(Position destination) {
        this.board.getCell(destination).getPiece().setAlive(false);
    }

    public boolean isDestinationFieldEmpty(Position destination) {
        return this.board.getCell(destination).getPiece() == null;
    }

    private  boolean getDestinationFieldColor(Position destination){
        return this.board.getCell(destination).getPiece().getColor() != this.color;
    }

    private boolean isMoveCorrect(Position destination) {
        if (this.position.getX() == destination.getX()) {
//dla białych
            if (this.color == "white") {
                //ruch o jeden
                if (this.position.getY() + 1 == destination.getY()) {
                    return isDestinationFieldEmpty(destination);
//ruch o dwa
                } else {
                    if (this.position.getY() + 2 == destination.getY() && !this.hasMove) {
                        return isDestinationFieldEmpty(destination) &&
                                isDestinationFieldEmpty(new
                                        Position(this.position.getX(), this.position.getY() + 1));
                    }
                }
//dla czarnych
            } else {
//ruch o jeden
                if (this.position.getY() - 1 == destination.getY()) {
                    return isDestinationFieldEmpty(destination);
                } else {
//ruch o dwa
                    if (this.position.getY() - 2 == destination.getY() && !this.hasMove) {
                        return isDestinationFieldEmpty(destination) &&
                                isDestinationFieldEmpty(new
                                        Position(this.position.getX(), this.position.getY() - 1));
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }



    private boolean isBeatCorrect(Position destination) {
        if (Math.abs(this.position.getX() - destination.getX()) == 1) { //brak nawiasu!!!!!!!!!!
            if (color == "white") {
                if (this.position.getY() + 1 == destination.getY() &&
                        !this.isDestinationFieldEmpty(destination)&&
//                        this.board.getCell(destination).getPiece() != null &&
//                        this.board.getCell(destination).getPiece().getColor() == "black"
                        this.getDestinationFieldColor(destination)) {
                    return true;
                }
            }
            else {
                if (this.position.getY() - 1 == destination.getY() &&
                        !this.isDestinationFieldEmpty(destination)&&
//                        this.board.getCell(destination).getPiece() != null &&
//                        board.getCell(destination).getPiece().getColor() == "white"
                        this.getDestinationFieldColor(destination)) {
                    return true;
                }
            }
        }
            else {
            return false;
        }
        return false;
    }

    @Override
    boolean move(Position destination) {
//ruch o jedno pole do przodu
        if (isMoveCorrect(destination)) {
//ustawianie parametrów po udanym ruchu
            setParamsAfterMove(destination);
            return true;
       //bicie
        } else if (isBeatCorrect(destination)) {
//ustawianie parametrów zbitej figury
            setBeatenPieceParams(destination);
//ustawianie parametrów po udanym ruchu
            setParamsAfterMove(destination);
            return true;
        } else {
            return false;
        }
    }


    public boolean isDestinationFieldColorDiffrent(Position destination) {

        return this.board.getCell(destination).getPiece().getColor()!=this.color;
    }
}




