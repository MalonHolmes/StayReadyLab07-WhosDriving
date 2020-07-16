package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SantaCruzBikeTest {

    Bike sc;

    @Before
    public void setUp() throws Exception {
        sc = new SantaCruzBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 28.5;

        // Act
        Double actual = sc.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 26.5;

        // Act
        sc.transport(30.0);
        sc.transport(30.0);
        Double actual = sc.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 28.5;

        // Act
        sc.transport(30 * 2.0);
        sc.inflateTires();
        Double actual = sc.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = sc.transport(28.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        sc.transport(30.0 * 2);
        Integer actual = sc.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        sc.transport(30.0 * 3);
        Integer actual = sc.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        sc.transport(30.0 * 100);
        sc.transport(30.0 * 2);
        Integer actual = sc.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        sc.transport(29.9);
        sc.transport(29.9);
        sc.transport(29.9);
        sc.transport(29.9);
        sc.transport(29.9);
        sc.transport(29.9);
        Integer actual = sc.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = sc.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        sc.transport(30.0 * 3);
        Integer tirePressureAfterTransport = sc.getTirePressure();

        sc.inflateTires();
        Integer actual = sc.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = sc.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

}