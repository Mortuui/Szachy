

public class Rook extends Piece {

    public Rook(String color, Position position,
                boolean isAlive, boolean hasMove, Board board) {
        super(color, position, isAlive, hasMove, board);
    }

    boolean isBoardCellEmpty(Position position) {
        return board.getCell(position).getPiece() == null;
    }

    boolean areCellsEmpty(Position destination) {

        if (this.position.getX() == destination.getX()) {
            int orderX;
            if (this.position.getX() < destination.getX()) {
                orderX = 1;
                if (this.position.getX() > destination.getX()) {
                    orderX = -1;
                }
                for (int i = 1; i < Math.abs(this.position.getX() - destination.getX()); i++) {
                    int currentX = this.position.getX() + orderX * i;
                    if (isBoardCellEmpty(new Position(currentX, destination.getY()))) {
                        return true;
                    }
                }
                return true;
            } else if (this.position.getY() == destination.getY()) {
                int orderY;
                if (this.position.getY() < destination.getY()) {
                    orderY = 1;

                    if (this.position.getY() > destination.getY()) {
                        orderY = -1;
                    }
                    for (int i = 1; i < Math.abs(this.position.getY() - destination.getY()); i++) {
                        int currentY = this.position.getY() + orderY * i;
                        if (isBoardCellEmpty(new Position(destination.getX(), currentY))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }


    @Override
    boolean move(Position destination) {
        if (isMoveCorect(destination) &&
                        areCellsEmpty(destination) && isBoardCellEmpty(destination)) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            setParamsAfterMove(destination);

            return true;

        } else {
            if (isMoveCorect(destination) &&
                            (isBoardCellEmpty(destination) && areCellsEmpty(destination))) {

                return true;
            } else {
                return false;
            }
        }
    }

    boolean beatMove(Position destination) {

        if (isMoveCorect(destination) &&
                        areCellsEmpty(destination) && this.board.getCell(destination).getPiece().getColor() != this.color) {
            setBeatenPieceParams(destination);
            return true;
        } else {

            if (isMoveCorect(destination) &&
                            !isBoardCellEmpty(destination) ||
                    !areCellsEmpty(destination) && this.board.getCell(destination).getPiece().getColor() == this.color) {
                return false;
            }
        }
        return false;
    }


        private void setParamsAfterMove(Position destination){
            this.position = destination;
            this.hasMove = true;
            this.board.getCell(destination).setPiece(this);
        }
        private void setBeatenPieceParams(Position destination){
            this.board.getCell(destination).getPiece().setAlive(false);
        }
        private  boolean isMoveCorect(Position destination) {
            if(this.position.getX() == destination.getX() && this.position.getY() != destination.getY() ||
               this.position.getX() != destination.getX() && this.position.getY() == destination.getY()) {
                return true;
            }else{
                return false;
            }
        }
    }

