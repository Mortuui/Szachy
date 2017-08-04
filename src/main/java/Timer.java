


public class Timer {

    private int whiteTime;
    private int blackTime;


    public int getTime(String color){
        if(color == "white"){
            return whiteTime;
        }else{
            return blackTime;
        }
    }

    public int getWhiteTime() {
        return whiteTime;
    }

    public void setWhiteTime(int whiteTime) {
        this.whiteTime = whiteTime;
    }

    public int getBlackTime() {
        return blackTime;
    }

    public void setBlackTime(int blackTime) {
        this.blackTime = blackTime;
    }

    public void startWhiteTime(){

    }

    public void startBlackTime(){

    }
    public void stopWhiteTime(){

    }
    public void stopBlackTime(){

    }
}
