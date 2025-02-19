package air;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Main class that handles the drone attack simulation
 *
 * @author SimDev
 * @version 1.0
 */
public class DroneController {
    private DroneLauncher launcher;
    private MissionControl missionControl;
    private NavigationSystem navigation;

    public DroneController() {
        this.launcher = new DroneLauncher();
        this.missionControl = new MissionControl();
        this.navigation = new NavigationSystem();
    }

    /**
     * The main entry point for the drone attack simulation.
     * <p>
     * This method creates a new instance of the {@link DroneController} and calls the {@link #startMission()} method to start the simulation.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DroneController controller = new DroneController();
        controller.startMission();
    }

    /**
     * Starts the drone attack simulation.
     * <p>
     * This method prompts the user to select a mode and input target coordinates.
     * It then calls the {@link #executeMission(int, Coordinates)} method to execute the mission.
     */
    public void startMission() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to AirFast Drone Control System");
        System.out.println("Select Mode:");
        System.out.println("1. Guided Mode");
        System.out.println("2. Mission Mode");

        int mode = scanner.nextInt();

        System.out.println("Enter target coordinates:");
        System.out.print("Latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitude = scanner.nextDouble();

        Coordinates target = new Coordinates(latitude, longitude);
        executeMission(mode, target);
    }

    /**
     * Executes a drone attack simulation.
     * <p>
     * This method simulates a drone attack mission by launching the drone, navigating to the target, executing the attack, and returning to base.
     * It takes two parameters: the mode of the mission (1 for guided mode, 2 for mission mode) and the target coordinates.
     * The method sleeps for 2 seconds after launch, 1 second after navigation, and 1 second after the attack.
     * If the mission is interrupted, the method prints a message and aborts the mission.
     *
     * @param mode   the mode of the mission (1 for guided mode, 2 for mission mode)
     * @param target the target coordinates
     */
    public void executeMission(int mode, Coordinates target) {
        try {
            launcher.initializeLaunch();
            TimeUnit.SECONDS.sleep(2);

            launcher.launch();
            TimeUnit.SECONDS.sleep(1);

            navigation.navigateToTarget(target);
            TimeUnit.SECONDS.sleep(2);

            if (mode == 1) {
                missionControl.executeGuidedAttack(target);
            } else {
                missionControl.executeMissionAttack(target);
            }
            TimeUnit.SECONDS.sleep(1);

            navigation.returnToBase();
            TimeUnit.SECONDS.sleep(2);

            launcher.land();
        } catch (InterruptedException e) {
            System.out.println("Mission aborted due to interruption");
        }
    }
}