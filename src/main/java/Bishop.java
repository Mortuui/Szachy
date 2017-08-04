

public class Bishop extends Piece {

    public Bishop(String color, Position position, boolean isAlive,
                  boolean hasMove, Board board) {
        super(color, position, isAlive, hasMove, board);
        // TODO Auto-generated constructor stub
    }

    boolean isBoardCellEmpty(Position position) {
        return board.getCell(position).getPiece() == null;
    }

    boolean areCellsEmpty(Position destination) {
        int orderX;
        int orderY;

        if (this.position.getX() <= destination.getX()) {
            orderX = 1;
        } else {
            orderX = -1;
        }

        if (this.position.getY() <= destination.getY()) {
            orderY = 1;
        } else {
            orderY = -1;
        }

        for (int i = 1; i < Math.abs(this.position.getX() - destination.getX()); i++) {
            int currentX = this.position.getX() + orderX * i;
            int currentY = this.position.getY() + orderY * i;
            if (!isBoardCellEmpty(new Position(currentX, currentY))) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean move(Position destination) {

        if (isMoveCorrect( destination) &&
                areCellsEmpty(destination) &&
                (!isBoardCellEmpty(destination) && this.board.getCell(destination).getPiece().getColor() != this.color) ||
                isBoardCellEmpty(destination) && areCellsEmpty(destination)) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            setParamsAfterMove(destination);
            setBeatenPieceParams(destination);

            return true;

        }else {
            if (isMoveCorrect(destination) &&
                    areCellsEmpty(destination) &&
                    isBoardCellEmpty(destination)) {
                return true;
            } else {
                return false;
            }
        }

    }

    private boolean isMoveCorrect(Position destination) {
        if (Math.abs(this.position.getX() - destination.getX()) ==
                Math.abs(this.position.getY() - destination.getY())) {
            return true;
        } else {

            return false;
//        }
        }
//
//    }
    }
    protected void setParamsAfterMove(Position destination) {
        this.position = destination;
        this.hasMove = true;
        this.board.getCell(destination).setPiece(this);
    }

    protected void setBeatenPieceParams(Position destination) {
        this.board.getCell(destination).getPiece().setAlive(false);
    }
}

