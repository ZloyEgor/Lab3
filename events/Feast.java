package events;

import creatures.Alice;
import creatures.Bird;
import creatures.Dodo;
import creatures.LargeBird;
import creatures.SmallBird;
import enums.Mood;
import teller.Teller;
import java.util.Arrays;

/**
 * Tea party in wonderland
 */
public class Feast implements Event{
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
    public Feast(Teller teller, boolean needToInitializeParticipants) {
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
        if (birds[1].hashCode() == birds[2].hashCode()){
            birds[1].setDifferentName(birds[2].getName());
        }
        if (birds[3].hashCode() == birds[4].hashCode()){
            birds[3].setDifferentName(birds[4].getName());
        }
        for(Bird bird: birds){
            teller.tell(bird.updateMood(Mood.SERIOUS));
        }
    }

    @Override
    public void performEvent(String introduction) {
        teller.tell(introduction);
        alice.takePartInFeast();
        for(Bird bird : birds) {
            bird.takePartInFeast();
            if(bird.getClass().getName().matches("creatures.SmallBird")) ((SmallBird)bird).takePartInFeast(alice);
        }
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
    public String getInformationAboutEvent() {
        return "Feast in the Wonderland";
    }

    @Override
    public int hashCode() {
        return 17 * alice.hashCode() * birds[0].hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Feast)){
            return false;
        }
        Feast feast = (Feast) obj;

        return alice.equals(feast.getAlice()) && Arrays.equals(birds, feast.getBirds());
    }

    @Override
    public String toString() {
        return getInformationAboutEvent();
    }
}
