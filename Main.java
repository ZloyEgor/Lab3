import events.Awarding;
import events.Feast;
import teller.StoryTeller;

/**
 * Main class of the program
 */
public class Main {
    /**
     * main method which contains execution of program
     */
    public static void main(String[] args){
        StoryTeller storyTeller = new StoryTeller();
        Awarding awarding = new Awarding(storyTeller, true);
        awarding.performEvent("\t@The ceremony of awarding has started!@");
        Feast feast = new Feast(storyTeller, false);
        feast.setParticipants(awarding.getAlice(), awarding.getBirds());
        feast.performEvent("\t@The feast has started!@");
    }

    @Override
    public String toString() {
        return "Main class of program";
    }
}
