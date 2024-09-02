
import java.util.ArrayList;

/**
 * The Simulator class is responsible for simulating elevator and request
 * interactions. It utilizes the BooleanSource and Request classes to
 * generate and process requests, and the Elevator class to simulate the
 * behavior of elevators. It also contains methods to print the simulation
 * results. It also has a debug option which if enabled will print out the
 * detailed steps carried out during the simulation.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 **/

public class Simulator {

    private static boolean debug = true;

    /**
     * Simulates the elevator and request interactions based on the provided
     * parameters.
     *
     * @param probabilityFromUser The probability of a new request arriving in each
     *                            second
     * @param floorsFromUser      The total number of floors in the building
     * @param numOfElevators      The number of elevators in the building
     * @param timeLength          The total length of the simulation (in seconds)
     */
    public static void simulate(double probabilityFromUser, int floorsFromUser, int numOfElevators, int timeLength) {

        // A request queue to store incoming requests
        RequestQueue requestQueue = new RequestQueue();

        // A BooleanSource object to simulate new requests arriving
        BooleanSource newRequestArrived = new BooleanSource(probabilityFromUser);

        // An array list to store elevators
        ArrayList<Elevator> elevators = new ArrayList<>();
        for (int i = 0; i < numOfElevators; i++) {
            elevators.add(new Elevator());
        }

        int customersWaitTime = 0;
        int totalRequests = 0;
        int currentSecond;

        for (currentSecond = 1; currentSecond <= timeLength; currentSecond++) {

            // Check if a new request has arrived and enqueue it
            if (newRequestArrived.requestArrived()) {
                Request newRequest = new Request(floorsFromUser);
                newRequest.setTimeEntered(currentSecond);
                requestQueue.enqueue(newRequest);

                if (debug) {
                    System.out.println("Request arrived: " + newRequest);
                }
            }

            // Process requests based on their elevatorState
            for (int i = 0; i < elevators.size(); i++) {
                Elevator elevator = elevators.get(i);
                switch (elevator.getElevatorState()) {
                    case Elevator.IDLE:
                        // If elevator is idle, assign it the next request in the queue
                        if (!requestQueue.isEmpty()) {
                            Request nextRequest = requestQueue.dequeue();
                            elevator.setRequest(nextRequest);
                            int sourceFloor = nextRequest.getSourceFloor();
                            int currentFloor = elevator.getCurrentFloor();
                            if (sourceFloor > currentFloor) {
                                elevator.setElevatorState(Elevator.TO_SOURCE);
                                elevator.setCurrentFloor(currentFloor + 1);
                            } else if (sourceFloor < currentFloor) {
                                elevator.setElevatorState(Elevator.TO_SOURCE);
                                elevator.setCurrentFloor(currentFloor - 1);
                            } else { // add the case where source = destination floor
                                int destinationFloor = elevator.getRequest().getDestinationFloor();
                                if (destinationFloor == sourceFloor) {
                                    totalRequests++;
                                    elevator.setElevatorState(Elevator.IDLE);
                                }
                                
                                else {
                                    if (destinationFloor > currentFloor) {
                                        elevator.setCurrentFloor(currentFloor + 1);
                                    } else if (destinationFloor < currentFloor) {
                                        elevator.setCurrentFloor(currentFloor - 1);
                                    }
                                    // Calculate customer waiting time and update total waiting time
                                    int waitingTime = currentSecond - elevator.getRequest().getTimeEntered();
                                    customersWaitTime += waitingTime;
                                    elevator.setElevatorState(Elevator.TO_DESTINATION);
                                }
                                if (debug)
                                    System.out.println("Customer total wait time: " + customersWaitTime);
                                totalRequests++;
                                

                            }
                        }
                        break;

                    case Elevator.TO_SOURCE:
                        // Move elevator towards the source floor
                        int sourceFloor = elevator.getRequest().getSourceFloor();
                        int currentFloor = elevator.getCurrentFloor();
                        if (sourceFloor > currentFloor) {
                            elevator.setCurrentFloor(currentFloor + 1);
                        } else if (sourceFloor < currentFloor) {
                            elevator.setCurrentFloor(currentFloor - 1);
                        } else {
                            // If the elevator reaches the source floor, change state to TO_DESTINATION
                            elevator.setElevatorState(Elevator.TO_DESTINATION);
                            // Calculate customer waiting time and update total waiting time
                            int waitingTime = currentSecond - elevator.getRequest().getTimeEntered();
                            customersWaitTime += waitingTime;
                            if (debug)
                                System.out.println("Customer total wait time: " + customersWaitTime);
                            totalRequests++;
                            int destinationFloor = elevator.getRequest().getDestinationFloor();
                            if (destinationFloor > currentFloor) {
                                elevator.setCurrentFloor(currentFloor + 1);
                            } else if (destinationFloor < currentFloor) {
                                elevator.setCurrentFloor(currentFloor - 1);

                            }

                        }
                        break;

                    case Elevator.TO_DESTINATION:
                        // Move elevator towards the destination floor
                        int destinationFloor = elevator.getRequest().getDestinationFloor();
                        currentFloor = elevator.getCurrentFloor();
                        if (destinationFloor > currentFloor) {
                            elevator.setCurrentFloor(currentFloor + 1);
                            int floorsLeft = elevator.getCurrentFloor();
                            if (floorsLeft == destinationFloor)
                                elevator.setElevatorState(Elevator.IDLE);
                        } else if (destinationFloor < currentFloor) {
                            elevator.setCurrentFloor(currentFloor - 1);
                            int floorsLeft = elevator.getCurrentFloor();
                            if (floorsLeft == destinationFloor)
                                elevator.setElevatorState(Elevator.IDLE);
                        } else {
                            // If the elevator reaches the destination floor, change state to IDLE
                            elevator.setElevatorState(Elevator.IDLE);
                        }
                        break;
                }
            }

            // Print details if debug mode is enabled
            if (debug) {
                System.out.println("Step " + currentSecond + ":");
                System.out.println("Requests: " + requestQueue);
                System.out.print("Elevators: ");
                for (Elevator elevator : elevators) {
                    System.out.print(elevator + ", ");
                }
                System.out.println("");

            }
        }

        // Calculate and print simulation results
        double avgWaitTime = (double) customersWaitTime / totalRequests;

        System.out.println("END OF SIMULATION");
        System.out.println("Total Wait Time: " + customersWaitTime);
        System.out.println("Total Requests: " + totalRequests);
        System.out.printf("Average Wait Time: %.2f\n", avgWaitTime);

    }
}
