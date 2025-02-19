package air;

/**
 * Handles navigation and routing
 */
public class NavigationSystem {
    /**
     * Navigates to a target location.
     * <p>
     * This method simulates the navigation process by calculating a route to the target location and
     * then following the route. It prints out a message indicating the progress of the navigation:
     * "Navigating to target: [target location]". It then prints out "Route calculated" and
     * "Target reached".
     *
     * @param target the target location to navigate to
     */
    public void navigateToTarget(Coordinates target) {
        System.out.println("Navigating to target: " + target);
        System.out.println("Route calculated");
        System.out.println("Target reached");
    }

    /**
     * Returns the drone to its base.
     * <p>
     * This method simulates the return process by calculating a route back to the base and
     * then following the route. It prints out a message indicating the progress of the return:
     * "Return sequence initiated", "Calculating return route", and "Returning to base".
     */
    public void returnToBase() {
        System.out.println("Return sequence initiated");
        System.out.println("Calculating return route");
        System.out.println("Returning to base");
    }
}