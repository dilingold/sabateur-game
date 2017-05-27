package controller;

public class Winner {

    private static final Winner instance = new Winner();
    Boolean winner = false;

    private Winner(){}

    public static Winner getInstance(){
        return instance;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
