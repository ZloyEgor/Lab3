package creatures;

import enums.Mood;

/**
 * Interface of creature from Wonderland
 */
public interface Creature {

    /**
     * @brief Get the name of the creature
     * @return - creature name
     */
    String getName();

    /**
     * @brief get a string describing the new mood of the creature
     * @param mood - new mood of the creature
     * @return - string describing the new mood of the creature
     */
    String updateMood(Mood mood);

    /**
     * @brief Taking part in a tea party
     */
    void takePartInFeast();
}