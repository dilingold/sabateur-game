package model;

import java.util.HashMap;
import java.util.Map;

import model.cards.*;

public class CardPrototypeFactory {
    private static  Map<String, Card> prototypes = new HashMap<>();
    private static CardPrototypeFactory ourInstance = new CardPrototypeFactory();

    public static CardPrototypeFactory getInstance() {
        return ourInstance;
    }
    //upon creation puts a prototype of each card into the map
    private CardPrototypeFactory() {
        prototypes.put("lCard", new LPathCard(0));
        prototypes.put("xCard", new XPathCard(0));
        prototypes.put("straightCard", new StraightPathCard(0));
        prototypes.put("tCard", new TPathCard(0));
        prototypes.put("endCard", new EndPathCard(0));

        prototypes.put("toxicCard", new ToxicCard());
        prototypes.put("exposeCard", new ExposeCard());
        prototypes.put("superToolCard", new PowerToolCard());
        prototypes.put("heistCard", new HeistCard());
        prototypes.put("removeToxicCard", new RemoveToxicCard());

        prototypes.put("stoneCard", new StoneCard());
        prototypes.put("startCard", new StartCard());
        prototypes.put("goldCard", new GoldCard());
        // prototypes.put("switchTreasureCard", new switchTreasureCard());
        prototypes.put("emptyCard", new EmptyCard());
        prototypes.put("blockPathCard", new BlockPathCard(0));
        
        prototypes.put("roadBlockCard", new RoadBlockCard());
        prototypes.put("removeRoadBlockCard", new RemoveRoadBlock());
        prototypes.put("ratInfestationCard", new RatInfestation());
        prototypes.put("removeRatInfestationCard", new RemoveRatInfestation());
        prototypes.put("searchTreasureCard", new SearchTreasureCard());
        
    }
    /**
     * Get a copy of a protoype card
     * 
     * @pre.condition type must be existing in prototype map
     * @post.condition $return getType(Card)
     */
    public static Card getPrototype(String type) {
        try {
            Card myCard = prototypes.get(type).getCopy();
            return myCard;
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}
