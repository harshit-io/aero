package air;

/**
 * Handles mission control and attack execution
 */
public class MissionControl {
    /**
     * Executes a guided attack at the specified target coordinates.
     * <p>
     * This method prints out messages indicating that guided mode is engaged,
     * the target has been locked, and the attack was successful.
     * @param target the target coordinates
     */
    public void executeGuidedAttack(Coordinates target) {
        System.out.println("Guided mode engaged");
        System.out.println("Target locked: " + target);
        System.out.println("Attack successful");
    }

    /**
     * Executes a pre-programmed attack sequence at the specified target coordinates.
     * <p>
     * This method prints out messages indicating that mission mode is engaged,
     * the pre-programmed attack sequence is being executed, and the attack was successful.
     * @param target the target coordinates
     */
    public void executeMissionAttack(Coordinates target) {
        System.out.println("Mission mode engaged");
        System.out.println("Executing pre-programmed attack sequence");
        System.out.println("Attack successful");
    }
}