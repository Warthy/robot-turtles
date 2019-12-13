package fr.isep.robotturtles;

import fr.isep.robotturtles.constants.CardType;
import fr.isep.robotturtles.constants.ObstacleType;
import fr.isep.robotturtles.constants.Orientation;
import fr.isep.robotturtles.constants.PlayerColor;
import fr.isep.robotturtles.tiles.ObstacleTile;

import java.util.*;

public class Player implements Pawn {
    private Card[] deck = new Card[5];
    private LinkedList<Card> stack;
    private ObstacleTile[] obstacleDeck = new ObstacleTile[5];
    private Boolean hasUsedBug = false;
    private List<Card> instructionsList;
    private PlayerColor color;
    private Orientation orientation;

    Player(PlayerColor color){
        this.color = color;
        generatePlayer();
    }

    void generatePlayer(){
        stack = new LinkedList<>();
        stack.addAll(Collections.nCopies(18, new Card(CardType.BLUE)));
        stack.addAll(Collections.nCopies(8, new Card(CardType.YELLOW)));
        stack.addAll(Collections.nCopies(8, new Card(CardType.PURPLE)));
        stack.addAll(Collections.nCopies(3, new Card(CardType.LASER)));
        Collections.shuffle(stack);

        Arrays.fill(obstacleDeck, 0, 2, new ObstacleTile(ObstacleType.STONE_WALL));
        Arrays.fill(obstacleDeck, 3, 4, new ObstacleTile(ObstacleType.ICE_WALL));
    }

    void draw(){
        for(int i = 0; i<deck.length; i++){
            if(deck[i] == null){
               deck[i] = stack.poll();
            }
        }
    }


    public Card[] getDeck() {
        return deck;
    }

    public List<Card> getStack() {
        return stack;
    }

    public ObstacleTile[] getObstacleDeck() {
        return obstacleDeck;
    }

    public void setObstacleDeck(ObstacleTile[] obstacleDeck) {
        this.obstacleDeck = obstacleDeck;
    }

    public Boolean getHasUsedBug() {
        return hasUsedBug;
    }

    public void setHasUsedBug(Boolean hasUsedBug) {
        this.hasUsedBug = hasUsedBug;
    }

    public List<Card> getInstructionsList() {
        return instructionsList;
    }

    public void setInstructionsList(List<Card> instructionsList) {
        this.instructionsList = instructionsList;
    }

    public PlayerColor getColor() {
        return color;
    }

    public void setColor(PlayerColor color) {
        this.color = color;
    }

    public void addInstruction(Card instruction){

    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}