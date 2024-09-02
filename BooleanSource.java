
/**
 * The BooleanSource class represents a source of boolean events with a given
 * probability. It allows users to simulate random events based on the
 * probability provided during object creation.
 * 
 * Note: This class has been referred from Queues (Chapter 7): BooleanSource.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 **/

public class BooleanSource {

    private double probability;

    /**
     * Constructs a BooleanSource object with the given probability of an event
     * occurring.
     *
     * @param probabilityEntered The probability of an event occurring (must be
     *                           between 0.0 and 1.0)
     * @throws IllegalArgumentException If the provided probability is outside the
     *                                  valid range [0.0, 1.0]
     */
    public BooleanSource(double probabilityEntered) throws IllegalArgumentException {
        if (probabilityEntered < 0.0 || probabilityEntered > 1.0)
            throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        probability = probabilityEntered;
    }

    /**
     * Simulates the arrival of an event based on the probability.
     *
     * @return true if the event occurs, false otherwise
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
}
