package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CadillacEscaladeTest {

    Car cadillac;

    @Before
    public void setUp() throws Exception {
        cadillac = new CadillacEscalade();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = cadillac.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        cadillac.transport(50000.0);
        // Act
        Boolean needsOilAfter50kMiles = cadillac.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        cadillac.transport(50010.5);
        // Act
        cadillac.changeOil();
        Boolean needsOilChangeAfterOilChange = cadillac.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        cadillac.transport(51000.0);
        // Act
        cadillac.changeOil();
        cadillac.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = cadillac.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel50kMiles() {
        // Arrange
        cadillac.transport(51000.0);
        // Act
        cadillac.changeOil();
        cadillac.transport(50000.0);
        Boolean oilNeedsChanging50kMiles = cadillac.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging50kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        cadillac.transport(50000.0);
        // Act
        Boolean checkEngineLightIsOn = cadillac.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        cadillac.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = cadillac.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 70.0;
        // Act
        Double actual = cadillac.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = cadillac.transport(70.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        cadillac.transport(300.0);
        Double actual = cadillac.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = cadillac.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
