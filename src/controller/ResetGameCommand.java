package controller;

//concreate command
public class ResetGameCommand implements Command{
    BoardBuilder boardBuilder;
    DeckFactory deckFactory;

    public ResetGameCommand(BoardBuilder boardBuilder, DeckFactory deckFactory) {
        this.boardBuilder = boardBuilder;
        this.deckFactory = deckFactory;
    }

    public void execute() {
        boardBuilder.reset();
        deckFactory.reset();
        PlayerController.getInstance().clearPlayerHands();
        PlayerController.getInstance().dealPlayerHands();
        GameEngine.setCurrentPlayerIndex(0);
        Winner.getInstance().setWinner(false);
    }
}
