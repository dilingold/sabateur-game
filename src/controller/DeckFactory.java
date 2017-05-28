package controller;

import java.util.Stack;

import model.CardPrototypeFactory;
import model.Deck;
import model.cards.Card;
import model.cards.EndPathCard;
import model.cards.LPathCard;
import model.cards.StraightPathCard;
import model.cards.TPathCard;
import model.cards.ToxicCard;

public class DeckFactory implements Reset {

    private int numPathCards = 10;
    private int numPersonalCards = 5;
    private int numActionCards = 10;

    public void reset() {
        addAllCards();
        Shuffle();
    }

    public void addAllCards() {

        addEndPathCards();
        addLPathCards();
        addStraighPathCards();
        addTPathCards();
        addXPathCards();
        addHeistCards();
        addExposeCard();
        addToxicCard();
        addSuperToolCard();
        addRemoveToxicCard();
        addRoadBlockCard();
        addRemoveRoadBlockCard();
        addRatInfestation();
        addRemoveRatInfestation();
        addSearchTreasureCard();
    }

    public void addToxicCard() {

        for (int i = 0; i < numActionCards; i++) {
            ToxicCard toxicCard = (ToxicCard) CardPrototypeFactory.getPrototype("toxicCard");
            Deck.getInstance();
            Deck.getDeck().push(toxicCard);
        }
    }

    public void addRemoveToxicCard() {

        for (int i = 0; i < numActionCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("removeToxicCard"));
        }
    }

    public void addHeistCards() {
        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("heistCard"));
        }
    }

    public void addExposeCard() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("exposeCard"));
        }

    }

    public void addSuperToolCard() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("superToolCard"));
        }

    }

    public void addXPathCards() {

        for (int i = 0; i < numPathCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("xCard"));
        }

    }

    public void addLPathCards() {

        for (int i = 0; i < numPathCards; i++) {
            LPathCard lPCard = new LPathCard(0);
            Deck.getInstance();
            Deck.getDeck().push(lPCard);
        }

    }

    public void addStraighPathCards() {

        for (int i = 0; i < numPathCards; i++) {
            StraightPathCard StraightCard = new StraightPathCard(0);
            Deck.getInstance();
            Deck.getDeck().push(StraightCard);
        }

    }

    public void addTPathCards() {

        for (int i = 0; i < numPathCards; i++) {
            TPathCard tCard = new TPathCard(0);
            Deck.getInstance();
            Deck.getDeck().push(tCard);
        }

    }

    public void addEndPathCards() {
        for (int i = 0; i < numPathCards; i++) {
            EndPathCard endCard = new EndPathCard(0);
            Deck.getInstance();
            Deck.getDeck().push(endCard);
        }
    }

    public void addRoadBlockCard() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("roadBlockCard"));
        }
    }

    public void addRemoveRoadBlockCard() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("removeRoadBlockCard"));
        }
    }

    public void addRatInfestation() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("ratInfestationCard"));
        }
    }

    public void addRemoveRatInfestation() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("removeRatInfestationCard"));
        }
    }

    public void addSearchTreasureCard() {

        for (int i = 0; i < numPersonalCards; i++) {
            Deck.getInstance();
            Deck.getDeck().push(CardPrototypeFactory.getPrototype("searchTreasureCard"));
        }
    }

    public void Shuffle() {

        Deck.getInstance().shuffle();

    }

    public Stack<Card> getDeck() {

        Deck.getInstance();
        return Deck.getDeck();

    }

}
