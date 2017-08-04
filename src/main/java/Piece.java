

public abstract class Piece {
    protected String color;
    protected Position position;
    protected boolean isAlive;
    protected boolean hasMove;
    protected Board board;

    public Piece(String color, Position position, boolean isAlive, boolean hasMove, Board board) {
        this.color = color;
        this.position = position;
        this.isAlive = isAlive;
        this.hasMove = hasMove;
        this.board= board;
        this.board.getCell(position).setPiece(this);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    abstract boolean move (Position position);

    public boolean isHasMove() {
        return hasMove;
    }

    public void setHasMove(boolean hasMove) {
        this.hasMove = hasMove;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.board.getCell(position).setPiece(this); //musimy wrzucic do konstruktora aby ustawic pozycje
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
