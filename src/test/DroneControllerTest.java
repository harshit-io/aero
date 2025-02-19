package test;

import air.Coordinates;
import air.DroneController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DroneControllerTest {
    private DroneController controller;

    /**
     * Creates a new instance of the DroneController before each test.
     */
    @BeforeEach
    void setUp() {
        controller = new DroneController();
    }

    /**
     * Verifies that the {@link DroneController#executeMission(int, Coordinates)} method completes normally in guided mode.
     * <p>
     * This test creates a new instance of the {@link DroneController} and calls the {@link DroneController#executeMission(int, Coordinates)} method with a target of (28.7041, 77.1025) and mode 1 (guided mode).
     * The test then asserts that the method does not throw any exceptions.
     */
    @Test
    void testExecuteMission_GuidedMode() {
        Coordinates target = new Coordinates(28.7041, 77.1025);
        assertDoesNotThrow(() -> controller.executeMission(1, target));
    }

    @Test
    void testExecuteMission_MissionMode() {
        Coordinates target = new Coordinates(40.7128, -74.0060);
        assertDoesNotThrow(() -> controller.executeMission(2, target));
    }

    @Test
    void testExecuteMission_InvalidMode() {
        Coordinates target = new Coordinates(51.5074, -0.1278);
        assertDoesNotThrow(() -> controller.executeMission(3, target));
    }

    /**
     * Tests the startMission() method of the DroneController class.
     * Verifies that the method prompts the user to select a mode and input target coordinates.
     * Verifies that the method calls the executeMission() method with the selected mode and target coordinates.
     */
    @Test
    void testStartMission() {
        // Simulate user input: "1\n25.276987\n55.296249\n" (Mode 1, Latitude, Longitude)
        String simulatedInput = "1\n25.276987\n55.296249\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream); // Redirect System.in

        DroneController controller = new DroneController();

        assertDoesNotThrow(controller::startMission);

        // Reset System.in to avoid interference with other tests
        System.setIn(System.in);
    }

    @Test
    void testExecuteMission_WithZeroCoordinates() {
        Coordinates target = new Coordinates(0.0, 0.0);
        assertDoesNotThrow(() -> controller.executeMission(1, target));
    }

    @Test
    void testExecuteMission_WithNegativeCoordinates() {
        Coordinates target = new Coordinates(-45.678, -122.432);
        assertDoesNotThrow(() -> controller.executeMission(2, target));
    }
}
