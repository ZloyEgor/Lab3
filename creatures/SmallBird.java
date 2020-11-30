package creatures;
import enums.*;
import teller.Teller;

/**
 * Class of Small bird from Wonderland
 */
public class SmallBird extends Bird{

    /**
     * @param teller - implementation of Teller Interface
     * @brief By default, the name of the bird is chosen randomly from the proposed array of names
     * Birds are serious by default and have no incident.
     */
    public SmallBird(Teller teller) {
        super(teller);
    }

    @Override
    public void takePartInFeast() {
        teller.tell(getName() + " took part in the feast");
    }

    /**
     * @brief - Small birds may choke during tea drinking, in which case they need to be patted on the back
     * @param creature - patting creature
     */
    public void takePartInFeast(Creature creature){
        if(Math.random() <= 0.6){
            incident = Incident.CHOKE;
            teller.tell(getName() + incident.getDescription());
            teller.tell(creature.getName() +" patted on the back of " + getName() + " so he is fine");
        }
        else{
            incident = Incident.SQUEAK;
            teller.tell(getName() + incident.getDescription());
        }
        teller.tell(updateMood(Mood.CONFUSED));
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + name.hashCode();
        result = 31 * result + mood.getDescription().hashCode();
        result = 31 * result + incident.getDescription().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof SmallBird)){
            return false;
        }
        SmallBird bird = (SmallBird) obj;

        return (bird.mood == mood) && (getName().matches(bird.getName())) && (incident == bird.incident);
    }
}
