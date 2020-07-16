package Driving;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TeleporterTest {

    Teleporter tp;

    @Before
    public void setUp() throws Exception {
        this.tp = new Teleporter();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 0.00;

        // Act
        Double actual = tp.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 0.0;

        // Act
        tp.transport(30.0);
        tp.transport(30.0);
        Double actual = tp.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 0;

        // Act
        Integer actual = tp.transport(9999999.9);

        // Assert
        assertEquals(expected, actual);
    }

}