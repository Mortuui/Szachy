

public class Player {

    private String color;
    private Board board;
    private Timer timer;


    public Player(String color, Board board, Timer timer) {
        this.color = color;
        this.board = board;
        this.timer = timer;
    }

    public boolean doMove(Position from, Position to) {

        if (board.getPieces(from) != null &&
            board.getPiece(from).getColor() == this.color &&
            board.getTurn() == this.color &&
            this.timer.getTime(color) > 0 &&
            board.getPiece(from).move(to)) {
            return true;
        } else {
            return false;
        }
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
