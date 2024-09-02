
/**
 * The Request class represents a request made by an elevator passenger to move
 * from one floor to another. Each request has a source floor, destination
 * floor, and the time at which it was entered. The class also provides methods
 * to set and retrieve the properties of a request. The source and destination
 * floors are randomly generated within a given total number of floors.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 **/

public class Request {

    private int sourceFloor; // The source floor of the request
    private int destinationFloor; // The destination floor of the request
    private int timeEntered; // The time at which the request was entered

    /**
     * Constructs a Request object with randomly generated source and destination
     * floors
     * within the range of 1 to the totalFloors (inclusive).
     *
     * @param totalFloors The total number of floors in the building
     */
    public Request(int totalFloors) {
        // Generate a random source floor within the range of 1 to totalFloors
        // (inclusive)
        sourceFloor = (int) (Math.random() * totalFloors) + 1;

        // Generate a random destination floor within the range of 1 to totalFloors
        // (inclusive),
        destinationFloor = (int) (Math.random() * totalFloors) + 1;
        
    }

    /**
     * Gets the source floor of the request.
     *
     * @return The source floor of the request
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Sets the source floor of the request.
     *
     * @param sourceFloor The source floor of the request
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destination floor of the request.
     *
     * @return The destination floor of the request
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Sets the destination floor of the request.
     *
     * @param destinationFloor The destination floor of the request
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets the time at which the request was entered.
     *
     * @return The time at which the request was entered
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * Sets the time at which the request was entered.
     *
     * @param timeEntered The time at which the request was entered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    /**
     * Returns a string representation of the Request object in the format
     * "Request(sourceFloor, destinationFloor, timeEntered)".
     *
     * @return A string representation of the Request object
     */
    public String toString() {
        return "Request(" + sourceFloor + ", " + destinationFloor + ", " + timeEntered + ")";
    }
}
