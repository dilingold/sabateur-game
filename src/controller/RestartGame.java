package controller;


public class RestartGame {
    private Reset board;
    private Reset deck;

    public RestartGame() {
        board = new BoardBuilder();
        deck = new DeckFactory();
    }

    public void restartBoard() {
        board.reset();
    }

    public void restartDeck() {
        deck.reset();
    }

    public void restartPlayer() {
        PlayerController.getInstance().reset();
    }
}
