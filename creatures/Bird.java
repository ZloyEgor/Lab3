package creatures;
import enums.*;
import teller.Teller;

/**
 * Abstract class of wonderland birds
 */
public abstract class Bird implements Creature{
    /**
     * @param name - name
     * @param mood - mood, state of mind
     * @param incident - incidents, physical condition of the bird
     * @param teller - implementation of Teller Interface
     */
    protected String name;
    protected Mood mood;
    protected Incident incident;
    protected Teller teller;

    /**
     * @brief By default, the name of the bird is chosen randomly from the proposed array of names
     * Birds are serious by default and have no incident.
     */
    public Bird(Teller teller){
        String[] nameArray = {"Bubba", "Scruffy", "Baldy", "Screech", "Tweety", "Skittles", "Jojo", "Samuel", "Dafny", "Lulza", "Kiwi", "Pepper", "Harley"};
        name = nameArray[(int) (Math.random() * 13)];
        this.teller = teller;
        incident = Incident.NONE;
    }


    @Override
    public String updateMood(Mood mood) {
        return getName() + mood.getDescription();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return  "Creatures.Bird from Wonderland" +
                "\nName: " + getName() +
                "\nType: " + this.getClass().getName() +
                "\nEnums.Mood: " + mood.getDescription() +
                "\nWhat incident happened: " + incident.getDescription();
    }
}