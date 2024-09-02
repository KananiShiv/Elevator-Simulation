
/**
 * The Elevator class represents an elevator in a building. It keeps track of
 * the current floor, elevator state, and the current request it is serving.
 * It provides methods to set and retrieve the elevator properties, and to
 * convert the elevator state to a string representation.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 **/

public class Elevator {

    private int currentFloor; // The current floor of the elevator
    public static final int IDLE = 0; // Constant representing idle state
    public static final int TO_SOURCE = 1; // Constant representing moving towards the source floor state
    public static final int TO_DESTINATION = 2; // Constant representing moving towards the destination floor state
    private int elevatorState; // The current state of the elevator
    private Request request; // The request the elevator is serving

    /**
     * Constructs an Elevator object with default values for currentFloor,
     * elevatorState, and request.
     */
    public Elevator() {
        this.currentFloor = 1;
        this.elevatorState = IDLE;
        this.request = null;
    }

    /**
     * Gets the current floor of the elevator.
     *
     * @return The current floor of the elevator
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Sets the current floor of the elevator.
     *
     * @param currentFloor The current floor of the elevator
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Gets the elevator state.
     *
     * @return The elevator state (IDLE, TO_SOURCE, or TO_DESTINATION)
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Sets the elevator state.
     *
     * @param elevatorState The elevator state (IDLE, TO_SOURCE, or TO_DESTINATION)
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Gets the current request the elevator is serving.
     *
     * @return The current request the elevator is serving
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets the current request the elevator is serving.
     *
     * @param request The current request the elevator is serving
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Returns a string representation of the Elevator object in the format
     * "Elevator[currentFloor, elevatorState, request]".
     *
     * @return A string representation of the Elevator object
     */
    public String toString() {
        String state;
        switch (elevatorState) {
            case IDLE:
                state = "IDLE";
                break;
            case TO_SOURCE:
                state = "TO_SOURCE";
                break;
            case TO_DESTINATION:
                state = "TO_DESTINATION";
                break;
            default:
                state = " ";
        }
        return "Elevator[" + currentFloor + ", " + state + ",  " + request + "]";
    }
}
