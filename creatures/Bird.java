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
    protected String[] nameArray  = {"Scruffy", "Baldy", "Screech", "Skittles", "Samuel", "Dafny", "Kiwi", "Pepper"};

    /**
     * @brief By default, the name of the bird is chosen randomly from the proposed array of names
     * Birds are serious by default and have no incident.
     */
    public Bird(Teller teller){
        name = nameArray[(int) (Math.random() * nameArray.length)];
        this.teller = teller;
        mood = Mood.SERIOUS;
        incident = Incident.NONE;
    }

    /**
     * @brief The method sets a new name for the bird, which is different from the unwantedName
     * @param unwantedName - name that should be changed
     */
    public void setDifferentName(String unwantedName){
        do{
            name = nameArray[(int) (Math.random() * nameArray.length)];
        } while(name.matches(unwantedName));
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