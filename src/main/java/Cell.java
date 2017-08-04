

public class Cell {

    private Position position;
    private Piece piece;

    public Cell(Position position){
        this.position=position;
    }
    public Cell (Position position, Piece piece){
        this.position=position;
        this.piece=piece;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
