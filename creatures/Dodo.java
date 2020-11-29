package creatures;
import enums.*;
import teller.Teller;

/**
 * Class of Dodo from Wonderland
 */
public class Dodo extends LargeBird {
    /**
     * @param doesHaveTheThimble - does Dodo have the thimble?
     */
    private boolean doesHaveTheThimble;

    /**
     * @brief By default, Dodo is serious, has no incidents, but has the thimble
     * @param teller - implementation of Teller Interface
     */
    public Dodo(Teller teller) {
        super(teller);
        name = "Dodo";
        teller.tell(updateMood(Mood.SERIOUS));
        incident = Incident.NONE;
        doesHaveTheThimble = true;
    }

    /**
     * @brief Dodo makes a speech in honor of Alice
     */
    public void makeSpeech(){
        teller.tell(getName() + " made a speech in honor of Alice");
    }

    /**
     * @brief Dodo gives Alice the thimble
     * @param alice - Alice which receive the thimble from Dodo
     */
    public void giveThimble(Alice alice){
        if(doesHaveTheThimble) {
            doesHaveTheThimble = false;
            teller.tell(getName() + " gave the Thimble to " + alice.getName());
        }
    }

    @Override
    public void takePartInFeast() {
        teller.tell(getName() + " took part in the feast");
        teller.tell(updateMood(Mood.GLAD));

    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + name.hashCode();
        result = 31 * result + mood.getDescription().hashCode();
        result = 31 * result + incident.getDescription().hashCode();
        result = 31 * result + Integer.hashCode(doesHaveTheThimble ? 13 : 3);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Dodo)){
            return false;
        }
        Dodo bird = (Dodo) obj;

        return (bird.mood == mood) && (getName().matches(bird.getName())) && (doesHaveTheThimble == bird.doesHaveTheThimble) && (incident == bird.incident);
    }

    @Override
    public String toString() {
        return  "Dodo from Wonderland" +
                "\nType: " + this.getClass().getSuperclass().getName() +
                "\nHas the thimble: " + doesHaveTheThimble +
                "\nEnums.Mood: " + mood.getDescription() +
                "\nWhat incident happened: " + incident.getDescription();
    }
}