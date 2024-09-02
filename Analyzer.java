
import java.util.Scanner;

/**
 * The Analyzer class is responsible for obtaining user input and initiating the
 * elevator simulation. It prompts the user to input various parameters, such
 * as probability of request arrival, number of floors, number of elevators,
 * and the length of the simulation. It then uses the Simulator class to
 * simulate the requests on the elevators.
 * 
 * This class is part of Homework #3 for CSE 214, Summer 2023.
 * 
 * @author Shiv Kanani
 *         SBU ID: 115171965
 **/

public class Analyzer {

    /**
     * The main method that starts the elevator simulation.
     * 
     * @param args The command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Elevator simulator!");

            // Get probability of request arrival from the user
            double probabilityFromUser;
            while (true) {
                System.out.print("Please enter the probability of arrival for Requests (between 0.0 and 1.0): ");
                probabilityFromUser = scanner.nextDouble();
                if (probabilityFromUser >= 0.0 && probabilityFromUser <= 1.0) {
                    break;
                }
                System.out.println("Invalid probability. The probability must be between 0.0 and 1.0.");
            }

            // Get number of floors in the building from the user
            int numFloorsFromUser;
            while (true) {
                System.out.print("Please enter the number of floors in the building (greater than 1): ");
                numFloorsFromUser = scanner.nextInt();
                if (numFloorsFromUser > 1) {
                    break;
                }
                System.out.println("Invalid number of floors. The number of floors must be greater than 1.");
            }

            // Get number of elevators in the building from the user
            int numElevatorsFromUser;
            while (true) {
                System.out.print("Please enter the number of elevators in the building (greater than 0): ");
                numElevatorsFromUser = scanner.nextInt();
                if (numElevatorsFromUser > 0) {
                    break;
                }
                System.out.println("Invalid number of elevators. The number of elevators must be greater than 0.");
            }

            // Get length of the simulation from the user
            int lengthFromUser;
            while (true) {
                System.out.print("Please enter the length of the simulation in time units (greater than 0): ");
                lengthFromUser = scanner.nextInt();
                if (lengthFromUser > 0) {
                    break;
                }
                System.out.println("Invalid simulation length. The simulation length must be greater than 0.");
            }

            // Initiate the elevator simulation with the user-provided parameters
            Simulator.simulate(probabilityFromUser, numFloorsFromUser, numElevatorsFromUser, lengthFromUser);

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
