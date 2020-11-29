package events;

import creatures.Alice;
import creatures.Bird;
import creatures.Dodo;
import creatures.LargeBird;
import creatures.SmallBird;
import teller.Teller;
import java.util.Arrays;

/**
 * Awarding in the Wonderland
 */
public class Awarding implements Event {

    /**
     * @param alice - Alice
     * @param birds - Array of Birds
     * @param teller - implementation of Teller Interface
     */
    private Alice alice;
    private Bird[] birds;
    private final Teller teller;

    /**
     * @brief constructor
     * @param teller - implementation of Teller Interface
     * @param needToInitializeParticipants - do we need to initialize participants?
     */
    public Awarding(Teller teller, boolean needToInitializeParticipants) {
        this.teller = teller;
        if(needToInitializeParticipants)
            initializeParticipants(teller);
    }

    @Override
    public void initializeParticipants(Teller teller) {
        alice = new Alice(teller);
        birds = new Bird[5];
        for(int i = 0; i < 5; i++){
            if(i == 0) birds[i] = new Dodo(teller);
            else if (i < 3) birds[i] = new LargeBird(teller);
            else birds[i] = new SmallBird(teller);
        }
    }

    @Override
    public void performEvent(String introduction) {
        teller.tell(introduction);
        ((Dodo)birds[0]).makeSpeech();
        alice.receiveThimble((Dodo)birds[0]);
    }

    @Override
    public String getInformationAboutEvent() {
        return "Awarding in the Wonderland";
    }

    @Override
    public Alice getAlice() {
        return alice;
    }

    @Override
    public Bird[] getBirds() {
        return birds;
    }

    @Override
    public void setParticipants(Alice alice, Bird[] birds) {
        this.alice = alice;
        this.birds = birds;
    }

    @Override
    public int hashCode() {
        return 13 * alice.hashCode() * birds[0].hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Awarding)){
            return false;
        }
        Awarding awarding = (Awarding) obj;

        return alice.equals(awarding.getAlice()) && Arrays.equals(birds, awarding.getBirds());
    }

    @Override
    public String toString() {
        return getInformationAboutEvent();
    }
}
