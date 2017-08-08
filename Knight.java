

public class Knight extends Piece {


    public Knight(String color, Position position, boolean isAlive,
                  boolean hasMove, Board board) {
        super(color, position, isAlive, hasMove, board);
    }

    @Override
    boolean move(Position destination) {
        if (isMoveCorect(destination) && board.getCell(destination).getPiece() == null){ //&&   //sprawdzamy czy pole na ktore ma sie poruszyc skoczek jest puste
            setParamsAfterMove(destination);                                                //ustalamy wartosc pola na ktore przemiescil sie skoczek
            return true;
        } else {
            return false;
        }
    }


    boolean beatMove(Position destination){
    if(isMoveCorect(destination) &&
            this.board.getCell(destination).getPiece().getColor() != this.color){       //sprawdzamy czy bita figura ma inny kolor
        setBeatenPieceParm(destination);                                                //ustawiamy parametry nowej figury na miejscu zbitego bierka
        return true;
    }else{
        if(isMoveCorect(destination) &&
                this.board.getCell(destination).getPiece().getColor() == this.color){
            return false;
        }
    } return false;
    }

    private void setParamsAfterMove(Position destination){
        this.position = destination;
        this.hasMove = true;
        this.board.getCell(destination).setPiece(this);
    }
    private void setBeatenPieceParm(Position destination){
        this.board.getCell(destination).getPiece().setAlive(false);
    }
    private boolean isMoveCorect(Position destination){
        if (this.position.getX() == destination.getX() - 1 && this.position.getY() == destination.getY() - 2 ||
                this.position.getX() == destination.getX() + 1 && this.position.getY() == destination.getY() + 2 ||
                this.position.getX() == destination.getX() - 2 && this.position.getY() == destination.getY() - 1 ||
                this.position.getX() == destination.getX() + 2 && this.position.getY() == destination.getY() + 1 ||
                this.position.getX() == destination.getX() - 1 && this.position.getY() == destination.getY() + 2 ||
                this.position.getX() == destination.getX() + 1 && this.position.getY() == destination.getY() - 2 ||
                this.position.getX() == destination.getX() - 2 && this.position.getY() == destination.getY() + 1 ||
                this.position.getX() == destination.getX() + 2 && this.position.getY() == destination.getY() - 1 ){
            return true;
        } else {
            return false;
        }
    }
}
