package air;

/**
 * Handles the launching and landing operations
 */
public class DroneLauncher {
    /**
     * Initializes the launch sequence and runs a systems check.
     */
    public void initializeLaunch() {
        System.out.println("Initializing launch sequence...");
        System.out.println("Systems check: OK");
    }

    /**
     * Initiates the launch sequence.
     * <p>
     * This method first prints out a message indicating that the launch sequence has been initiated.
     * Then it prints out a message indicating that the takeoff has been successful.
     */
    public void launch() {
        System.out.println("Launch sequence initiated");
        System.out.println("Takeoff successful");
    }

    /**
     * Initiates the landing sequence.
     * <p>
     * This method first prints out a message indicating that the landing sequence has been initiated.
     * Then it prints out a message indicating that the landing has been successful.
     */
    public void land() {
        System.out.println("Landing sequence initiated");
        System.out.println("Landing successful");
    }
}