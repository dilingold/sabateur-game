package controller;

import java.util.Stack;

import model.Deck;
import model.cards.Card;
import model.cards.EndPathCard;
import model.cards.ExposeCard;
import model.cards.HeistCard;
import model.cards.LPathCard;
import model.cards.PowerToolCard;
import model.cards.RemoveToxicCard;
import model.cards.StraightPathCard;
import model.cards.TPathCard;
import model.cards.ToxicCard;
import model.cards.XPathCard;
import model.cards.RatInfestation;
import model.cards.RemoveRatInfestation;
import model.cards.RoadBlockCard;
import model.cards.RemoveRoadBlock;


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

	}

	public void addToxicCard() {

		for(int i = 0; i<numActionCards; i++) {
			ToxicCard toxicCard = new ToxicCard();
			Deck.getInstance().getDeck().push(toxicCard);

		}
	}

	public void addRemoveToxicCard() {

		for(int i = 0; i<numActionCards; i++) {
			RemoveToxicCard removeToxicCard = new RemoveToxicCard();
			Deck.getInstance().getDeck().push(removeToxicCard);

		}
	}

	public void addLPathCards() {

		for(int i = 0; i<numPathCards; i++) {

			LPathCard lPCard = new LPathCard(0);
			Deck.getInstance().getDeck().push(lPCard);

		}

	}

	public void addXPathCards() {

		for(int i = 0; i<numPathCards; i++) {

			XPathCard xPathCard = new XPathCard(0);
			Deck.getInstance().getDeck().push(xPathCard);

		}

	}

	public void addStraighPathCards() {

		for(int i = 0; i<numPathCards; i++) {

			StraightPathCard straightPathCard = new StraightPathCard(0);
			Deck.getInstance().getDeck().push(straightPathCard);

		}

	}

	public void addTPathCards() {

		for(int i = 0; i<numPathCards; i++) {

			TPathCard tPathCard = new TPathCard(0);
			Deck.getInstance().getDeck().push(tPathCard);

		}

	}

	public void addEndPathCards() {

		for(int i = 0; i<numPathCards; i++) {

			EndPathCard endPathCard = new EndPathCard(0);
			Deck.getInstance().getDeck().push(endPathCard);

		}

	}

	public void addHeistCards() {

		for(int i = 0; i<numPersonalCards; i++) {

			HeistCard heistCard = new HeistCard();
			Deck.getInstance().getDeck().push(heistCard);

		}

	}

	public void addExposeCard() {

		for(int i = 0; i<numPersonalCards; i++) {

			ExposeCard exposeCard = new ExposeCard();
			Deck.getInstance().getDeck().push(exposeCard);

		}

	}

	public void addSuperToolCard() {

		for(int i = 0; i<numPersonalCards; i++) {

			PowerToolCard superToolCard = new PowerToolCard();
			Deck.getInstance().getDeck().push(superToolCard);

		}

	}

	public void addRoadBlockCard() {

		for (int i = 0; i < numPersonalCards; i++) {

			RoadBlockCard floodCard = new RoadBlockCard();
			Deck.getInstance().getDeck().push(floodCard);

		}
	}

	public void addRemoveRoadBlockCard() {

		for (int i = 0; i < numPersonalCards; i++) {

			RemoveRoadBlock removeFlood = new RemoveRoadBlock();
			Deck.getInstance().getDeck().push(removeFlood);

		}
	}

	public void addRatInfestation() {

		for (int i = 0; i < numPersonalCards; i++) {

			RatInfestation ratInfestation = new RatInfestation();
			Deck.getInstance().getDeck().push(ratInfestation);

		}
	}

	public void addRemoveRatInfestation() {

		for (int i = 0; i < numPersonalCards; i++) {

			RemoveRatInfestation removeRatInfestation = new RemoveRatInfestation();
			Deck.getInstance().getDeck().push(removeRatInfestation);

		}
	}

	public void Shuffle() {

		Deck.getInstance().shuffle();

	}

	public Stack<Card> getDeck() {

		return Deck.getInstance().getDeck();

	}

	public void clearDeck() {

		Deck.getInstance().clearDeck();

	}

}
