package creatures;
import enums.*;
import teller.Teller;

/**
 * Class of Alice from Wonderland
 */
public class Alice implements Creature{
    /**
     * @param name - name of Alice
     * @param mood - mood, state of mind
     * @param doesHaveTheThimble - does Alice have the thimble?
     * @param teller - implementation of Teller Interface
     */
    public final String name = "Alice";
    private Mood mood;
    private boolean doesHaveTheThimble;
    private final Teller teller;

    /**
     * @brief By default, Alice can hardly hold back her laughter, she does not have a thimble
     * @param teller - implementation of Teller Interface
     */
    public Alice(Teller teller){
        this.teller = teller;
        teller.tell(updateMood(Mood.HOLDING_LAUGH));
        doesHaveTheThimble = false;
    }

    /**
     * @param dodo - Dodo, from which Alice takes the thimble
     * @brief Alice takes the thimble from Dodo
     */
    public void receiveThimble(Dodo dodo){
        if(!doesHaveTheThimble) {
            reverence();
            dodo.giveThimble(this);
            doesHaveTheThimble = true;
            teller.tell(name + " received the thimble from Dodo");
            beGrateful();
        }
    }

    /**
     * @brief Alice bows
     */
    private void reverence(){
        teller.tell(name + " bowed with thankfulness");
        beSerious();
    }

    /**
     * @brief Alice becomes grateful
     */
    private void beGrateful(){
        teller.tell(updateMood(Mood.GRATEFUL));

    }

    /**
     * @brief Alice gets serious
     */
    private void beSerious(){
        teller.tell(updateMood(Mood.SERIOUS));
    }

    /**
     * @brief Alice becomes joyful
     */
    private void beGlad(){
        teller.tell(updateMood(Mood.GLAD));
    }

    @Override
    public void takePartInFeast() {
        teller.tell(name + " took part in the feast");
        beGlad();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String updateMood(Mood mood){
        this.mood = mood;
        return name + this.mood.getDescription();
    }

    @Override
    public String toString(){
        return  "Alice from Wonderland" +
                "\nHas the thimble: " + doesHaveTheThimble +
                "\nEnums.Mood:" + mood.getDescription();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + mood.getDescription().hashCode();
        result = 31 * result + Integer.hashCode(doesHaveTheThimble ? 12 : 5);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Alice)){
            return false;
        }
        Alice alice = (Alice) obj;
        return (alice.doesHaveTheThimble == doesHaveTheThimble) && (alice.mood == mood);
    }
}