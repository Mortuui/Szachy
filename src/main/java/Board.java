

public class Board {


    public Board(){ //konstruktor planszy
        cells = new Cell [8][8];
        for (int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                cells[i][j]=new Cell(new Position(i,j)); //abu stworzyc komurke musimy ostworzyc nowa pozycje
            }
        }
    }

    private Cell [][] cells;
    private Piece[][] pieces;
    private String turn;


    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Piece[][] getPieces(Position from) {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }
    public Cell getCell(Position position){
        return cells[position.getX()][position.getY()];
    }

    public Piece getPiece(Position position){
        return this.getCell(position).getPiece();
    }

}
