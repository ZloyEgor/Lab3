package events;
import com.sun.istack.internal.NotNull;
import creatures.*;
import teller.Teller;

/**
 * Interface of the Wonderland event
 */
public interface Event {
    /**
     * @brief Get information about an event
     * @return - event description
     */
    String getInformationAboutEvent();

    /**
     * @brief Initializing event participants
     */
    void initializeParticipants(Teller teller);

    /**
     * @brief Executing an event
     * @param introduction - String describing the event
     */
    void performEvent(String introduction);

    /**
     * @brief Getter of Alice
     * @return - Alice class object
     */
    Alice getAlice();

    /**
     * Getter of Birds
     * @return - Array of Birds
     */
    Bird[] getBirds();

    /**
     * Getting participants from outside
     * @param alice - an object of Alice class
     * @param birds - Array of Birds
     */
    void setParticipants(@NotNull Alice alice, @NotNull Bird[] birds);
}