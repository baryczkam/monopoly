package Monopoly.Board;

import Monopoly.Player.PlayerInterface;
import Monopoly.SpecialCard.Status;

public class JailField extends SpecialField{
    private int stayTime;
    private int HowLong;
    private Status status;

    public JailField(int fieldIndex, int stayTime, int howLong, Status status) {
        super(fieldIndex);
        this.stayTime = stayTime;
        HowLong = howLong;
        this.status = status;
    }

    public int getStayTime() {
        return stayTime;
    }

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }

    public int getHowLong() {
        return HowLong;
    }

    public void setHowLong(int howLong) {
        HowLong = howLong;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean tryToLeaveJail(){
        return true;
    }
    public void setCurrentField(){

    }
    public void addPlayerToJail(){

    }
    public void removePlayerFromJail(){

    }
    public void howLongPresent(){

    }
}
