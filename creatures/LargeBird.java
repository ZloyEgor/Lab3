package creatures;
import enums.*;
import teller.Teller;

/**
 * Class of Large Birds from Wonderland
 */
public class LargeBird extends Bird {

    {
        if (this.getClass().getName().matches("creatures.LargeBird"))  teller.tell(updateMood(Mood.SERIOUS));
    }

    /**
     * @param teller - implementation of Teller Interface
     * @brief By default, the name of the bird is chosen randomly from the proposed array of names
     * Birds are serious by default and have no incident.
     */

    public LargeBird(Teller teller) {
        super(teller);
    }

    @Override
    public void takePartInFeast() {
        teller.tell(getName() + " took part in the feast");
        incident = Math.random() <= 0.75 ? Incident.COMPLAINING : Incident.SQUEAL;
        System.out.println(getName() + incident.getDescription());
        teller.tell(updateMood(Mood.OUTRAGED));
    }

    @Override
    public int hashCode() {
        int result = 13;
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
        if(!(obj instanceof LargeBird)){
            return false;
        }
        LargeBird bird = (LargeBird) obj;

        return (bird.mood == mood) && (getName().matches(bird.getName())) && (incident == bird.incident);
    }
}
