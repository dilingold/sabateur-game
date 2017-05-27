package model;

import java.util.HashMap;
import java.util.Map;

import model.cards.BlockPathCard;
import model.cards.BombCard;
import model.cards.Card;
import model.cards.DestroyToolsCard;
import model.cards.EmptyCard;
import model.cards.EndPathCard;
import model.cards.ExposeCard;
import model.cards.FixToolsCard;
import model.cards.GoldCard;
import model.cards.HeistCard;
import model.cards.LPathCard;
import model.cards.PowerToolCard;
import model.cards.RemoveToxicCard;
import model.cards.StartCard;
import model.cards.StoneCard;
import model.cards.StraightPathCard;
import model.cards.TPathCard;
import model.cards.ToxicCard;
import model.cards.XPathCard;
import model.cards.RoadBlockCard;
import model.cards.RemoveRoadBlock;
import model.cards.RatInfestation;
import model.cards.RemoveRatInfestation;

public class CardPrototypeFactory {
    private static final Map<String, Card> prototypes = new HashMap<>();
    private static CardPrototypeFactory ourInstance = new CardPrototypeFactory();

    public static CardPrototypeFactory getInstance() {
        return ourInstance;
    }

    


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
        prototypes.put("fixToolsCard", new FixToolsCard());
        prototypes.put("emptyCard", new EmptyCard());
        prototypes.put("destroyToolsCard", new DestroyToolsCard());
        prototypes.put("bombCard", new BombCard());
        prototypes.put("blockPathCard", new BlockPathCard(0));
        
        prototypes.put("roadBlockCard", new RoadBlockCard());
        prototypes.put("removeRoadBlockCard", new RemoveRoadBlock());
        prototypes.put("ratInfestationCard", new RatInfestation());
        prototypes.put("removeRatInfestationCard", new RemoveRatInfestation());
        

        /*
         * LPathCard lPCard = new LPathCard(0); XPathCard xCard = new
         * XPathCard(0); StraightPathCard straightCard = new
         * StraightPathCard(0); TPathCard tPathCard = new TPathCard(0);
         * EndPathCard endCard = new EndPathCard(0);
         * 
         * ToxicCard toxicCard = new ToxicCard(); ExposeCard exposeCard = new
         * ExposeCard(); PowerToolCard superToolCard = new PowerToolCard();
         * HeistCard heistCard = new HeistCard(); RemoveToxicCard
         * removeToxicCard = new RemoveToxicCard();
         * 
         * StoneCard stoneCard = new StoneCard(); StartCard startCard = new
         * StartCard(); GoldCard goldCard = new GoldCard(); //SwitchTreasureCard
         * switchTreasureCard = new switchTreasureCard(); FixToolsCard
         * fixToolsCard = new FixToolsCard(); EmptyCard emptyCard = new
         * EmptyCard(); DestroyToolsCard destroyToolsCard = new
         * DestroyToolsCard(); BombCard bombCard = new BombCard(); 
         * BoardCard boardCard = new BoardCard(); 
         * BlockPathCard blockPathCard = new BlockPathCard();
         */
    }
    public static Card getPrototype(String type) {
        try {
            return prototypes.get(type).getCopy();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}
