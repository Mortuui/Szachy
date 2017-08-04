import javafx.geometry.Pos;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){  //konstruktor ktory inicjuje element z dwoma wartosciami
        this.x=x;
        this.y=y;
    }

    public Position(String position){
        this.setPosition(position);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPosition(String position){    //metoda dla zadanego stringa ustala pozycje x i y
        char xLetter = position.charAt(0);
        switch (xLetter){
            case 'a': { this.x=0; break;}
            case 'b': { this.x=1; break;}
            case 'c': { this.x=2; break;}
            case 'd': { this.x=3; break;}
            case 'e': { this.x=4; break;}
            case 'f': { this.x=5; break;}
            case 'g': { this.x=6; break;}
            case 'h': { this.x=7; break;}

        }
        this.y = Character.getNumericValue(position.charAt(1))-1;   //np C2 2 konwertujemy getNum... zwraca nam znak na pozycji jako int
    }

    public String getPositionsString (){
        String result = new String();
        switch (this.x){
            case 0: { result = "a";break;}
            case 1: { result = "b";break;}
            case 2: { result = "c";break;}
            case 3: { result = "d";break;}
            case 4: { result = "e";break;}
            case 5: { result = "f";break;}
            case 6: { result = "g";break;}
            case 7: { result = "h";break;}

        }
        result+=Integer.toString(this.y+1);
        return result;
    }

}
