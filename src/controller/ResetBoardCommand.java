package controller;
//concreate command
public class ResetBoardCommand implements Command{
    BoardBuilder boardBuilder;
    DeckFactory deckFactory;

    public ResetBoardCommand(BoardBuilder boardBuilder, DeckFactory deckFactory) {
        this.boardBuilder = boardBuilder;
        this.deckFactory = deckFactory;
    }

    public void execute() {
        boardBuilder.reset();
        deckFactory.reset();
        PlayerController.getInstance().clearPlayerHands();
        PlayerController.getInstance().dealPlayerHands();
    }
}
